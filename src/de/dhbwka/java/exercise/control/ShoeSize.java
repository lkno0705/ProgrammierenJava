package de.dhbwka.java.exercise.control;

import java.text.DecimalFormat;

//for (int groeße = 30; groeße<=49; groeße++) if (groeße == 30) System.out.print("19,33 - " + format.format(Math.round((groeße/1.5)*100)/100.00) + "  |  " + groeße + "\n" + format.format(Math.round((groeße/1.5)*100)/100.00) + " - "); else if (groeße != 49) System.out.print(format.format(Math.round((groeße/1.5)*100)/100.00) + "  |  " + " " + groeße + "\n"  + format.format(Math.round((groeße/1.5)*100)/100.00) + " - "); else System.out.print(format.format(Math.round((groeße/1.5)*100)/100.00) + "  |  " + groeße + "\n");

public class ShoeSize {
    public static void main(String[] args) {
        //Schuhgröße = Zentimeter * 1,5
        DecimalFormat format = new DecimalFormat("#00.00");
        System.out.println("Zentimeter   |  Größe \n---------------------");
        for (int groeße = 30; groeße<=49; groeße++) {
            String centi = format.format(Math.round((groeße/1.5)*100)/100.00);
            switch (groeße) {
                case 30:
                    System.out.print("19,33 - " + centi + "  |  " + groeße + "\n" + centi + " - ");
                    break;
                case 49:
                    System.out.print(centi + "  |  " + groeße + "\n");
                    break;
                default:
                    System.out.print(centi + "  |  " + groeße + "\n" + centi + " - ");
                    break;
            }
        }
    }
}
