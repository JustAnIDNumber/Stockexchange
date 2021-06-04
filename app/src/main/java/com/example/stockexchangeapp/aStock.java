package com.example.stockexchangeapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link aStock#newInstance} factory method to
 * create an instance of this fragment.
 */
public class aStock extends Fragment {


    private static final String ARG_PARAM1 = "tickerSymbol";
    private static final String ARG_PARAM2 = "percentChange";
    private static final String ARG_PARAM3 = "currentPrice";


    private static String symbol;
    private static String change;
    private static String price;

    public aStock() {
        // Required empty public constructor
    }


    public static aStock newInstance(String tickerSymbol, String percentChange, String currentPrice) {

        aStock fragment = new aStock();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, symbol);
        args.putString(ARG_PARAM2, change);
        args.putString(ARG_PARAM3, price);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            symbol = getArguments().getString(ARG_PARAM1);
            change = getArguments().getString(ARG_PARAM2);
            price = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a_stock, container, false);
    }
}