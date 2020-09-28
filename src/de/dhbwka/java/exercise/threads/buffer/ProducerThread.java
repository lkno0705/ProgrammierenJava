package de.dhbwka.java.exercise.threads.buffer;

public class ProducerThread extends Thread{
    MyBuffer buf;

    public ProducerThread(MyBuffer b){
        this.buf = b;
    }

    public void run() {
        int i = 0;
        while (i <= 100) {
            this.buf.put((int) (Math.random()*100));
            try {
                this.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
