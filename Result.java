package com.cs442.apatil25.orderfoodapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;


public class Result extends Activity
{
    String fq="";
    double fp=0;
    String fp1="";
     SharedPreferences pre;
     SharedPreferences.Editor edit;
     DateFormat d=new DateFormat();
     Date date=new Date();
    String abc;

    String resultdate="";

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finaldisplay);
        TextView textView = (TextView) findViewById(R.id.output);
        textView.setText(HandlingItems.getQuantity()+"\n Total cost of your order: "+HandlingItems.getTotal());

        fq=HandlingItems.getQuantity();
        fp=HandlingItems.getTotal();
         fp1=Double.toString(fp);

        Button button1= (Button) findViewById(R.id.pay);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                resultdate=d.format("dd/MM/yy hh:mm:ss",date).toString();

                pre=getSharedPreferences("previousrecord",0);
                edit=pre.edit();

                edit.putString("Quant",fq);
                edit.putString("cost",fp1);
                String res = pre.getString("Hist",null)+"\n"+resultdate+" "+fq+" "+fp1 ;
                edit.putString("Hist",pre.getString("Hist",null)+"\n"+resultdate+" "+fq+" "+fp1);
                Toast.makeText(getApplicationContext(),res,Toast.LENGTH_LONG);
                edit.commit();

                abc=pre.getString("Quant",null);

                Intent i3=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i3);
                HandlingItems.setnull();

            }
        });
    }
}
