package com.attra.wirecard.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.attra.wirecard.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WalletTransfer extends Fragment {

    String PREFS_NAME = "Pref Name";
    String user;

    public WalletTransfer() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wallettransfer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        user = pref.getString("username", "");
        System.out.println("user: " +user);

        if (user.equals("Bob")) {
            getActivity().setTitle("Funds Transfer");
        } else if (user.equals("Alice")){
            getActivity().setTitle("Funds Transfer");
        }

    }
}
