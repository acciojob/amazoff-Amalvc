package com.driver;

public class Order {

    private String id;
    private int deliveryTime;

    public Order(String id, String deliveryTime) {

        // The deliveryTime has to converted from string to int and then stored in the attribute
        //deliveryTime  = HH*60 + MM
        this.id=id;
        String hh=deliveryTime.substring(0,2);
        String mm=deliveryTime.substring(3,5);
        int t=(Integer.valueOf(hh)*60)+Integer.valueOf(mm);
        this.deliveryTime=t;


    }

    public String getId() {
        return id;
    }

    public int getDeliveryTime() {return deliveryTime;}
}
