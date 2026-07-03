import java.util.*;
public class DijkstraAlgorithm {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int src , int dest , int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Node 0 ke connections
        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        // Node 1 ke connections
        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        // Node 2 ke connections
        graph[2].add(new Edge(2, 4, 3));

        // Node 3 ke connections
        graph[3].add(new Edge(3, 5, 1));

        // Node 4 ke connections
        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        // Node 5 ki koi outgoing edge nahi hai isliye code mein nahi hai
    }

    static class Pair{
        int n;
        int path;
        Pair(int n , int path){
            this.n = n;
            this.path = path;
        }
    }

    //BFS traversing
    public static void dijkstra(ArrayList<Edge> graph[] , int src){
        boolean vis[] = new boolean[graph.length]; 
        int dist[] = new int[graph.length];
        for(int i=0 ; i<dist.length ;i++){
            if(src != i){
                dist[i] = Integer.MAX_VALUE; //+ infinity
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.path - p2.path);

        pq.add(new Pair(src, 0)); // src with 0 dist are added

        while(!pq.isEmpty()){
            Pair curr = pq.remove(); //it return minimum dist node
            if(!vis[curr.n]){
                vis[curr.n] = true;
                //neighbours
                for(int i=0 ; i<graph[curr.n].size() ; i++){
                    Edge e = graph[curr.n].get(i);
                    int u = e.src;
                    int v = e.dest;
                    int wt  = e.wt;

                    if(dist[u] + wt < dist[v]){
                        dist[v] = dist[u] + wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for(int i=0 ; i<dist.length ; i++){
            System.out.println("Shortest dist from " + src + " to " + i + " = " + dist[i]);
        }
    }

    public static void main(String[] args) {

       /*
                 (2)           (7)
             0 --------> 1 ------------> 3
             |           |             ^ |
             |           |           /   |
         (4) |       (1) |      (2)/     | (1)
             |           |       /       |
             v           v     /         v
             2 --------> 4 ------------> 5
                 (3)           (5)
        */
        int V=6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 0;
        dijkstra(graph, src);
    }
}
