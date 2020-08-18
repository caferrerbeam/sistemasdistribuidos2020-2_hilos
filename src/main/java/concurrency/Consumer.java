package concurrency;

import model.Resource;

public class Consumer implements Runnable {

    private static final int SLEEP = 100;

    private Resource resource;
    private String name;

    public Consumer(Resource resource, String name) {
        this.resource = resource;
        this.name = name;
    }

    public Consumer(Resource resource) {
        this.resource = resource;
    }

    public Consumer() {
    }

    @Override
    public void run() {
        while(true){
            try {
                int number = resource.get();
                System.out.println("********************"+name +" consuming " + number );
                Thread.sleep(SLEEP);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
