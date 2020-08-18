package concurrency;

import model.Resource;

public class Producer implements Runnable {
    private static final int SLEEP = 1000;

    private String name;
    private Resource resource;

    public Producer(Resource resource) {
        this.resource = resource;
    }

    public Producer(String name, Resource resource) {
        this.name = name;
        this.resource = resource;
    }

    public Producer() {
    }

    @Override
    public void run() {
        while(true){
            try {
                int number = (int)(Math.random()*1000);
                System.out.println(name +" Producing " + number );
                resource.add(number);
                Thread.sleep(SLEEP);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
