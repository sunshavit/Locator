package test;

import com.locator.algorithms.BasicDistanceAlgo;
import com.locator.algorithms.DijkstraDistanceAlgo;
import com.locator.algorithms.datastructures.Graph;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class IAlgoDistanceTest {
     private static DijkstraDistanceAlgo dijkstraDistanceAlgo;
     private static BasicDistanceAlgo basicDistanceAlgo;
     private static Graph graph;
    @BeforeAll
    static void create() {
        basicDistanceAlgo = new BasicDistanceAlgo();
        dijkstraDistanceAlgo = new DijkstraDistanceAlgo();
        List<String> barNames = new ArrayList<>();
        barNames.add("Alenbi");
        barNames.add("Zoypher");
        barNames.add("Dublin");
        barNames.add("Cat & Dog");
        int vertices = 4;
        graph = new Graph(vertices,barNames);
        int sourceVertex = 0;
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 3, 4);
    }

    @Test
    void calculateDistanceDijkstra() {
        int[] expected = {0,4,3,6};
        assertArrayEquals(expected,dijkstraDistanceAlgo.calculateDistance(graph,0));
    }

    @Test
    void calculateDistanceBasic() {
        int[] expected = {0,9,10,9};
        assertArrayEquals(expected,basicDistanceAlgo.calculateDistance(graph,0));
    }
}