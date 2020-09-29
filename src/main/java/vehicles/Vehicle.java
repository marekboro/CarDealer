package vehicles;

import components.Engine;

public abstract class Vehicle {

    private double price;
    private String colour;
    private String model;
    private String brand;
    private int condition;

    public Vehicle(double price, String colour, String model, String brand, int condition) {
        this.price = price;
        this.colour = colour;
        this.model = model;
        this.brand = brand;
        this.condition = condition;
    }

    public double getPrice() {
        double newPrice=this.price*(condition/100.0);
        return newPrice;

    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }
}
