package Algoritmo1;

public class TaskPlanning {

    public TaskPlanning() {}

    public void solveP1(int[] l, int[] h) {
        int n = l.length;
        int[] dp = new int[n + 1];
        int[] task = new int[n + 1];


        // Caso base para a primeira semana
        if (n > 0) {
            dp[1] = Math.max(l[0], h[0]);
            task[1] = (h[0] > l[0]) ? 1 : 0;
        }

        for (int i = 2; i <= n; i++) {
            // Escolha a tarefa de baixa dificuldade
            if (dp[i - 1] + l[i - 1] > dp[i]) {
                dp[i] = dp[i - 1] + l[i - 1];
                task[i] = 0;
            }

            // Escolha a tarefa de alta dificuldade, se possível
            if (i > 1 && dp[i - 2] + h[i - 1] > dp[i]) {
                dp[i] = dp[i - 2] + h[i - 1];
                task[i] = 1;
                task[i - 1] = -1; // Marque a semana anterior como "não fazer nada"
            }
        }

        // Output the tasks
        System.out.println("Plan: ");
        for (int i = 1; i <= n; i++) {
            if (task[i] == 0) {
                System.out.println("Week " + i + ": Low-stress job");
            } else if (task[i] == 1) {
                System.out.println("Week " + i + ": High-stress job");
            } else if (task[i] == -1) {
                System.out.println("Week " + i + ": Do nothing");
            }
        }

        // Output the maximum revenue
        System.out.println("Maximum revenue: " + dp[n]);
    }
}
