package clase6;

import java.util.*;

class Edge implements Comparable<Edge> {
    int source, destination, weight;

    public Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class Graph {
    private int vertices;
    private List<List<Edge>> adjacencyList;

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Edge(source, destination, weight));
        adjacencyList.get(destination).add(new Edge(destination, source, weight));
    }

    public void primMST() {
        boolean[] inMST = new boolean[vertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;

        inMST[0] = true;
        pq.addAll(adjacencyList.get(0));

        while (!pq.isEmpty() && mstEdges.size() < vertices - 1) {
            Edge edge = pq.poll();
            if (inMST[edge.destination]) {
                continue;
            }

            mstEdges.add(edge);
            totalCost += edge.weight;
            inMST[edge.destination] = true;

            for (Edge nextEdge : adjacencyList.get(edge.destination)) {
                if (!inMST[nextEdge.destination]) {
                    pq.add(nextEdge);
                }
            }
        }

        System.out.println("Conexiones en el Árbol de Recubrimiento Mínimo:");
        for (Edge e : mstEdges) {
            System.out.println(e.source + " - " + e.destination + " (Costo: " + e.weight + ")");
        }
        System.out.println("Costo total del MST: " + totalCost);
    }
}

public class Actividad3 {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 6);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 9);
        graph.addEdge(3, 4, 7);
        graph.addEdge(3, 5, 5);
        graph.addEdge(4, 5, 11);

        graph.primMST();
    }
}

