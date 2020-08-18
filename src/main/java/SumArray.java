import java.util.concurrent.Callable;

public class SumArray implements Callable<Double> {

    private double result;
    private double[] numbers;

    public SumArray() {
    }

    public SumArray(double[] numbers) {
        this.numbers = numbers;
    }

    private double sum(double array[]){
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
    public Double call() throws Exception {
        System.out.println("sumando....");
        return sum(numbers);
    }

    public double getResult() {
        return result;
    }
}
