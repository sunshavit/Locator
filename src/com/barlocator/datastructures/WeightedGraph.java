package com.barlocator.datastructures;

import java.util.*;

public class WeightedGraph {
    private Map<Integer,Map<Integer,Vertex>> graph;

    public WeightedGraph(List<Edge> edgeList) {
        graph = new HashMap<>();
        for (Edge edge : edgeList) {
           if(!graph.containsKey(edge.getSrc().getValue())) {
               graph.put(edge.getSrc().getValue(), new HashMap<Integer, Vertex>());
           }
           Vertex vertex = new Vertex(edge.getDst().getValue(),edge.getDst().getBarName());
           vertex.setWeight(edge.getWeight());
           graph.get(edge.getSrc().getValue()).put(vertex.getValue(),vertex);
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        return "WeightedGraph{" +
                "graph=" + graph +
                '}';
    }

    public Map<Integer, Map<Integer, Vertex>> getGraph() {
        return graph;
    }

    public void setGraph(Map<Integer, Map<Integer, Vertex>> graph) {
        this.graph = graph;
    }
}