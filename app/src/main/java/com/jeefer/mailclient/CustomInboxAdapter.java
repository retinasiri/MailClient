package com.jeefer.mailclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by jeefer on 3/1/16.
 */
public class CustomInboxAdapter extends ArrayAdapter<String> {

    public CustomInboxAdapter(Context context, String[] foods) {
        super(context, R.layout.custom_inbox_row, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //inflate just mean prepare or get ready for rendering
        LayoutInflater inboxInfalter = LayoutInflater.from(getContext());
        View customInboxView = inboxInfalter.inflate(R.layout.custom_inbox_row, parent, false);

        String singleFoodItem = getItem(position);
        TextView senderListViewText = (TextView)customInboxView.findViewById(R.id.senderListViewText);
        TextView subjectListViewText = (TextView)customInboxView.findViewById(R.id.subjectListViewText);

        senderListViewText.setText(singleFoodItem);
        subjectListViewText.setText(singleFoodItem);

        return customInboxView;
    }


}
