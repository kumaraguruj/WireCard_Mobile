package com.attra.wirecard.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.attra.wirecard.R;

public class LoginActivity extends AppCompatActivity {

    private Button mLogin;
    private EditText mEmail, mPasword;
    String PREFS_NAME = "Pref Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogin = (Button) findViewById(R.id.btnLogin);
        mEmail = (EditText) findViewById(R.id.input_emailAdd);
        mPasword = (EditText) findViewById(R.id.input_password);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailId = mEmail.getText().toString();
                String password = mPasword.getText().toString();

                if (emailId.equals("") || password.equals("")){
                    if (emailId.equals("")) {
                        mEmail.setError("Enter your username");
                        mEmail.requestFocus();
                    } else if (password.equals("")) {
                        mPasword.setError("Enter your password");
                        mPasword.requestFocus();
                    }
                } else if (!(emailId.equals(""))){
                    SharedPreferences pref = getApplicationContext().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username", emailId);
                    editor.commit();
                    if (emailId.equals("Bob")){
                        Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(i);
                    } else if (emailId.equals("Alice")){
                        Intent i = new Intent(getApplicationContext(), HomeActivityAlice.class);
                        startActivity(i);
                    } else {
                        mEmail.setError("Please enter valid email-Id(Bob/Alice)");
                        mEmail.requestFocus();
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
