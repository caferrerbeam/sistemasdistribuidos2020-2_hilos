package model;

import java.util.ArrayList;
import java.util.List;

public class Resource {

    private List<Integer> queue;

    public Resource(){
        queue = new ArrayList<>();
    }

    public synchronized void add(Integer number){
        queue.add(number);
        this.notifyAll();
    }

    public synchronized int get(){
        while(queue.isEmpty()) {
            try {
                System.out.println(" ESPERANDO.........................."+ Thread.currentThread().getName());
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.remove(queue.size() - 1);
    }
}
