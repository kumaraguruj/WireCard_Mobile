package com.attra.wirecard.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.attra.wirecard.R;
import com.attra.wirecard.fragment.FundTransferFragment;
import com.attra.wirecard.fragment.LandingFragment;
import com.attra.wirecard.fragment.OverviewFragment;
import com.attra.wirecard.fragment.ParentReportsFragment;
import com.attra.wirecard.fragment.ReportsFragment;
import com.attra.wirecard.fragment.SelfServiceFragment;
import com.attra.wirecard.fragment.WalletTransfer;

public class HomeActivityAlice extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,TabLayout.OnTabSelectedListener{

    Fragment fragment = null;
    private TabLayout tabLayout;

    //This is our viewPager
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_alice);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        /*//Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout2);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Card Summary"));
        tabLayout.addTab(tabLayout.newTab().setText("Transactions"));
        tabLayout.addTab(tabLayout.newTab().setText("Profile Info"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        tabLayout.setOnTabSelectedListener(this);

        tabLayout.setupWithViewPager(viewPager);*/
        fragment = new LandingFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame_alice, fragment).addToBackStack("goBack").commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home2) {
            fragment = new LandingFragment();
        } else if (id == R.id.overview) {
            fragment = new OverviewFragment();
        }else if (id == R.id.selfservice) {
            fragment = new SelfServiceFragment();
        }else if (id == R.id.nav_fund) {
            fragment = new FundTransferFragment();
        } else if (id == R.id.reports) {
            fragment = new ParentReportsFragment();
        } /*else if (id == R.id.averageBal) {

        } else if (id == R.id.expenseCat) {

        }*/ else if (id == R.id.logout) {
            callLogout();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame_alice, fragment).addToBackStack("goBack").commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

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
    private void callLogout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setMessage("Do you want to logout?")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(HomeActivityAlice.this, LoginActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
    public void loadFragment(String message){
        if (message.equals("overview")){
            fragment = new OverviewFragment();
        }
        if (message.equals("selfervice")){
            fragment = new SelfServiceFragment();
        }
        if (message.equals("fundstransfer")){
            fragment = new FundTransferFragment();
        }
        if (message.equals("reports")){
            fragment = new ParentReportsFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame_alice, fragment).addToBackStack("goBack").commit();
    }
}
