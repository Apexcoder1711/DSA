import java.util.*;
public class topologicalSorting {
    static class Edge{
        int src;
        int dest;
        Edge(int src , int dest){
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Node 0 aur 1 ki koi outgoing edge nahi hai (ye kisi aur ko point nahi karte)

        // Node 2 ke connections
        graph[2].add(new Edge(2, 3));

        // Node 3 ke connections
        graph[3].add(new Edge(3, 1));

        // Node 4 ke connections
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        // Node 5 ke connections
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topSort(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i=0 ; i<graph.length ;i++){
            if(!vis[i]){
                topSortUtil(graph , i , vis , s);
            }
        }

        while(!s.isEmpty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void topSortUtil(ArrayList<Edge> graph[] , int curr , boolean vis[] , Stack<Integer> s){
       //step 1 :- mark curr to visted
        vis[curr] = true;

        // step 2 :- call for neighbour
        for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                topSortUtil(graph , e.dest , vis , s);
            }
        }

        //step 3 :- add in stack
        s.add(curr);
    }

    public static void main(String[] args) {

        /*

       (5)------> 0 <------ 4
       |                   |
       v                   v
       (2)                  (1) 
        \                 ^
         \               /
          v             /
           3 ----------/
           
        */
        int V=6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topSort(graph);
    }
}
