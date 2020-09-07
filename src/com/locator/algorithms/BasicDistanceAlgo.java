package com.locator.algorithms;

import com.locator.algorithms.datastructures.Graph;

import static java.util.Collections.min;

public class BasicDistanceAlgo implements IAlgoDistance {
    @Override
    public int[] calculateDistance(Graph graph, int sourceVertex) {
        int[] distance = new int[graph.getVertices()];
        boolean[] colors = new boolean[graph.getVertices()];

        for (int i = 0; i < graph.getVertices(); i++) {
            setFalse(colors);
            distance[i] = minimumCostSimplePath(sourceVertex,i,colors,graph);
        }
        printDistance(sourceVertex,distance,graph);
        return distance;
    }

    int minimumCostSimplePath(int u, int destination,
                              boolean visited[], Graph graph)
    {

        // check if we find the destination
        // then further cost will be 0
        if (u == destination)
            return 0;

        // marking the current node as visited
        visited[u] = true;

        int ans = -1;

        // traverse through all
        // the adjacent nodes
        for (int i = 0; i < graph.getVertices(); i++) {
            if (graph.getMatrix()[u][i] != 0 && !visited[i]) {

                // cost of the further path
                int curr = minimumCostSimplePath(i,
                        destination, visited, graph);

                // check if we have reached the destination
                if (curr > -1) {

                    // Taking the minimum cost path
                    if(ans<graph.getMatrix()[u][i]+curr)
                        ans=graph.getMatrix()[u][i]+curr;
                }
            }
        }

        // unmarking the current node
        // to make it available for other
        // simple paths
        visited[u] = true;

        // returning the minimum cost
        return ans;
    }

    private void printDistance(int sourceVertex, int [] key,Graph graph){
        System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
        for (int i = 0; i < graph.getVertices() ; i++) {
            System.out.println("Source Bar: " + sourceVertex + " to " +  i  +
                    " distance: " + key[i]);
        }
    }

    private void setFalse(boolean[] colors){
        for (int i = 0; i < colors.length; i++) {
            colors[i] = false;
        }
    }
}
