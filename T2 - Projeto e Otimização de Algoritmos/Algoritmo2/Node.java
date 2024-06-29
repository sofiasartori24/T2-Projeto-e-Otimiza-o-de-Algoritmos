package Algoritmo2;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int level, profit, bound, weight;
    List<Integer> itemsIncluded;

    public Node() {
        itemsIncluded = new ArrayList<>();
    }
}
