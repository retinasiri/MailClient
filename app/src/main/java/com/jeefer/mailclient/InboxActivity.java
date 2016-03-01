package com.jeefer.mailclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class InboxActivity extends AppCompatActivity {
    public final static String EXTRA_EMAIL = "com.mycompany.myfirstapp.EMAIL";
    public final static String EXTRA_PASSWORD = "com.mycompany.myfirstapp.PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //To start the SendMailActivity

        //get the Extra from the login activity (email, password)
        Intent intent = getIntent();
        String email = intent.getStringExtra(LoginActivity.EXTRA_EMAIL);
        String password = intent.getStringExtra(LoginActivity.EXTRA_PASSWORD);

        //intent to sendMailActivity
        final Intent intentToSendMail = new Intent(this, SendMailActivity.class);
        intentToSendMail.putExtra(EXTRA_EMAIL, email);
        intentToSendMail.putExtra(EXTRA_PASSWORD, password);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //go to sendMailActivity
                startActivity(intentToSendMail);

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        String[] foods = {"Bacon", "Ham", "Tuna", "Candy", "Potato", "Ham", "Tuna", "Candy", "Potato", "Ham", "Tuna", "Candy", "Potato", "Ham", "Tuna", "Candy", "Potato"};

        ListAdapter inboxAdapter = new CustomInboxAdapter(this, foods);

        //Set up the listView
        ListView inboxListView = (ListView)findViewById(R.id.inboxListView);
        inboxListView.setAdapter(inboxAdapter);

        inboxListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                }
        );

    }

}
