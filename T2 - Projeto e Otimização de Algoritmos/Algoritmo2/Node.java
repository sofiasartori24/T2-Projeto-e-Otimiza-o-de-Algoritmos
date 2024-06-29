package Algoritmo2;

import java.util.ArrayList;
import java.util.List;

//--- nó na árvore de decisão -------------------
public class Node {
    int level, profit, bound, weight;
    List<Integer> itemsIncluded;

    public Node() {
        itemsIncluded = new ArrayList<>();
    }
}
