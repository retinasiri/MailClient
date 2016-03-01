package com.jeefer.mailclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class InboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //To start the SendMailActivity
        final Intent intent = new Intent(this, SendMailActivity.class);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
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
