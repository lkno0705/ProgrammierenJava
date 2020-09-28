package de.dhbwka.java.exercise.vehicles;

public class Race {
}

class Vehicle{
    private int tires;
    private int vmax;
    private int acc;
    private double position;
    private double currSpeed;

    Vehicle(){
        this.tires = 0;
        this.currSpeed = 0;
        this.position = 0;
        this.currSpeed = 0;
    }
    Vehicle(int tires, int vmax, int acc){
        this.tires = tires;
        this.vmax = vmax;
        this.acc = acc;
        this.position = 0;
        this.currSpeed = 0;
    }

    public void setSpeed(double currSpeed) {
        double v0 = this.currSpeed;
        this.currSpeed = currSpeed;
        double t = ((currSpeed - v0)/60.0*60.0) / ((vmax / 60.0*60.0) /acc);
        this.position = 0.5 * ((vmax/60.0*60.0) / acc) * Math.pow(t, 2) + v0 * t + this.position;
    }

    public void drive(double minutes){
        if (currSpeed > 0){
            position += (currSpeed / 60 ) * minutes;
        }
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "tires=" + tires +
                ", vmax=" + vmax +
                ", position=" + position +
                ", currSpeed=" + currSpeed +
                '}';
    }
}

class Bicycle extends Vehicle{
    Bicycle(){
        super(2, 30, 40);
    }
}

class Car extends Vehicle{
    Car(){
        super(4, 140, 15);
    }
}

class RacingCar extends Vehicle{
    RacingCar(){
        super(4, 220, 15);
    }
}

class Ambulance extends Vehicle{
    boolean blueLight;
    Ambulance(){
        super(4, 140, 20);
        this.blueLight = false;
    }

    public void setBlueLight(boolean blueLight) {
        this.blueLight = blueLight;
    }
}