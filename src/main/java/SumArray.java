public class SumArray {

    public double sum(double array[]){
        double sum = 0;

        for (double num:array) {
            sum +=num;
        }

        return sum;
    }
}
