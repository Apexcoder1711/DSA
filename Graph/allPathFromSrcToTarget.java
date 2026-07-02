
import java.util.*;
public class allPathFromSrcToTarget {
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

        // Node 0 ke connections
        graph[0].add(new Edge(0, 3));

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

    public static void printAllPathFromSrcToDest(ArrayList<Edge> graph[] , int src ,int dest , String path){
        if(src == dest){
            System.out.println(path + dest);
            return;
        }

        for(int i=0 ; i<graph[src].size() ; i++){
            Edge e = graph[src].get(i);
            printAllPathFromSrcToDest(graph, e.dest, dest, path+src);
        }
    }



    public static void main(String[] args) {

       /*
       5 ------> 0 <------ 4
       |         |         |
       v         v         v
       2 ------> 3 ------> 1
*/
        int V=6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        int src = 5;
        int dest = 1;
        printAllPathFromSrcToDest(graph, src, dest, "");
    }
}

