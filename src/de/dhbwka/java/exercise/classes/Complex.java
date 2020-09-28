package de.dhbwka.java.exercise.classes;

import java.util.Random;

public class Complex {

    private double real, imag;

    Complex(double real, double imag) {
        this.imag = imag;
        this.real = real;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "real=" + real +
                ", imag=" + imag +
                '}';
    }

    // Math implementations
    public Complex add(Complex compObj) {
        return new Complex(this.real + compObj.getReal(), this.imag + compObj.getImag());
    }

    public Complex sub(Complex compObj) {
        return new Complex(this.real - compObj.getReal(), this.imag - compObj.getImag());
    }

    public Complex mult(Complex compObj) {
        double newReal = this.real * compObj.getReal() - this.imag * compObj.getImag();
        double newImag = this.real * compObj.getImag() - this.imag * compObj.getReal();
        return new Complex(newReal, newImag);
    }

    public Complex div(Complex compObj) {
        double newReal = (this.real * compObj.getReal() + this.imag * compObj.getImag()) / (Math.pow(compObj.getReal(), 2) + Math.pow(compObj.getImag(), 2));
        double newImag = (this.imag * compObj.getReal() - this.real * compObj.getImag()) / (Math.pow(compObj.getReal(), 2) + Math.pow(compObj.getImag(), 2));
        return new Complex(newReal, newImag);
    }

    public double getMagnitude() {
        return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
    }

    public boolean isLess(Complex compObj) {
        return this.getMagnitude() < compObj.getMagnitude();
    }

    
    public static Complex[] sort(Complex[] compArr){
        for (int k = 1; k < compArr.length; k++) {
            for (int i = 0; i < compArr.length - k; i++) {
                if (compArr[i + 1].isLess(compArr[i])) {
                    Complex temp = compArr[i];
                    compArr[i] = compArr[i + 1];
                    compArr[i + 1] = temp;
                }
            }
        }
        return compArr;
    }

    public static void main(String[] args) {
        // create Object Array with pointers / references to store complex numbers
        Complex[] compArr = new Complex[10];

        // generate random parameters and create new complex number in objArr
        Random rng = new Random();
        for (int i = 0; i < compArr.length; i++) {
            //generating params
            int real = rng.nextInt(10);
            int imag = rng.nextInt(10);

            //create new object with params
            compArr[i] = new Complex(real, imag);
            System.out.println("New Object created: " + compArr[i]);
        }

        // testing method implementations
        Complex c1 = compArr[0];
        Complex c2 = compArr[1];
        System.out.println("\nC1: " + c1 + "\nC2: " + c2);
        System.out.println("C1 + C2: " + c1.add(c2));
        System.out.println("C1 - C2: " + c1.sub(c2));
        System.out.println("C1 * C2: " + c1.mult(c2));
        System.out.println("C1 / C2: " + c1.div(c2));
        System.out.println("C1 < C2?: " + c1.isLess(c2));

        //sort
        Complex[] sorted = sort(compArr);
        System.out.println("\nsorted: ");
        for (Complex obj:sorted) System.out.println(obj.toString() + " Magnitude: " + obj.getMagnitude());
    }

}
