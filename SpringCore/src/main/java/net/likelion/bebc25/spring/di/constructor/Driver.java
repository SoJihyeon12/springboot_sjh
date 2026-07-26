package net.likelion.bebc25.spring.di.constructor;

public class Driver {
    private final Car car;

    // DI
    Driver(Car car){
        System.out.println("called Constructor Injection");
        this.car = car;
    }

    public void driveCar() {
        car.startEngine();
        car.drive();
        car.stopEngine();
    }
}
