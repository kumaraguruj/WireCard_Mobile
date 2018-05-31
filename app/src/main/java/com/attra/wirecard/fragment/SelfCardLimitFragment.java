package com.attra.wirecard.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.attra.wirecard.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelfCardLimitFragment extends Fragment {
    private Button mselfLimit;

    public SelfCardLimitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_self_card_limit, container, false);
        mselfLimit = view.findViewById(R.id.selfLimit);
        mselfLimit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callLogout();
            }
        });
        return view;
    }
    private void callLogout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Control Spends");
        builder.setMessage("Changes has been set. Please visit our web page for more info.")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
