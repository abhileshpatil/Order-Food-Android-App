package com.cs442.apatil25.orderfoodapp;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;


public class previousrecords extends Activity
{

SharedPreferences preferences;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.previousrecord);
        TextView textView=(TextView) findViewById(R.id.previousrecord);

        SharedPreferences preferences =getSharedPreferences("previousrecord",0);
        SharedPreferences.Editor editor=preferences.edit();
        String result=preferences.getString("Hist",null);
        result = result.substring(3);
        textView.setText(" " + result);


    }
}
