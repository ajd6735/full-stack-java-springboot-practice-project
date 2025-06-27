package com.quickcart.ecomerce.model;

public class User {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    private double price;

}
