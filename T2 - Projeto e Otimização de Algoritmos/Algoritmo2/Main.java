package Algoritmo2;

public class Main {
    public static void main(String[] args) {
        //--- Definição dos itens e da capacidade da mochila ---------
        int n = 5;
        int[] wi = {5, 6, 2, 1, 7};
        int[] vi = {18, 22, 6, 1, 28};
        int W = 11;

        Backpack solver = new Backpack(n, wi, vi, W);

        long startTime = System.nanoTime();
        solver.solveP2();
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);  // Calcular a duração
        double durationInSeconds = (double) duration / 1_000_000_000.0; // Converter para segundos

        System.out.println("|- Tempo de execução: " + duration + " nanosegundos (" + durationInSeconds + " segundos)");
        System.out.println("----------------------------------------------------------------");


    }
}
