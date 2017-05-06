package com.cs442.apatil25.orderfoodapp;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class FirstFragment extends Fragment
{
    private ArrayAdapter<HandlingItems> adapterItems;
    private ListView dis;
    TextView t;
    double sum=0;
    boolean flag=false;
    Button button;
    Button button1;
    private OnItemSelectedListener listener;

    public interface OnItemSelectedListener
    {
        public void onItemSelected(HandlingItems i);
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof OnItemSelectedListener)
        {
            listener = (OnItemSelectedListener) activity;
        } else
        {
            throw new ClassCastException(activity.toString()
                    + " must implement ItemsListFragment.OnItemSelectedListener");
        }
    }
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Create arraylist from item fixtures
        ArrayList<HandlingItems> items = HandlingItems.getItems();
        adapterItems = new ArrayAdapter<HandlingItems>(getActivity(),
                android.R.layout.simple_list_item_activated_1, items);
        if(flag) {
            String a = getActivity().getIntent().getExtras().getString("Qamount");
            sum = Double.parseDouble(a);
            t.setText(sum + "");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate view
        final View view = inflater.inflate(R.layout.firstfragment, container, false);

        t = (TextView) view.findViewById(R.id.look);
        sum = HandlingItems.getTotal();
        String q = HandlingItems.getQuantity();
        t.setText(q+"\nYour Current Bill Amount "+sum+"");

        // Bind adapter to ListView
        dis = (ListView) view.findViewById(R.id.dis);
        dis.setAdapter(adapterItems);
        dis.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View item, int position,long rowId)
            {
                HandlingItems i = adapterItems.getItem(position);
                listener.onItemSelected(i);
                flag=true;
            }
        });

        button=(Button) view.findViewById(R.id.cart);


        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(getActivity(),Result.class);
                startActivity(i);

            }
        });

        button1=(Button) view.findViewById(R.id.record); // history button
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               Intent i2=new Intent(getActivity(),previousrecords.class);
                startActivity(i2);

            }
        });


        return view;
    }




    public void setActivateOnItemClick(boolean activateOnItemClick) {

        dis.setChoiceMode(
                activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
                        : ListView.CHOICE_MODE_NONE);
    }
}
