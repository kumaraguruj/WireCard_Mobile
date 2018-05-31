package com.attra.wirecard.fragment;


import android.content.Context;
import android.content.DialogInterface;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class BlockCard extends Fragment {

    private EditText mRemarks;
    private Button mSubmit;
    Spinner selectCard;

    String[] cardNumBob = {"Select","4448-XXX-XXXX-8743"};
    String[] cardNumAlice = {"Select","4448-8565-4331-5518", "4448-8865-4332-5500"};
    String PREFS_NAME = "Pref Name";
    String user;
    View view;
    public BlockCard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*View view =  inflater.inflate(R.layout.fragment_block_card, container, false);
        selectCard = view.findViewById(R.id.spinblock);
        mRemarks = view.findViewById(R.id.remarks);
        mSubmit = view.findViewById(R.id.blockbtn);*/

        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        user = pref.getString("username", "");
        System.out.println("user: " +user);
        if (user.equals("Bob")) {
            view =  inflater.inflate(R.layout.fragment_block_card_bob, container, false);
            mRemarks = view.findViewById(R.id.remarks);
            mSubmit = view.findViewById(R.id.blockbtn);
           /* final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, cardNumBob);
            selectCard.setAdapter(adapter2);*/
        } else if (user.equals("Alice")){
            view =  inflater.inflate(R.layout.fragment_block_card, container, false);
            selectCard = view.findViewById(R.id.spinblock);
            mRemarks = view.findViewById(R.id.remarks);
            mSubmit = view.findViewById(R.id.blockbtn);
            final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, cardNumAlice);
            selectCard.setAdapter(adapter2);
        }
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callLogout();
            }
        });
        return view;
    }

    private void callLogout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Block Card");
        builder.setMessage("Request to block the card has been received. Ref No:8796701")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mRemarks.setText("");
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

}
