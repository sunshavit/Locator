package com.locator.algorithms;

import com.locator.algorithms.datastructures.Graph;

public class DijkstraDistanceAlgo implements IAlgoDistance {
    @Override
    public int[] calculateDistance(Graph graph, int sourceVertex) {
        boolean[] spt = new boolean[graph.getVertices()];
        int[] distance = new int[graph.getVertices()];
        int INFINITY = Integer.MAX_VALUE;

        //Initialize all the distance to infinity
        for (int i = 0; i < graph.getVertices(); i++) {
            distance[i] = INFINITY;
        }

        //start from the vertex 0
        distance[sourceVertex] = 0;

        //create SPT
        for (int i = 0; i < graph.getVertices(); i++) {

            //get the vertex with the minimum distance
            int vertex_U = graph.getMinimumVertex(spt, distance);

            //include this vertex in SPT
            spt[vertex_U] = true;

            //iterate through all the adjacent vertices of above vertex and update the keys
            for (int vertex_V = 0; vertex_V < graph.getVertices(); vertex_V++) {
                //check of the edge between vertex_U and vertex_V
                if (graph.getMatrix()[vertex_U][vertex_V] > 0) {
                    //check if this vertex 'vertex_V' already in spt and
                    // if distance[vertex_V]!=Infinity

                    if (spt[vertex_V] == false && graph.getMatrix()[vertex_U][vertex_V] != INFINITY) {
                        //check if distance needs an update or not
                        //means check total weight from source to vertex_V is less than
                        //the current distance value, if yes then update the distance

                        int newKey = graph.getMatrix()[vertex_U][vertex_V] + distance[vertex_U];
                        if (newKey < distance[vertex_V])
                            distance[vertex_V] = newKey;
                    }
                }
            }
        }
        printDijkstra(sourceVertex,distance,graph);
        return distance;
    }

    public void printDijkstra(int sourceVertex, int [] key,Graph graph){
        System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
        for (int i = 0; i < graph.getVertices() ; i++) {
            System.out.println("Source Bar: " + graph.getBars().get(sourceVertex)+ " to " +  graph.getBars().get(i)  +
                    " distance: " + key[i]);
        }
    }

}
