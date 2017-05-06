package com.cs442.apatil25.orderfoodapp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

public class MenuDetail extends FragmentActivity {
    SecondScreenDetail fragmentItemDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HandlingItems item = (HandlingItems) getIntent().getSerializableExtra("item");
        if (savedInstanceState == null)
        {
            fragmentItemDetail = SecondScreenDetail.newInstance(item);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentItemDetail);
            ft.commit();
        }
    }


}