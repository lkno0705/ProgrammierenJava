package de.dhbwka.java.exercise.control;

import java.text.DecimalFormat;

public class TemperatureTable {
    public static void main(String[] args){
        DecimalFormat format = new DecimalFormat("#00.00");
        System.out.println("Fahrenheit | Celsius \n" +
                            "----------+-----------");
        for (int f=0; f<=300; f+=20){
            double c = (5.0/9.0)*(f-32);
            System.out.println(f + "         |         " + format.format(c));
        }
    }
}
