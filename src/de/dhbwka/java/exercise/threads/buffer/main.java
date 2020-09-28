package de.dhbwka.java.exercise.threads.buffer;

public class main {

    public static void main(String[] args) throws InterruptedException {
        MyBuffer buffer = new MyBuffer();
        ProducerThread producerThread = new ProducerThread(buffer);
        ConsumerThread consumerThread = new ConsumerThread(buffer);
        producerThread.start();
        consumerThread.start();
        producerThread.join();
        consumerThread.join();
    }

}
