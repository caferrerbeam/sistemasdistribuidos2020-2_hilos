import java.util.concurrent.Callable;

public class SumArray extends Thread {

    private double[] nums;
    private double result;

    public SumArray(double[] nums) {
        this.nums = nums;
    }

    public double sum(double array[]){
        double sum = 0;

        for (double num:array) {
            sum +=num;
        }
        try {
            Thread.sleep((long)(Math.random()*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sum;
    }

    @Override
    public void run() {
        System.out.println("corrienndo sumador...");
        result = sum(nums);
    }

    public double getResult(){
        return result;
    }
}
