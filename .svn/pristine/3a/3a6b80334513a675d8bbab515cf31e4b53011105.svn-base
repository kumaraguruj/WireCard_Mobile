package com.attra.wirecard.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.attra.wirecard.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatementFragment extends Fragment {
    private Button mshowStatement;
    private TableLayout mStatementTable;
    Fragment fragment = null;
    String PREFS_NAME = "Pref Name";
    String user;
    View view;

    public StatementFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        /*mshowStatement = view.findViewById(R.id.showStatement);
        mStatementTable = view.findViewById(R.id.statementTable);
        *//*mCardNumber = view.findViewById(R.id.cardNumberforBob);*//*
        mCardSlect = view.findViewById(R.id.cardselect);
        mBal = view.findViewById(R.id.currentBal);*/
        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        user = pref.getString("username", "");
        System.out.println("user: " +user);

        if (user.equals("Bob")) {
            view = inflater.inflate(R.layout.statement_bob, container, false);
            mshowStatement = view.findViewById(R.id.showStatement);
            mStatementTable = view.findViewById(R.id.statementTable);
           /* mBal.setText("SGD 10302.78");
           *//* mCardNumber.setText("4448-XXX-XXXX-8743");
            mCardNumber.setVisibility(View.VISIBLE);*//*
            mCardSlect.setText("Card Number:");*/
        } else if (user.equals("Alice")){
            view = inflater.inflate(R.layout.fragment_statement_self, container, false);
            mshowStatement = view.findViewById(R.id.showStatement);
            mStatementTable = view.findViewById(R.id.statementTable);
           /* mBal.setText("USD 628.80");
            mCardSlect.setText("Select Card:");*/
        }

        mshowStatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStatementTable.setVisibility(View.VISIBLE);

            }
        });
        return view;
    }


}
