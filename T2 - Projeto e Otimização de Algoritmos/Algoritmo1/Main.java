package Algoritmo1;

public class Main {
    public static void main(String[] args) {
        int[] l = {10, 1, 10, 10, 10};
        int[] h = {50, 1, 50, 1, 50};

        TaskPlanning p1 = new TaskPlanning();

        p1.solveP1(l, h);
    }
}
