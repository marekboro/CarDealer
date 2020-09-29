import interfaces.IBuy;
import people.Customer;
import people.Dealer;
import vehicles.Vehicle;

import java.util.ArrayList;

public class Dealership implements IBuy {
    private String name;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Dealer> staff;
    private double till;


    public Dealership(String name, double till) {
        this.name = name;
        this.vehicles = new ArrayList<Vehicle>();
        this.staff = new ArrayList<Dealer>();
        this.till = till;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public ArrayList<Dealer> getStaff() {
        return staff;
    }

    public void setTill(double till) {
        this.till = till;
    }

    public double getTill() {
        return till;
    }

    public void sellCar(Vehicle vehicle, Customer customer){
        if(customer.canAfford(vehicle)){
            customer.buyVehicle(vehicle);
            setTill(getTill()+vehicle.getPrice());
            this.vehicles.remove(vehicle);
        }

    }

    public boolean canAfford(Vehicle vehicle) {
        return till > vehicle.getPrice();
    }
    public void buyVehicle(Vehicle vehicle) {
        if (canAfford(vehicle)) {
            setTill(getTill() - vehicle.getPrice());
            vehicles.add(vehicle);
        }
    }

    public void repairVehicle(Vehicle vehicle){
        int damageToRepair = 100 - vehicle.getCondition();
        double repairPrice = (vehicle.getOriginalPrice()*(damageToRepair))/100;
        if (getTill()>=repairPrice){
            vehicle.repairDamage(damageToRepair);
            double newTill = getTill() - repairPrice;
            setTill(newTill);
        }

    }
    public void repairVehicleByPercent(Vehicle vehicle, int percent){
        double repairPrice = (vehicle.getOriginalPrice()*percent)/100;
        if (getTill()>=repairPrice){
            vehicle.repairDamage(percent);
            double newTill = getTill() - repairPrice;
            setTill(newTill);
        }

    }

}
