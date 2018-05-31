package com.attra.wirecard.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;

import com.attra.wirecard.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TransactionsFragment extends Fragment {

    private EditText mFromDate,mToDate;
    private Button mTransactBtn;
    Calendar myCalendar = Calendar.getInstance();
    /*String[] transaTypeBob = {"Debit"};*/
    String[] transaTypeAlice = {"Both","Debit","Credit"};
    String[] cardNumBob = {"Select","4448-XXX-XXXX-8743"};
    String[] cardNumAlice = {"All","4448-8565-4331-5518", "4448-8865-4332-5500"};
    Spinner transactionType, Card;
    private TableLayout mStatementTable;
    String PREFS_NAME = "Pref Name";
    String user;
    View view;
    Spinner transaTypeBob;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       /* View view = inflater.inflate(R.layout.fragment_transactions, container, false);
        mFromDate = (EditText) view.findViewById(R.id.fromDate);
        mToDate = (EditText) view.findViewById(R.id.toDate);
        mTransactBtn = view.findViewById(R.id.transacbtn);
        transactionType = view.findViewById(R.id.spinnerTrans);
        Card = view.findViewById(R.id.spinnerCard);
        mStatementTable = view.findViewById(R.id.statementTable2);
        mshowStatement = view.findViewById(R.id.transacbtn);*/

        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        user = pref.getString("username", "");
        System.out.println("user: " +user);
        if (user.equals("Bob")) {
            view = inflater.inflate(R.layout.fragment_transactions_bob, container, false);
            mFromDate = (EditText) view.findViewById(R.id.fromDate);
            mToDate = (EditText) view.findViewById(R.id.toDate);
            mTransactBtn = view.findViewById(R.id.transacbtn_bob);
            transaTypeBob = view.findViewById(R.id.spinnerTrans_bob);
            mStatementTable = view.findViewById(R.id.statementTable2);
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, transaTypeAlice);
            transaTypeBob.setAdapter(adapter);


        } else if (user.equals("Alice")){
            view = inflater.inflate(R.layout.fragment_transactions, container, false);
            mFromDate = (EditText) view.findViewById(R.id.fromDate);
            mToDate = (EditText) view.findViewById(R.id.toDate);
            mTransactBtn = view.findViewById(R.id.transacbtn_alice);
            transactionType = view.findViewById(R.id.spinnerTrans);
            Card = view.findViewById(R.id.spinnerCard);
            mStatementTable = view.findViewById(R.id.statementTable2);

            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, transaTypeAlice);
            transactionType.setAdapter(adapter);

            final ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_dropdown_item_1line, cardNumAlice);
            Card.setAdapter(adapter2);
        }

        mTransactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*callLogout();*/
                mStatementTable.setVisibility(View.VISIBLE);
            }
        });
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
        int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };
        final DatePickerDialog.OnDateSetListener todate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel2();
            }

        };
        mToDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getActivity(), todate, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        mFromDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        return view;
    }
    private void callLogout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Transactions");
        builder.setMessage("Statement has been sent to your registered email-Id.")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mFromDate.setText("");
                        mToDate.setText("");
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        mFromDate.setText(sdf.format(myCalendar.getTime()));
    }
    private void updateLabel2() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        mToDate.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
