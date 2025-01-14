package com.nikijv.streamapi.model;

public class Projector {

    public String name;
    public int productionYear;
    public double price;
    public String manufacturer;

    public Projector(String name, int productionYear, double price, String manufacturer) {

        this.name = name;
        this.productionYear = productionYear;
        this.price = price;
        this.manufacturer = manufacturer;

    }

    @Override
    public String toString() {

        return "Projector: [name = " + name + ", production year = " + productionYear + ", price = " + price + ", manufacturer = " + manufacturer + "]\n";

    }
}
