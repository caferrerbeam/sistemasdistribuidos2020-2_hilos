public class SumArray {

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
}
