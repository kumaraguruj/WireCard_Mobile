package com.attra.wirecard.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.attra.wirecard.fragment.CardSummaryFragment;
import com.attra.wirecard.fragment.ProfileInfoFragment;
import com.attra.wirecard.fragment.TransactionsFragment;

/**
 * Created by sirisha.kalluri on 5/23/2018.
 */

public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
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
            title = "Profile Info";
        }
        return title;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                CardSummaryFragment tab1 = new CardSummaryFragment();
                return tab1;
            case 1:
                TransactionsFragment tab2 = new TransactionsFragment();
                return tab2;
            case 2:
                ProfileInfoFragment tab3 = new ProfileInfoFragment();
                return tab3;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
