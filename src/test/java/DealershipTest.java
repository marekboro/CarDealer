import components.Battery;
import components.SteeringWheel;
import org.junit.Before;
import org.junit.Test;
import people.Customer;
import vehicles.Car;
import vehicles.ElectricCar;
import vehicles.HybridCar;

import static org.junit.Assert.assertEquals;

public class DealershipTest {

    Battery battery;
    SteeringWheel steeringWheel2;
    SteeringWheel steeringWheel;
    Car car;
    ElectricCar carE;
    HybridCar carH;
    Dealership dealership;
    Customer customer;

    @Before
    public void before(){
        customer = new Customer("Jack",4000.0,"To have any car");
        dealership = new Dealership("CheapCars", 17000.0);
        battery = new Battery(500.0);
        steeringWheel = new SteeringWheel("metalic");
        steeringWheel2 = new SteeringWheel("leather");
        car = new Car(10000.0, "blue", "Carrera", "Porche", battery, steeringWheel, 20);
        carE = new ElectricCar(10000.0, "Silver", "Diablo", "Lamborgini", steeringWheel2, 50);
        carH = new HybridCar(10000.0, "black", "cl100", "Lexus", steeringWheel2, 30);
        dealership.buyVehicle(car);
        dealership.buyVehicle(carE);
//        dealership.buyVehicle(carH);
//
    }

    @Test
    public void canBuyCar(){
        assertEquals(2,dealership.getVehicles().size());
        assertEquals(10000.0,dealership.getTill(),0.01);
        dealership.buyVehicle(carH);
        assertEquals(3,dealership.getVehicles().size());
        assertEquals(7000.0,dealership.getTill(),0.01);
    }

    @Test
    public void canSellCarProvidedCustomerCanAffordIt(){
        dealership.sellCar(carE,customer);
        assertEquals(2,dealership.getVehicles().size());
        dealership.sellCar(car,customer);
        assertEquals(1,dealership.getVehicles().size());
        assertEquals(12000.0,dealership.getTill(),0.01);
        assertEquals(1,customer.getOwnedVehicles().size());
    }

    @Test
    public void canRepairIfCanAffordIt(){
        dealership.buyVehicle(carH);
        assertEquals(7000.0,dealership.getTill(),0.01);
        dealership.repairVehicle(carE);
        assertEquals(2000.0,dealership.getTill(),0.01);
        dealership.repairVehicle(carH);
        assertEquals(2000.0,dealership.getTill(),0.01);

    }

}
