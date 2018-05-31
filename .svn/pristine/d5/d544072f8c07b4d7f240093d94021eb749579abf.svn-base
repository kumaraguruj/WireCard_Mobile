package com.attra.wirecard.fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.attra.wirecard.R;
import com.attra.wirecard.activity.HomeActivity;
import com.attra.wirecard.activity.HomeActivityAlice;
import com.attra.wirecard.activity.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class GeneratePin extends Fragment {

    private Button mpinchange;
    private EditText mOldpin, mNewPIn, mConfrmPin;
    String[] cardNumAlice = {"4448-8565-4331-5518", "4448-8865-4332-5500"};
    String[] cardNumBob = {"Select","4448-XXX-XXXX-8743"};
    Spinner Card;
    String PREFS_NAME = "Pref Name";
    String user;
    View view;

    public GeneratePin() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       /* View view =  inflater.inflate(R.layout.fragment_generate_pin, container, false);
        mpinchange = view.findViewById(R.id.pinchange);
        mOldpin = view.findViewById(R.id.oldpin);
        mNewPIn = view.findViewById(R.id.newpin);
        mConfrmPin = view.findViewById(R.id.confirmpin);

        Card = view.findViewById(R.id.spinnerIn);*/

        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        user = pref.getString("username", "");
        System.out.println("user: " +user);
        if (user.equals("Bob")) {
            view =  inflater.inflate(R.layout.fragment_generate_pin_bob, container, false);
            mpinchange = view.findViewById(R.id.pinchange);
            mOldpin = view.findViewById(R.id.oldpin);
            mNewPIn = view.findViewById(R.id.newpin);
            mConfrmPin = view.findViewById(R.id.confirmpin);

        } else if (user.equals("Alice")){
            view =  inflater.inflate(R.layout.fragment_generate_pin, container, false);
            mpinchange = view.findViewById(R.id.pinchange);
            mOldpin = view.findViewById(R.id.oldpin);
            mNewPIn = view.findViewById(R.id.newpin);
            mConfrmPin = view.findViewById(R.id.confirmpin);
            Card = view.findViewById(R.id.spinnerIn);

            final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, cardNumAlice);
            Card.setAdapter(adapter2);
        }
        mpinchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callLogout();
            }
        });
        return view;
    }
    private void callLogout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Set Pin");
        builder.setMessage("Your pin has been changed successfully.")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        mOldpin.setText("");
                        mNewPIn.setText("");
                        mConfrmPin.setText("");
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
