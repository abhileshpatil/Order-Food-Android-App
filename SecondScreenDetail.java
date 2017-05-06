package com.cs442.apatil25.orderfoodapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondScreenDetail extends Fragment
{
    private HandlingItems item;
    String s1;
    int price1=0;
    double total=0;
    double abc=0.0;
    String quantity="";


    Button addbutton;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        item = (HandlingItems) getArguments().getSerializable("item");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.detail,container, false);

        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);

        TextView tvBody = (TextView) view.findViewById(R.id.tvBody);

        TextView price= (TextView) view.findViewById(R.id.price);

        final EditText editText=(EditText) view.findViewById(R.id.edittext) ;

        addbutton=(Button) view.findViewById(R.id.back);

        tvTitle.setText(item.getTitle());
        tvBody.setText(item.getBody());

        s1=item.getPrice();
        abc=Double.parseDouble(s1);
        price.setText("Cost: $"+abc);

        quantity = item.getTitle()+ " ";

        addbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                String quantity1=editText.getText().toString(); // retriving the quantity
                double quant=Double.parseDouble(quantity1);
                quantity += quant + "\n";
                total=abc*quant;
                HandlingItems.setTotal(total);
                HandlingItems.setQuantity(quantity);
                Intent ii =new Intent(getActivity(),MainActivity.class);
                ii.putExtra("Qamount", total);
                startActivity(ii);

            }
        });

        return view;
    }

    public static SecondScreenDetail newInstance(HandlingItems item)
    {
        SecondScreenDetail fragmentDemo = new SecondScreenDetail();
        Bundle args = new Bundle();
        args.putSerializable("item", item);
        fragmentDemo.setArguments(args);
        return fragmentDemo;
    }
}
