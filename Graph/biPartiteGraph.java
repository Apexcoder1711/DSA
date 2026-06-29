import java.util.*;

public class biPartiteGraph {
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
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // Node 2 ke connections
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // Node 3 ke connections
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        // Node 4 ke connections
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int col[] = new int[graph.length];
        for(int i=0 ; i<col.length ; i++){
            col[i] = -1; // assigning all nodes to no color
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0 ; i<graph.length ;i++){
            if(col[i] == -1){ //bfs for every components of graph
                col[i] = 0; //yellow 
                q.add(i);
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0 ; j<graph[curr].size() ; j++){
                        Edge e = graph[curr].get(j);
                        if(col[e.dest] == -1){ //case 3
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }
                        else if(col[e.dest] == col[curr]){  //case 1
                            return false;    
                        }

                        //case 2 --> do nothing
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        /*
      0 ------- 2
     /         /
    /         /
   1         4
    \       /
     \     /
        3
   FALSE
*/

        int V=5;
        ArrayList<Edge> graph[] = new ArrayList[5];
        createGraph(graph);

        System.out.println(isBipartite(graph));
    }
}
