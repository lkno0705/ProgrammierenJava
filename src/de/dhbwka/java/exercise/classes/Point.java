package de.dhbwka.java.exercise.classes;

public class Point {
    private double x;
    private double y;

    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String toString(){
        return "P(" + x + "|" + y + ")";
    }

    public Point mirrorX(){
        return new Point(x, -y);
    }
    public Point mirrorY(){
        return new Point(-x , y);
    }
    public Point mirrorOrigin(){
        return new Point(-this.x,-this.y);
    }
    public double distanceOrigin(){
        return Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }
    public double getDistance(Point b){
        return Math.sqrt(Math.pow(this.x-b.x,2) + Math.pow(this.y + b.y, 2));
    }

    public static void main(String[] args) {
        Point pointA = new Point(4.0, 2.0);
        System.out.println("A: " + pointA);
        Point pointB = new Point(-1.0, -1.0);
        System.out.println("B: " + pointB);
        System.out.println("Abstand A-B: "
                + pointA.getDistance(pointB));
        pointA = pointA.mirrorOrigin();
        System.out.println("A': " + pointA);
        System.out.println("Abstand A’-B: "
                + pointA.getDistance(pointB));
    }

}
