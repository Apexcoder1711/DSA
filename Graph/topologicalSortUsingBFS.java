import java.util.*;
public class topologicalSortUsingBFS {
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

    public static void calcIndgree(ArrayList<Edge> graph[] , int indegree[]){
        for(int i=0 ; i<graph.length ; i++){
            for(int j=0 ; j<graph[i].size() ; j++){
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }
    }
    public static void topSort(ArrayList<Edge> graph[]){
        int indgree[] = new int[graph.length];
        calcIndgree(graph, indgree);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0 ; i<indgree.length ; i++){
            if(indgree[i] == 0){
                q.add(i);
            }
        }

        //bfs
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " ");//topological sort print

            for(int i=0 ; i<graph[curr].size() ; i++){
                Edge e = graph[curr].get(i);
                indgree[e.dest]--;
                if(indgree[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
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

