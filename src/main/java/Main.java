import concurrency.Consumer;
import concurrency.Producer;
import model.Resource;

public class Main {

    public static void main(String args[]){
        Resource resource = new Resource();

        //new Thread(new Producer("producer1", resource)).start();
        new Thread(new Producer("producer2",resource), "producer2").start();

        new Thread(new Consumer(resource,"consumer1"),"consumer1").start();
        new Thread(new Consumer(resource,"consumer2222222"),"consumer2222222").start();

        System.out.println("hola");
    }
}
