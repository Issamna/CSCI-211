/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
Graph with Bellman-Fords Algorithm
 */
class Main {
    public static void main(String[] args) {

        System.out.println("\nShortest Path - Bellman-Ford");
        System.out.println("------------------------------");
        //Number of vertexs and edges in graph
        int vertex = 7;
        int edge = 24;

        //Create graph and edit edges
        BFGraph graph = new BFGraph(vertex,edge);
        graph.setEdge(0, 0, 1, 3);
        graph.setEdge(1, 0, 2, 6);
        graph.setEdge(2, 1, 0, 3);
        graph.setEdge(3, 1, 2, 2);
        graph.setEdge(4, 1, 3, 1);
        graph.setEdge(5, 2, 1, 6);
        graph.setEdge(6, 2, 1, 2);
        graph.setEdge(7, 2, 3, 1);
        graph.setEdge(8, 2, 4, 4);
        graph.setEdge(9, 2, 5, 2);
        graph.setEdge(10, 3, 1, 1);
        graph.setEdge(11, 3, 2, 1);
        graph.setEdge(12, 3, 4, 2);
        graph.setEdge(13, 3, 6, 4);
        graph.setEdge(14, 4, 2, 4);
        graph.setEdge(15, 4, 3, 2);
        graph.setEdge(16, 4, 5, 2);
        graph.setEdge(17, 4, 6, 1);
        graph.setEdge(18, 5, 2, 2);
        graph.setEdge(19, 5, 4, 2);
        graph.setEdge(20, 5, 6, 1);
        graph.setEdge(21, 6, 3, 4);
        graph.setEdge(22, 6, 4, 1);
        graph.setEdge(23, 6, 5, 1);

        //Calculate shortest distance
        graph.shortestPathBF(graph, 0);

    }
}