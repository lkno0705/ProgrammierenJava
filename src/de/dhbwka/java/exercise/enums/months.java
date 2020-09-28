package de.dhbwka.java.exercise.enums;

import java.util.Calendar;

public class months {
    public enum MONTHS{
        JANUAR(31, "Januar", "Hartung, Eismond"),
        FEBRUAR(28, "Februar", "Hornung, Schmelzmond, Taumond, Narrenmond, Rebmond, Hintester"),
        MAERZ(31, "März", " Lenzing, Lenzmond"),
        APRIL(30, "April", " Launing, Ostermond"),
        MAI(31, "Mai", " Winnemond, Blumenmond"),
        JUNI(30, "Juni", "Brachet, Brachmond"),
        JULI(31, "Juli", " Heuert, Heumond"),
        AUGUST(31, "August", " Ernting, Erntemond, Bisemond"),
        SEPTEMPER(30, "September", "Scheiding, Herbstmond"),
        OKTOBER(31, "Oktober", " Gilbhart, Gilbhard, Weinmond"),
        NOVEMBER(30, "November", "Nebelung, Windmond, Wintermond"),
        DEZEMBER(31, "Dezember", "Julmond, Heilmond, Christmond, Dustermond");

        public int days;
        public String oldNames;
        public String name;

        MONTHS(int days, String name, String oldNames){
            this.days = days;
            this.oldNames = oldNames;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Der " + name + " hat " + days + " Tage und hieß früher " + oldNames;
        }
    }

    public static void main(String[] args) {
       System.out.println(MONTHS.values()[Calendar.getInstance().get(Calendar.MONTH)].toString());
    }
}
