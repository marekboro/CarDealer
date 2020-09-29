package vehicles;


import components.Battery;
import components.Engine;
import components.SteeringWheel;

public class HybridCar extends Vehicle{

    private Engine engine;
    private Battery battery;
    private SteeringWheel steeringWheel;

    public HybridCar(double price, String colour, String model, String brand, SteeringWheel steeringWheel, int condition) {
        super(price, colour, model, brand, condition);
        this.engine = new Engine("hybrid");
        this.battery = new Battery(2500.0);
        this.steeringWheel = steeringWheel;
    }

    public Engine getEngine() {
        return engine;
    }

    public Battery getBattery() {
        return battery;
    }

    public SteeringWheel getSteeringWheel() {
        return steeringWheel;
    }
}
