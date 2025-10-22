package Multithreading.ThreadCommunication;

import java.util.function.Consumer;

class SharedResource{
    private int data;
    private boolean hasData;
    public synchronized void produce(int value){
        while (hasData){
            try {
                wait();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        data = value;
        hasData = true;
        System.out.println("Produced:" + value);
        notify();
        //incase of more than one Thread notifyAll();
    }
    public synchronized int consume(){
        while (!hasData){
            try {
                wait();
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        hasData = false;
        notify();
        System.out.println("Consumed:" + data);
        return data;
    }
}
class Producer implements Runnable{
    private SharedResource resource;

    public Producer(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.produce(i);
        }
    }
}

class Consumers implements Runnable{
    private SharedResource resource;

    public Consumers(SharedResource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            resource.consume();
        }
    }
}


public class ThreadCommunication {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        Thread producerThread = new Thread(new Producer(sharedResource));
        Thread consumerThread = new Thread(new Consumers(sharedResource));

        producerThread.start();
        consumerThread.start();
    }
}
