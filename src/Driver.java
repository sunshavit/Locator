import com.barlocator.datastructures.Edge;
import com.barlocator.datastructures.Vertex;
import com.barlocator.datastructures.WeightedGraph;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {

        //Initialization
        List<Vertex> vertices = new ArrayList<>();
        vertices.add(new Vertex(0,"Zoypher"));
        vertices.add(new Vertex(1,"Havana"));
        vertices.add(new Vertex(2,"Mezeg"));
        vertices.add(new Vertex(3,"Alenbi 69"));
        vertices.add(new Vertex(4,"Cat & Dog"));

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(vertices.get(0), vertices.get(1),2));
        edges.add(new Edge(vertices.get(0), vertices.get(2),4));
        edges.add(new Edge(vertices.get(1), vertices.get(3),5));
        edges.add(new Edge(vertices.get(3), vertices.get(4),7));
        edges.add(new Edge(vertices.get(4), vertices.get(2),8));

        WeightedGraph graph = new WeightedGraph(edges);

        System.out.println(graph);
    }
}
