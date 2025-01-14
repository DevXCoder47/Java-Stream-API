package com.nikijv.streamapi.model;

public class Device {

    public String name;
    public int productionYear;
    public double price;
    public String colour;
    public String type;

    public Device(String name, int productionYear, double price, String colour, String type) {

        this.name = name;
        this.productionYear = productionYear;
        this.price = price;
        this.colour = colour;
        this.type = type;

    }

    @Override
    public String toString() {

        return "Device: [name = " + name + ", productionYear = " + productionYear + ", price = " + price + ", colour = " + colour + ", type = " + type + "]\n";

    }
}
