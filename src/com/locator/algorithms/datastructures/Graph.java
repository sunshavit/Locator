package com.locator.algorithms.datastructures;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private int vertices;
    private int matrix[][];
    private Map<Integer,T> bars;


    public Graph(int vertex, List<T> bars) {
        this.vertices = vertex;
        this.bars = new HashMap<>();
        matrix = new int[vertex][vertex];
        for (int i = 0; i < bars.size(); i++) {
            this.bars.put(i,bars.get(i));
        }
    }

    public void addEdge(int source, int destination, int weight) {
        matrix[source][destination]=weight;
        matrix[destination][source] = weight;
    }

    public int getMinimumVertex(boolean [] mst, int [] key){
        int minKey = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i <vertices ; i++) {
            if(mst[i]==false && minKey>key[i]){
                minKey = key[i];
                vertex = i;
            }
        }
        return vertex;
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Map<Integer, T> getBars() {
        return bars;
    }

    public void setBars(Map<Integer, T> bars) {
        this.bars = this.bars;
    }
}