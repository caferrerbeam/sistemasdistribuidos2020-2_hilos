import java.util.Arrays;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Summation {

    private static final int CHUNK_SIZE = 1000;

    private Executor pool;
    public Summation() {
        pool = Executors.newFixedThreadPool(10);
    }

    public Double summation(double nums[]){

        int chunks = (int) Math.floor(nums.length /CHUNK_SIZE);

        double sum = 0;

        for(int c = 0; c<chunks; c++){
            sum += new SumArray().sum(Arrays.copyOfRange(nums,c*CHUNK_SIZE, (c + 1)*CHUNK_SIZE ));
        }

        return sum;
    }
}
