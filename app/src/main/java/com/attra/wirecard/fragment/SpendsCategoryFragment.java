package com.attra.wirecard.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.attra.wirecard.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpendsCategoryFragment extends Fragment {

    private ImageView mIcon;
    String PREFS_NAME = "Pref Name";
    String user;
    public SpendsCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_spends_category, container, false);
        mIcon = view.findViewById(R.id.reportMon);

        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        user = pref.getString("username", "");
        System.out.println("user: " +user);
        if (user.equals("Bob")) {
            mIcon.setImageDrawable(getResources().getDrawable(R.drawable.bobmonthlyexpensee));
        } else if (user.equals("Alice")){
            mIcon.setImageDrawable(getResources().getDrawable(R.drawable.alicemonthlyexpense));
        }
        return view;
    }

}
