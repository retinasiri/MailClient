package com.jeefer.mailclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    public final static String EXTRA_EMAIL = "com.mycompany.myfirstapp.EMAIL";
    public final static String EXTRA_PASSWORD = "com.mycompany.myfirstapp.PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Envoyer un mail automatiquement

        Mail m = new Mail("retinasri@gmail.com", "79977001genuis");

        String[] toArr = {"olongojefferson@gmail.com", "olonogojefferson@yahoo.fr"};
        m.setTo(toArr);
        m.setFrom("retinasiri@gmail.com");
        m.setSubject("This is an email sent using my Mail JavaMail wrapper from an Android device.");
        m.setBody("Email body.");

        try {
            //m.addAttachment("/sdcard/filelocation");

            if(m.send()) {
                Toast.makeText(LoginActivity.this, "Email was sent successfully.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(LoginActivity.this, "Email was not sent.", Toast.LENGTH_LONG).show();
            }
        } catch(Exception e) {
            //Toast.makeText(MailApp.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show();
            Log.e("MailApp", "Could not send email", e);
        }


    }

    public void login(View view) {
        Intent intent = new Intent(this, InboxActivity.class);
        EditText emailEditText = (EditText) findViewById(R.id.emailInput);
        EditText passwordEditText = (EditText) findViewById(R.id.passwordInput);

        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        intent.putExtra(EXTRA_EMAIL, email);
        intent.putExtra(EXTRA_PASSWORD, password);

        //vérifier l'email et le mot de passe
        startActivity(intent);


    }
}
