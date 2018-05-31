package com.attra.wirecard.fragment;


import android.app.ActionBar;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.attra.wirecard.R;
import com.attra.wirecard.activity.HomeActivity;
import com.attra.wirecard.activity.HomeActivityAlice;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandingFragment extends Fragment {
    private TextView mUserName, mAccount;

    private Button mOverview, mSelfservice, mFundstransfer, mReports;
    private ImageView mIcon, mChart;
    private TextView mHeading;
    Fragment fragment = null;
    String PREFS_NAME = "Pref Name";
    String user;
    public LandingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Wirecard");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_landing, container, false);
        mHeading = view.findViewById(R.id.heading_chart);
        mUserName = view.findViewById(R.id.userName);
        mAccount = view.findViewById(R.id.accBal);
        mIcon = view.findViewById(R.id.imageView2);
        mChart = view.findViewById(R.id.chartland);

        mOverview = view.findViewById(R.id.overviewbtn);
        mSelfservice = view.findViewById(R.id.servicebtn);
        mFundstransfer = view.findViewById(R.id.fundsbtn);
        mReports = view.findViewById(R.id.reportsbtn);


        /*ActionBar mActionBar = getActivity().getActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        LayoutInflater mInflater = LayoutInflater.from(getActivity());

        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);
        ImageButton imageButton = (ImageButton) mCustomView
                .findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "On the way",
                        Toast.LENGTH_LONG).show();
            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);*/

        SharedPreferences pref = getActivity().getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        user = pref.getString("username", "");
        System.out.println("user: " +user);
        if (user.equals("Bob")) {
            mUserName.setText("Welcome Bob Harry");
            mAccount.setText("Account Balance: SGD 10302.78");
            mIcon.setImageDrawable(getResources().getDrawable(R.drawable.bob));
            mChart.setImageDrawable(getResources().getDrawable(R.drawable.bobgraphland));
        } else if (user.equals("Alice")){
            mUserName.setText("Welcome Alice David");
            mAccount.setText("Account Balance: USD 628.80");
            mHeading.setVisibility(View.VISIBLE);
            mIcon.setImageDrawable(getResources().getDrawable(R.drawable.alice));
            mChart.setImageDrawable(getResources().getDrawable(R.drawable.alicegraphland));
        }
        mReports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.equals("Bob")) {
                    HomeActivity homeActivity = (HomeActivity) getActivity();
                    homeActivity.loadFragment("reports");
                } else if (user.equals("Alice")){
                    HomeActivityAlice homeActivity = (HomeActivityAlice) getActivity();
                    homeActivity.loadFragment("reports");
                }
            }
        });
        mOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.equals("Bob")) {
                    HomeActivity homeActivity = (HomeActivity) getActivity();
                    homeActivity.loadFragment("overview");
                } else if (user.equals("Alice")) {
                    HomeActivityAlice homeActivityAlice = (HomeActivityAlice) getActivity();
                    homeActivityAlice.loadFragment("overview");
                }
            }

        });
        mSelfservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.equals("Bob")) {
                    HomeActivity homeActivity = (HomeActivity) getActivity();
                    homeActivity.loadFragment("selfervice");
                }else if (user.equals("Alice")) {
                    HomeActivityAlice homeActivity = (HomeActivityAlice) getActivity();
                    homeActivity.loadFragment("selfervice");
                }
            }
        });
        mFundstransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.equals("Bob")) {
                    HomeActivity homeActivity = (HomeActivity) getActivity();
                    homeActivity.loadFragment("fundstransfer");
                }else if (user.equals("Alice")) {
                    HomeActivityAlice homeActivity = (HomeActivityAlice) getActivity();
                    homeActivity.loadFragment("fundstransfer");
                }
            }
        });
       /* TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabs_landing);
        tabLayout.addTab(tabLayout.newTab().setText("Overview"));
        tabLayout.addTab(tabLayout.newTab().setText("Self Service"));
        tabLayout.addTab(tabLayout.newTab().setText("Funds Transfer"));
        tabLayout.addTab(tabLayout.newTab().setText("Reports"));*/


        /*final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpagerlanding);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        viewPager.setAdapter(new PagerAdapter(getFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);*/

        /*tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                *//*viewPager.setCurrentItem(tab.getPosition());*//*
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/

        return view;
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
                title = "Card Summary";
            }
            else if (position == 1)
            {
                title = "Transactions";
            }
            else if (position == 2)
            {
                title = "Profile";
            }
            return title;
        }
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new CardSummaryFragment();
                case 1:
                    return new TransactionsFragment();
                case 2:
                    return new ProfileInfoFragment();

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
