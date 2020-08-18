import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Summation {

    private static final int CHUNK_SIZE = 10000;

    public Summation() {
    }

    public Double summation(double nums[]){
        int chunks = (int) Math.floor(nums.length /CHUNK_SIZE);

        double sum = 0;

        List<SumArray> hilos = new ArrayList<>();

        for(int c = 0; c<chunks; c++){
            SumArray summer = new SumArray(Arrays.copyOfRange(nums,c*CHUNK_SIZE, (c + 1)*CHUNK_SIZE ));
            hilos.add(summer);

            summer.start();
        }

        for (SumArray summer: hilos) {
            try {
                summer.join();

                sum += summer.getResult();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return sum;
    }
}
