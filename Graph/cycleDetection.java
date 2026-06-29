import java.util.*;
public class cycleDetection {
    static class Edge {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));


    }

    // pura dfs ki code ki trh hi hai 

    
    public static boolean cycleDetect(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0 ; i<graph.length ; i++){
            if(!vis[i]) {
                if(cycleDetectUtil(graph, vis, i , -1)){ //starting source 0 ka parent -1 hoga
                    return true;
                }

            }
        }
        return false;
    }

    public static boolean cycleDetectUtil(ArrayList<Edge> graph[] , boolean vis[] , int curr , int parent){
        vis[curr] = true;

        for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);

            //Case 3:-
            if(!vis[e.dest]){
                if(cycleDetectUtil(graph, vis, e.dest,curr)){
                    return true;
                }
            }

            //Case 1:- if neighbour is visited but not parent
            else if(vis[e.dest] && parent != e.dest){
                return true;
            }

            //Case 2 :- if parent == neighbour iska mtlb cycle nhi hai 

        }

        return false;
    }



    public static void main(String[] args) {
        /*

       0 -------- 3
      /|          |
     / |          |
    1  |          4
     \ |
      \|
       2

        */
        int V=5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println(cycleDetect(graph));
    }
}
