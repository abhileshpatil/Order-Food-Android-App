package com.cs442.apatil25.orderfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.widget.FrameLayout;

import com.cs442.apatil25.orderfoodapp.FirstFragment.OnItemSelectedListener;

public class MainActivity extends FragmentActivity implements OnItemSelectedListener {
    private boolean isTwoPane = false;
    boolean flag=false;
    double total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.itemfragment);
        determinePaneLayout();
        if(flag) {
            String a = getIntent().getExtras().getString("Qamount");
            total = Double.parseDouble(a);

        }
    }

    private void determinePaneLayout()
    {
        FrameLayout fragmentItemDetail = (FrameLayout) findViewById(R.id.flDetailContainer);
        if (fragmentItemDetail != null)
        {
            isTwoPane = true;
            FirstFragment fragmentItemsList =
                    (FirstFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentItemsList);
            fragmentItemsList.setActivateOnItemClick(true);
        }
    }



    @Override
    public void onItemSelected(HandlingItems item)
    {
        if (isTwoPane)
        {
            // single activity with list and detail
            // Replace frame layout with correct detail fragment
            SecondScreenDetail fragmentItem = SecondScreenDetail.newInstance(item);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flDetailContainer, fragmentItem);
            ft.commit();
            flag=true;
        } else {
            // separate activities
            // launch detail activity using intent
            Intent i = new Intent(this, MenuDetail.class);
            i.putExtra("item", item);
            startActivity(i);
            flag=true;
        }
    }

}

