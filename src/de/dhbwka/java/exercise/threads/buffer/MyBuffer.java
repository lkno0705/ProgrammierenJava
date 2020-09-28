package de.dhbwka.java.exercise.threads.buffer;

import java.util.LinkedList;

public class MyBuffer {

    private LinkedList<Integer> values = new LinkedList<>();
    private int MAXSIZE = 3;

    public synchronized void put(int v) {
        if (this.values.size() == MAXSIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        this.values.add(v);
        this.notify();
        System.out.println("Put: " + v + " Add level: " + this.values.size());
    }

    public synchronized int get() {
        int v;
        if (this.values.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        v = this.values.pop();
        this.notify();
        System.out.println("Get:" + v);
        return v;
    }

    public MyBuffer(int MAXSIZE) {
        this.MAXSIZE = MAXSIZE;
    }

    public MyBuffer() {}
}
