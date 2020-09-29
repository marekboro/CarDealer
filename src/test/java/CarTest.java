import components.Battery;
import components.Engine;
import components.SteeringWheel;
import org.junit.Before;
import org.junit.Test;
import vehicles.Car;
import vehicles.ElectricCar;
import vehicles.HybridCar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarTest {

    Battery battery;
    SteeringWheel steeringWheel2;
    SteeringWheel steeringWheel;
    Car car;
    ElectricCar carE;
    HybridCar carH;

    @Before
    public void before() {
        battery = new Battery(500.0);
        steeringWheel = new SteeringWheel("metalic");
        steeringWheel2 = new SteeringWheel("leather");
        car = new Car(10000.0, "blue", "Carrera", "Porche", battery, steeringWheel, 20);
        carE = new ElectricCar(10000.0, "Silver", "Diablo", "Lamborgini", steeringWheel2, 50);
        carH = new HybridCar(10000.0, "black", "cl100", "Lexus", steeringWheel2, 30);

    }

    @Test
    public void hasPriceThatWillAdjustWithCondition() {
        assertEquals(2000.0, car.getPrice(), 0.01);
        assertEquals(5000.0, carE.getPrice(), 0.01);
        assertEquals(3000.0, carH.getPrice(), 0.01);
        carH.repairDamage(30);
        assertEquals(6000.0, carH.getPrice(), 0.01);
        carH.takeDamage(20);
        assertEquals(4000.0, carH.getPrice(), 0.01);


    }

    @Test
    public void hasColour() {
        assertEquals("blue", car.getColour());
    }

    @Test
    public void hasModel() {
        assertEquals("Carrera", car.getModel());
    }

    @Test
    public void hasBrand() {
        assertEquals("Porche", car.getBrand());
    }

    @Test
    public void hasEngine() {
        assertEquals("petrol", car.getEngine().getType());
        assertEquals("electric", carE.getEngine().getType());
        assertEquals("hybrid", carH.getEngine().getType());


    }

    @Test
    public void hasBattery() {
        assertEquals(battery, car.getBattery());
        assertEquals(500.0, car.getBattery().getCapacity(), 0.01);
    }

    @Test
    public void hasSteeringWheel() {
        assertEquals("metalic", car.getSteeringWheel().getType());
        assertEquals(steeringWheel, car.getSteeringWheel());
        assertEquals("leather", carE.getSteeringWheel().getType());
        assertEquals("leather", carH.getSteeringWheel().getType());

    }

    @Test
    public void hasCondition() {
        assertEquals(20, car.getCondition());
    }

    @Test
    public void electricCarHasLargerBatteryThanHybridOrPetrol() {
        assertTrue(carE.getBattery().getCapacity() > car.getBattery().getCapacity());
        assertTrue(carE.getBattery().getCapacity() > carH.getBattery().getCapacity());
        assertTrue(carH.getBattery().getCapacity() > car.getBattery().getCapacity());
    }



}
