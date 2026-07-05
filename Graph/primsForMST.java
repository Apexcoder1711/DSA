import java.util.*;
public class primsForMST {
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
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        // Node 1 ke connections
        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        // Node 2 ke connections
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        // Node 3 ke connections
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair{
        int v;
        int cost;
        Pair(int v , int cost){
            this.v = v;
            this.cost = cost;
        }
    }

    public static void primsMSTcost(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1 , p2) -> p1.cost - p2.cost);
        pq.add(new Pair(0, 0)); //starting with node 0 with cost = 0;
        int finalCost = 0 ; //agr edge chahiye toh ArrayList<Edge> bnana hoga

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                finalCost += curr.cost;

                //add neighbours
                for(int i = 0 ; i<graph[curr.v].size() ; i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }

        System.out.println("final(minimum) cost of MST = " + finalCost);
    }


    public static ArrayList<Edge> primsMST(ArrayList<Edge> graph[]) {
        boolean vis[] = new boolean[graph.length];
        
        // Parent track karne ke liye array kyunki Pair mein se parent hata diya hai
        int parent[] = new int[graph.length]; 
        // Ek node tak pahunchne ki minimum cost track karne ke liye
        int minCost[] = new int[graph.length]; 

        for (int i = 0; i < graph.length; i++) {
            parent[i] = -1; // Initially sabka parent -1 hoga
            minCost[i] = Integer.MAX_VALUE; // Initially cost infinity hogi
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p1.cost - p2.cost);
        
        pq.add(new Pair(0, 0));
        minCost[0] = 0;
        
        ArrayList<Edge> mstEdges = new ArrayList<>(); // Sirf edges store karne ke liye

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            
            if (!vis[curr.v]) {
                vis[curr.v] = true;
                
                // Starting node (0) ka parent -1 hota hai, usko chhod kar baaki sabhi valid edges MST mein dalenge
                if (parent[curr.v] != -1) {
                    mstEdges.add(new Edge(parent[curr.v], curr.v, curr.cost));
                }

                // Add neighbours
                for (int i = 0; i < graph[curr.v].size(); i++) {
                    Edge e = graph[curr.v].get(i);
                    
                    // Optimization: Agar neighbor unvisited hai AUR nayi edge ka weight purane weight se kam hai
                    if (!vis[e.dest] && e.wt < minCost[e.dest]) {
                        parent[e.dest] = curr.v; // Parent array mein update kar diya
                        minCost[e.dest] = e.wt;  // Nayi cost update kar di
                        pq.add(new Pair(e.dest, e.wt));
                    }
                }
            }
        }

        return mstEdges; // Poora MST return kar rahe hain
    }

    public static void main(String[] args) {

        /*
              0
           /  |  \
     (10) /   |   \ (15)
         /  (30)   \
        1     |     2
         \    |    /
     (40) \   |   / (50)
           \  |  /
              3
*/
        int V=4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        primsMSTcost(graph);

        ArrayList<Edge> mstEdges = primsMST(graph);

        System.out.println("Edges in Minimum Spanning Tree (MST):");
        for (Edge e : mstEdges) {
            System.out.println(e.src + " --- " + e.dest + " (Cost: " + e.wt + ")");
        }

    }
}
