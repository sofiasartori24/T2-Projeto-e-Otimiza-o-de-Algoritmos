package Algoritmo1;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int[] sizes = {10, 100, 500, 1000};
        int maxValue = 100;

        for (int size : sizes) {
            int[] l = generateRandomArray(size, maxValue);
            int[] h = generateRandomArray(size, maxValue);

            TaskPlanning p1 = new TaskPlanning();

            long startTime = System.nanoTime();
            p1.solveP1(l, h);
            long endTime = System.nanoTime();

            long duration = (endTime - startTime);
            System.out.println("Execution time for size " + size + ": " + duration + " ns\n");
        }
    }
    public static int[] generateRandomArray(int size, int maxValue) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(maxValue) + 1; // Valores entre 1 e maxValue
        }
        return array;
    }
}



