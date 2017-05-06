package com.cs442.apatil25.orderfoodapp;

import java.io.Serializable;
import java.util.ArrayList;

public class HandlingItems implements Serializable {
   // private static final long serialVersionUID = -6099312954099962806L;
    static String q1="";
    private String title;
    static double t1=0;
    private String body;
    private String price;


    public HandlingItems(String title, String body, String price)
    {
        this.title = title;
        this.body = body;
        this.price=price;
    }

    public String getTitle() { return title; }
    public String getBody() {
        return body;
    }

    public String getPrice(){return price;}

    public static ArrayList<HandlingItems> getItems()
    {
        ArrayList<HandlingItems> items = new ArrayList<HandlingItems>();
        String Desc1="This is delicious subway restaurant menu item. Ingredients:- Bread, different types of vegitable and sauces of our choice";
        String price1="4.75";
        items.add(new HandlingItems("Veggi Delight",Desc1,price1));

        String Desc2="This is chinese food cooked. Ingredients:- Steam Rice, Vegitable, soya and schzewan sauce";
        String price2="8.50";
        items.add(new HandlingItems("Fried Rice",Desc2,price2));

        String Desc3="This is Indian Food item made with different types of herbs and spices. Ingredients:- Chicken, Vegitables and Indian spices";
        String price3="12.00";
        items.add(new HandlingItems("Butter Chicken",Desc3,price3));

        String Desc4="This is Indian chaat food which contains flavoured water. Ingredients:- Puri, flavoured water made by indian spices. ";
        String price4="2.50";
        items.add(new HandlingItems("Pani Puri",Desc4,price4));

        String Desc5="This is an American pizza. Ingredients:- Pizza bread, Chicken, Vegitables and different types of sauces";
        String price5="12.00";
        items.add(new HandlingItems("Deep Dish Pizza",Desc5,price5));

        return items;
    }

    @Override
    public String toString() {
        return getTitle();
    }

    public static double getTotal()
    {
        return t1;
    }

    public static void setTotal(double i)
    {
        t1 += i;
    }

    public static String getQuantity()
    {
        return q1;
    }

    public static void setQuantity(String i)
    {
        q1 += i;
    }

    public static void setnull()
    {
        t1=0;
        q1="";
    }

}

