package com.example.stockexchangeapp;

import android.content.Context;
import android.os.Bundle;

import com.example.stockexchangeapp.StockAPIs.CompanyProfile2;
import com.example.stockexchangeapp.StockAPIs.JsonPlaceHolderApi;
import com.example.stockexchangeapp.StockAPIs.TickerSearch;
import com.example.stockexchangeapp.StockAPIs.URLbuilder;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stockexchangeapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private JsonPlaceHolderApi jsonPlaceHolderApi;


    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    private AlertDialog.Builder newStockPopupBuilder;
    private AlertDialog newStockPopup;
    private RecyclerView newStockRecyclerView;

    public SearchView newStockSearchView;
    public MutableLiveData<TickerSearch> liveTickerSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URLbuilder
                        .getBASE_URL())
                .addConverterFactory(GsonConverterFactory.create()).build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        liveTickerSearch = new MutableLiveData<>();

        liveTickerSearch.setValue(new TickerSearch()); //Initialize with a value

        liveTickerSearch.observe(this,new Observer<TickerSearch>() {
            @Override
            public void onChanged(TickerSearch tickerSearch) {
                if(tickerSearch.getResults() != null)
                    Log.i("variable changed", tickerSearch.getResults().toString());
                else
                    Log.i("variable empty","Live tickerSearch empty");
            }
        });


        /* Removed this to fix top bar from being fucked

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        */

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadNewStock();
                newStockSearchView.requestFocus();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    private void setRecyclerAdaptor(){

    }

    private void GetTickerSearch(String thesearch){

        Context context = this;
        String url = URLbuilder.GetURL(URLbuilder.REQUEST_TYPE.GetTickerSearch, thesearch);

        Call<TickerSearch> call = jsonPlaceHolderApi.GetTickerSearch(url);                          //This calls the class built from the searchticker code in PlaceholderAPi interface

        call.enqueue(new Callback<TickerSearch>() {                                                 //call.enqueue is a retrofit function to handle the asynchronous http call for us (MAGIC)
            @Override
            public void onResponse(Call<TickerSearch> call, Response<TickerSearch> response) {      //Anonymous function to ensure we have the enqueue response methods
                if (!response.isSuccessful()) {                                                     //Response can be unsuccessful from the server ex: 404 error codes
                    Toast.makeText(context, "Code: " + response.code(), Toast.LENGTH_LONG);
                    return;
                }


                Log.i("Search Results:","results:"+response.body().getResultCount());
                liveTickerSearch.setValue(new TickerSearch(response.body().getResultCount(), response.body().getResults()));
                return;
            }
            @Override
            public void onFailure(Call<TickerSearch> call, Throwable t) {
                Toast.makeText(context, "Code: " + t.getMessage(), Toast.LENGTH_LONG);
            }
        });
    }

    private void GetCompanyProfile2(String thesearch){

        Context context = this;
        String url = URLbuilder.GetURL(URLbuilder.REQUEST_TYPE.CompanyProfile2, thesearch);

        Call<CompanyProfile2> call = jsonPlaceHolderApi.GetCompanyProfile2(url);                          //This calls the class built from the searchticker code in PlaceholderAPi interface

        call.enqueue(new Callback<CompanyProfile2>() {                                                 //call.enqueue is a retrofit function to handle the asynchronous http call for us (MAGIC)
            @Override
            public void onResponse(Call<CompanyProfile2> call, Response<CompanyProfile2> response) {      //Anonymous function to ensure we have the enqueue response methods
                if (!response.isSuccessful()) {                                                     //Response can be unsuccessful from the server ex: 404 error codes
                    Toast.makeText(context, "Code: " + response.code(), Toast.LENGTH_LONG);
                    return;
                }


                return;
            }
            @Override
            public void onFailure(Call<CompanyProfile2> call, Throwable t) {
                Toast.makeText(context, "Code: " + t.getMessage(), Toast.LENGTH_LONG);
            }
        });
    }

    private void loadNewStock(){

        newStockPopupBuilder = new AlertDialog.Builder(this);                                // Add support code to create a popup
        final View newStockPopupView = getLayoutInflater()                                          // Attach the layout to the inflater
                                       .inflate(R.layout.popup_add_new_stock, null);

        newStockSearchView = (SearchView)newStockPopupView.findViewById(R.id.newStockSearchView);   // link search view to search view variable

        newStockSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                GetTickerSearch(newText);

                return false;
            }
        });

        newStockPopupBuilder.setView(newStockPopupView);                                            //link builder to the popup
        newStockPopup = newStockPopupBuilder.create();                                              //run the builder
        newStockPopup.show();                                                                       //display the view
    }
}// Milk duds