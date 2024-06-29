package Algoritmo2;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Knapsack {
    private int[] wi, vi;
    private int W, n;

    public Knapsack(int n, int[] wi, int[] vi, int W) {
        this.n = n;
        this.wi = wi;
        this.vi = vi;
        this.W = W;
    }

    public void solveP2() {
        Queue<Node> Q = new LinkedList<>();
        Node u = new Node(), v = new Node();

        v.level = -1;
        v.profit = v.weight = 0;
        Q.add(v);

        int maxProfit = 0;
        List<Integer> bestItems = new ArrayList<>();

        while (!Q.isEmpty()) {
            v = Q.poll();

            if (v.level == -1)
                u.level = 0;

            if (v.level == n - 1)
                continue;

            u.level = v.level + 1;

            u.weight = v.weight + wi[u.level];
            u.profit = v.profit + vi[u.level];
            u.itemsIncluded = new ArrayList<>(v.itemsIncluded);
            u.itemsIncluded.add(u.level);

            if (u.weight <= W && u.profit > maxProfit) {
                maxProfit = u.profit;
                bestItems = new ArrayList<>(u.itemsIncluded);
            }

            u.bound = bound(u);

            if (u.bound > maxProfit)
                Q.add(u);

            u = new Node();
            u.weight = v.weight;
            u.profit = v.profit;
            u.level = v.level + 1;
            u.itemsIncluded = new ArrayList<>(v.itemsIncluded);

            u.bound = bound(u);

            if (u.bound > maxProfit)
                Q.add(u);
        }

        System.out.println("------------------------------------------");
        System.out.println("| - Valor ótimo -> " + maxProfit);
        System.out.println("| - Itens colocados na mochila -> ");
        System.out.println("------------------------------------------");
        for (int i : bestItems) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private int bound(Node u) {
        if (u.weight >= W)
            return 0;

        int profit_bound = u.profit;

        int j = u.level + 1;
        int totweight = u.weight;

        while ((j < n) && (totweight + wi[j] <= W)) {
            totweight += wi[j];
            profit_bound += vi[j];
            j++;
        }

        if (j < n) {
            profit_bound += (W - totweight) * vi[j] / wi[j];
        }

        return profit_bound;
    }
}
