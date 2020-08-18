public class Main {

    public static double[] getArray(){
        int size = 100000000;
        double[] array = new double[size];
        for(int i = 0; i < size; i++){
            array[i] = Math.random();
        }

        return array;
    }

    public static void main(String args[]){
        System.out.println("hola");

        Summation sum = new Summation();
        long t1 = System.nanoTime();
        double total = sum.summation(getArray());
        long t = System.nanoTime() - t1;

        System.out.println(total);

        System.out.println("t(ms) = "+t/1000000 + " ms");

    }
}
