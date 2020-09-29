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

    public double getOriginalPrice(){
        return this.price;
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


    public boolean canRepair(int percentage){
        return this.condition+percentage <=100;
    }

    public boolean canTakeDamage(int damage){
        return this.condition > damage && condition>0;
    }

    public void takeDamage(int percentage){
        if(canTakeDamage(percentage)){
            setCondition(getCondition()-percentage);
        }

    }
    public void repairDamage(int percentage) {
        if (canRepair(percentage)){
            setCondition(getCondition()+percentage);
        }
    }
}
