package com.attra.wirecard.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.app.ActionBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.attra.wirecard.R;
import com.attra.wirecard.fragment.FundTransferFragment;
import com.attra.wirecard.fragment.OverviewFragment;
import com.attra.wirecard.fragment.LandingFragment;
import com.attra.wirecard.fragment.ParentReportsFragment;
import com.attra.wirecard.fragment.ReportsFragment;
import com.attra.wirecard.fragment.SelfServiceFragment;
import com.attra.wirecard.fragment.WalletTransfer;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Fragment fragment = null;
    ActionBar actionbar;
    TextView textview;
    LayoutParams layoutparams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        fragment = new LandingFragment();
       /* Bundle args = new Bundle();
        args.putString("delegateId", delegateId);
        fragment.setArguments(args);*/
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("goBack").commit();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public void onBackPressed() {
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
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("goBack").commit();
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            fragment = new LandingFragment();
       /* Bundle args = new Bundle();
        args.putString("delegateId", delegateId);
        fragment.setArguments(args);*/

        } else if (id == R.id.nav_overview) {
            fragment = new OverviewFragment();
        } else if (id == R.id.nav_selfservice) {
            fragment = new SelfServiceFragment();
        } else if (id == R.id.nav_movemoney) {
            fragment = new FundTransferFragment();

        } else if (id == R.id.nav_reports) {
            fragment = new ParentReportsFragment();
        } /*else if (id == R.id.nav_expenses) {

        } else if (id == R.id.nav_expensebycategory) {

        }*/else if (id == R.id.nav_logout) {
            callLogout();

        }
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).addToBackStack("goBack").commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void callLogout(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setMessage("Do you want to logout?")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
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
}
