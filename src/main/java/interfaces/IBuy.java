package interfaces;

import vehicles.Vehicle;

public interface IBuy {
    boolean canAfford(Vehicle vehicle);
    void buyVehicle(Vehicle vehicle);

}
