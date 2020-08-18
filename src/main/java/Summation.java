import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Summation {

    private static final int CHUNK_SIZE = 10000;

    private ExecutorService pool;
    public Summation() {
        pool = Executors.newFixedThreadPool(50);
    }

    public Double summation(double nums[]){

        int chunks = (int) Math.floor(nums.length /CHUNK_SIZE);

        double sum = 0;

        List<Future<Double>> summers = new ArrayList<>();

        for(int c = 0; c<chunks; c++){
            SumArray summer = new SumArray(Arrays.copyOfRange(nums,c*CHUNK_SIZE, (c + 1)*CHUNK_SIZE ));
            Future<Double> futuro = pool.submit(summer);
            summers.add(futuro);
        }

        for(Future<Double> futuro: summers){
            try {
                sum +=futuro.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return sum;
    }
}
