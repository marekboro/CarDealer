package vehicles;

import components.Battery;
import components.Engine;
import components.SteeringWheel;

public class Car extends Vehicle{

    private Engine engine;
    private Battery battery;
    private SteeringWheel steeringWheel;

    public Car(double price, String colour, String model, String brand, Battery battery, SteeringWheel steeringWheel, int condition) {
        super(price, colour, model, brand, condition);
        this.engine = new Engine("petrol");
        this.battery = battery;
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
