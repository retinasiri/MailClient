package com.jeefer.mailclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    public final static String EXTRA_EMAIL = "com.mycompany.myfirstapp.EMAIL";
    public final static String EXTRA_PASSWORD = "com.mycompany.myfirstapp.PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login() {
        Intent intent = new Intent(this, Inbox.class);
        EditText emailEditText = (EditText) findViewById(R.id.emailInput);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordInput);

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        intent.putExtra(EXTRA_EMAIL, email);
        intent.putExtra(EXTRA_PASSWORD, password);

        startActivity(intent);


    }
}
