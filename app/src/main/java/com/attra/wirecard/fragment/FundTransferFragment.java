package com.attra.wirecard.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.attra.wirecard.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FundTransferFragment extends Fragment {

    String PREFS_NAME = "Pref Name";
    String user;

    public FundTransferFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fund_transfer, container, false);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs_funds);
        tabLayout.addTab(tabLayout.newTab().setText("A"));
        tabLayout.addTab(tabLayout.newTab().setText("B"));

        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        user = pref.getString("username", "");
        System.out.println("user: " +user);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager_funds);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        viewPager.setAdapter(new PagerAdapter(getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Fund Transfer");

    }
    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = null;
            if (position == 0)
            {
                if (user.equals("Bob")) {
                    title = "Load Wallet";
                } else if (user.equals("Alice")){
                    title = "Auto Pay";
                }
            }
            else if (position == 1)
            {
                if (user.equals("Bob")) {
                    title = "Wallet Transfer";
                } else if (user.equals("Alice")){
                    title = "Balance Transfer";
                }
            }
            return title;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    if (user.equals("Bob")) {
                        return new Loadwallet_bob();
                    } else if (user.equals("Alice")){
                        return new Autopay_Alice();
                    }
                case 1:
                    if (user.equals("Bob")) {
                        return new WalletTransfer();
                    } else if (user.equals("Alice")){
                        return new Balancetransfer_ALice();
                    }
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }

}
