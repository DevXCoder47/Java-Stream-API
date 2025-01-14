package com.nikijv.streamapi.model;

public class Product {

    public String name;
    public String category;

    public Product(String name, String category) {

        this.name = name;
        this.category = category;

    }

    @Override
    public String toString() {

        return "Product: [name = " + name + ", category = " + category + "]\n";

    }
}
