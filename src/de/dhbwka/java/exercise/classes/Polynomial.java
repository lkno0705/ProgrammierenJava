package de.dhbwka.java.exercise.classes;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Polynomial {

    double a, b, c;

    Polynomial(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    Polynomial(double a, double b){
        this.a = a;
        this.b = b;
        this.c = 0;
    }

    Polynomial(double a){
        this.a = a;
        this.b = 0;
        this.c = 0;
    }

    @Override
    public String toString() {
        return "Polynomial{" +
                + a + "x^2 + " + b + "x + " + c +
                '}';
    }

    public double f(double x){
        return a*Math.pow(x,2)+b*x+c;
    }

    public Polynomial mult(double x){
        return new Polynomial((a*x), (b*x), (c*x));
    }

    public Polynomial sub(Polynomial poly){
        return new Polynomial(a-poly.a, b-poly.b, c-poly.c);
    }

    public Polynomial add(Polynomial poly){
        return new Polynomial(a+poly.a, b+poly.b, c+poly.c);
    }

    public double[] nst(){
        double p;
        double q;
        double[] r = new double[2];
        if (a != 0){
            p = b/a;
            q = c/a;
            r[0] = -(p/2)+Math.sqrt(Math.pow(-p/2,2)-q);
            r[1] = -(p/2)-Math.sqrt(Math.pow(-p/2,2)-q);
            return r;
        }
        else{
            r[0] = -(b/2)+Math.sqrt(Math.pow(-b/2,2)-c);
            r[1] = -(b/2)-Math.sqrt(Math.pow(-b/2,2)-c);
            return r;
        }
    }

    public static void main(String[] args) {
        Polynomial a = new Polynomial(2.0,0, 0);
        System.out.println(a.toString());
        Polynomial b = new Polynomial(0, -4, 1);
        System.out.println(b.toString());
        Polynomial c = a.add(b);
        System.out.println(c.toString());
        c = c.mult(2.0);
        System.out.println(c.toString());
        System.out.println(Arrays.toString(c.nst()));
    }

}
