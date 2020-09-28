package de.dhbwka.java.exercise.classes;

public class Radio {
    // initializing global Variables
    boolean on;
    int volume;
    double frequency;

    //standard constructor
    Radio(){
        this.on = false;
        this.volume = 5;
        this.frequency = 85.0;
    }

    // constructor with manual settings
    Radio(boolean on, int volume, double frequency){
        this.on = on;
        if (volume >= 0 && volume <= 10)  this.volume = volume; //checking for correct volume levels before setting the var
        else{
            this.volume = 5;
            System.out.println("Volume " + volume + "too high or to low! The volume has been set to 5");
        }
        if(frequency>= 85.0 && frequency<=110.0) this.frequency = frequency; // checking for correct frequency range levels before setting the var
        else{
            this.frequency = 85.0;
            System.out.println("Frequency " + frequency + "too high or to low! The volume has been set to 85.0");
        }
    }

    // Function to increase the volume
    void incVolume(){
        if (this.volume < 10)  this.volume += 1; // setting volume upperbound to 10
        else System.out.println("Radio volume is maxed out!");
    }

    // Function to decrease the volume
    void decVolume(){
        if (this.volume > 0)  this.volume -= 1; // setting volume lowebound to 0
        else System.out.println("Radio volume is turned all the way down!");
    }

    // Function to turn on radio
    void turnOn(){
        this.on = true;
        System.out.println("Radio is now turned on");
    }

    // Function to turn off radio
    void turnOff(){
        this.on = false;
        System.out.println("Radio is now turned off");
    }

    // Function to set the current frequency
    void setFrequency(double frequency){
        if (frequency <= 110.0 && frequency >= 85.0){ // checking for correct frequency range levels before setting the var
            this.frequency = frequency;
            System.out.println("frequency has been set to " + frequency);
        }
        else System.out.println("frequency out of range!");
    }

    // To string method for printing out current settings
    public String toString(){
        String status;
        if (this.on) status = "an";
        else status = "aus";
        return  "Radio " + status + ": Freq=" + frequency + " Laut=" + volume;
    }

    // main function which is executed by running the programm, in this case it just tests the implementation
    public static void main(String[] args) {
        // initializing radio class
        Radio radio = new Radio(false, 7, 93.5);
        System.out.println(radio);
        //turning on radio
        radio.turnOn();
        System.out.println(radio);
        // increasing the volume twice
        radio.incVolume(); radio.incVolume();
        System.out.println(radio);
        // increasing volume
        radio.incVolume();
        // increasing volume to 11 -> should throw a frequency out of range
        radio.incVolume();
        System.out.println(radio);
        // decreasing volume
        radio.decVolume();
        System.out.println(radio);
        // setting valid frequency
        radio.setFrequency(97.8);
        System.out.println(radio);
        // setting invalid frequency
        radio.setFrequency(112.7);
        System.out.println(radio);
        // turning off radio
        radio.turnOff();
        System.out.println(radio);
    }
}
