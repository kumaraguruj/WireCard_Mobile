package com.attra.wirecard.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.attra.wirecard.R;
import com.attra.wirecard.activity.HomeActivity;
import com.attra.wirecard.activity.HomeActivityAlice;

public class ProfileInfoFragment extends Fragment {

    private TextView mFirstName, mLastName, mEmail, mUsername;
    String PREFS_NAME = "Pref Name";
    String user;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile_info, container, false);
        mFirstName = view.findViewById(R.id.firstName);
        mLastName = view.findViewById(R.id.lastName);
        mEmail = view.findViewById(R.id.emailid);
        mUsername = view.findViewById(R.id.username);

        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        user = pref.getString("username", "");
        System.out.println("user: " +user);

        if (user.equals("Bob")) {
            mFirstName.setText("Bob");
            mLastName.setText("Harry");
            mEmail.setText("Bob@wirecard.com");
            mUsername.setText("BobWireCard");
        } else if (user.equals("Alice")){
            mFirstName.setText("Alice");
            mLastName.setText("David");
            mEmail.setText("Alice@wirecard.com");
            mUsername.setText("AliceWireCard");
        }
        return view;
    }

}
