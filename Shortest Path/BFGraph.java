/**
 * @author Issam Ahmed
 *         CSCI 211 Fall 2019
 *    Bellman-Ford Algorithm
 */
class BFGraph{

    /**
     * Weighted edge class in graph
     */
    class Edge{
        int src;      //Edge source vertex
        int dest;     //Edge destination vertex
        int cost;     //Edge weight cost

        public Edge(){
            src = 0;
            dest = 0;
            cost = 0;
        }
    }

    int v;          //Number of vertices
    int e;          //Number of edges
    Edge edge[];    //Array of all edges

    /**Constructor for graph
     * @param v Number of vertices in graph
     * @param e Number of edges in graph
     */
    public BFGraph(int v,int e){
        this.v = v;
        this.e = e;
        edge = new Edge[e];
        for(int i = 0; i<e;i++){
            edge[i] = new Edge();
        }
    }

    /**SetEdge()
     * Set edges source, destination and weight
     * @param edgeNum  Edge to be edited
     * @param src      Edge source vertex
     * @param dest     Edge destination vertex
     * @param cost     Edge weight cost
     */
    public void setEdge(int edgeNum, int src, int dest, int cost){
        edge[edgeNum].src = src;
        edge[edgeNum].dest = dest;
        edge[edgeNum].cost = cost;
    }

    /**shortestPathBF()
     * Bellman-Ford algorithm for shortest path, Prints results
     * @param graph  graph to be used
     * @param start  starting vertex
     */
    public void shortestPathBF(BFGraph graph, int start){
        //create distance array and make distances a large number(9999)
        int dist[] = new int[v];
        for( int i=1; i <v;i++){
            dist[i]=9999;
        }
        dist[start] = 0;

        //loop to relax all edges V-1 times
        for (int i=1; i<v; i++){
            for(int j=0; j<e; j++){
                //get edge information
                int u = graph.edge[j].src;
                int t = graph.edge[j].dest;
                int cost = graph.edge[j].cost;
                //check if shortest
                if(dist[u] != 9999 && dist[u]+cost < dist[t]){
                    dist[t] = dist[u] + cost;
                }
            }
        }

        //Loop for negative cost cycles
        for(int j=0; j<e; j++){
            //get edge information
            int u = graph.edge[j].src;
            int t = graph.edge[j].dest;
            int cost = graph.edge[j].cost;
            //check for negative cost cycles
            if(dist[u] != 9999 && dist[u]+cost < dist[t]){
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        //Print result
        for (int i = 0; i < v; ++i) {
            System.out.println(start+" to "+i+", Cost: "+dist[i]);
        }

    }
}