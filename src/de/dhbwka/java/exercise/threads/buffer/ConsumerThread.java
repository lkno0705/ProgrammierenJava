package de.dhbwka.java.exercise.threads.buffer;

public class ConsumerThread extends Thread {

    MyBuffer buffer;

    public ConsumerThread(MyBuffer b){
        this.buffer = b;
    }

    public void run(){
        int i = 0;
        while (i <= 100) {
            this.buffer.get();
            try {
                this.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

}
