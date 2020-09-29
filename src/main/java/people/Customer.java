package people;

import interfaces.IBuy;
import vehicles.Vehicle;

import java.util.ArrayList;

public class Customer extends Person implements IBuy {
    private double money;
    private String dreams;
    private ArrayList<Vehicle> ownedVehicles;

    public Customer(String name, double money, String dreams) {
        super(name);
        this.money = money;
        this.dreams = dreams;
        this.ownedVehicles = new ArrayList<Vehicle>();
    }

    public double getMoney() {
        return money;
    }

    public String getDreams() {
        return dreams;
    }

    public ArrayList<Vehicle> getOwnedVehicles() {
        return ownedVehicles;
    }

    public boolean canAfford(Vehicle vehicle) {
        return money > vehicle.getPrice();
    }

    public void buyVehicle(Vehicle vehicle) {
        if (canAfford(vehicle)) {
            setMoney(getMoney() - vehicle.getPrice());
            ownedVehicles.add(vehicle);
        }
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
