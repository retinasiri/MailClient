package com.jeefer.mailclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

public class SendMailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        final String senderEmail = intent.getStringExtra(LoginActivity.EXTRA_EMAIL);
        final String senderPassword = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get the input fields
                EditText recepientEditText = (EditText) findViewById(R.id.recepientInput);
                EditText subjectEditText = (EditText) findViewById(R.id.subjectInput);
                EditText messageEditText = (EditText) findViewById(R.id.messageInput);

                //Transform input to string
                String recepient = recepientEditText.getText().toString();
                String subject = subjectEditText.getText().toString();
                String message = messageEditText.getText().toString();

                //Send Mail

                SendMail mail = new SendMail(senderEmail, senderPassword, recepient, subject, message);

                Toast.makeText(SendMailActivity.this, "Preparing mail message", Toast.LENGTH_SHORT).show();

                try {
                    mail.createEmailMessage();

                } catch (MessagingException | UnsupportedEncodingException e){
                    e.printStackTrace();
                }

                Toast.makeText(SendMailActivity.this, "Sending email", Toast.LENGTH_SHORT).show();
                try {
                    mail.sendMessage();
                } catch (MessagingException e){
                    e.printStackTrace();
                }

                Toast.makeText(SendMailActivity.this, "Email Sent", Toast.LENGTH_SHORT).show();

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
