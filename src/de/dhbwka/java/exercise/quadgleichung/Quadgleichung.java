package de.dhbwka.java.exercise.quadgleichung;
import java.util.Scanner;

public class Quadgleichung {
    public static void main(String[] args){
        //ax^2+bx+c=0
        Scanner scan = new Scanner(System.in);
        double a = scan.nextDouble();
        double b = scan.nextDouble();
        double c  = scan.nextDouble();
        double[] x = quadratics(a,b,c);
        for(int i=0; i<=x.length; i++){
            System.out.println(x[i]);
        }
    }

    private static double[] quadratics(double a, double b, double c){
        if (a != 0){
            double D = b*b-4*a*c;
            if (D>=0) {
                double[] x_1_2 = {(-b + Math.sqrt(D)) / (2 * a), (-b - Math.sqrt(D)) / (2 * a)};
                return x_1_2;
            }
            else{
                System.out.println("Die Lösung ist konjugiert komplex");
                return null;
            }
        }
        else{
            if (b!=0){
                double[] x = {-(c/b)};
                return x;
            }
            else{
                System.out.println("Die Gleichung ist degeneriert");
                return null;
            }
        }
    }

}
