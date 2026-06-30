import java.util.*;

public class cycleDetectionInDirectedGraph {
    static class Edge{
        int src;
        int dest;
        Edge(int src , int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0 ; i<graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        // Node 0 ke connections
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // Node 1 ke connections
        graph[1].add(new Edge(1, 3));

        // Node 2 ke connections
        graph[2].add(new Edge(2, 3));
    }

    public static boolean isCycle(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0 ; i<graph.length ; i++){
            if(!vis[i]){
                if(isCycleUtil(graph , i , vis , stack)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge> graph[] , int curr , boolean[] vis ,  boolean stack[]){
        vis[curr] = true;
        stack[curr] = true;

        for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){
                return true; // cycle exists
            }
            else if(!vis[e.dest] && isCycleUtil(graph, e.dest, vis, stack)){
                return true;
            }
        }

        stack[curr] = false;
        return false;
    }
    
    public static void main(String[] args) {


        int V=5;
        ArrayList<Edge> graph[] = new ArrayList[5];
        createGraph(graph);

        /*
      0
    /   \
   v     v
  1       2
   \     /
    v   v
      3
*/
        System.out.println(isCycle(graph));

        
    }
}
