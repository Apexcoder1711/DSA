import java.util.*;
import java.util.LinkedList;

public class graphTraversal {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src , int dest , int weight){
            this.src = src;
            this.dest = dest;
            this.wt = weight;
        }
    }


    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0 ; i<graph.length ; i++){
            graph[i] = new ArrayList<>(); //null --> Empty
        }

        //0 --> vertex
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        //1 --> vertex
        graph[1].add(new Edge(1 , 0 , 1));
        graph[1].add(new Edge(1 ,3 ,  1));


        //2 vertex
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2 ,4,1));

        //3 vertex
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        //4 vertex
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        //5 vertex
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));


        //6 vertex
        graph[6].add(new Edge(6,5,1));

    }


    //bfs Traversal
    // public static void bfs(ArrayList<Edge> graph[]){
    //     Queue<Integer> q = new LinkedList<>();
    //     boolean vis[] = new boolean[graph.length];

    //     q.add(0);

    //     while (!q.isEmpty()) {
    //         int curr = q.remove();
    //         if(!vis[curr]){
    //             System.out.print(curr + " ");
    //             vis[curr] = true;

    //             //add all neighbour of src in queue
    //             for(int i=0 ; i<graph[curr].size(); i++){
    //                 Edge e = graph[curr].get(i);
    //                 q.add(e.dest);
    //             }
    //         }
    //     }
    // }
    


    //BFS traversal for connected components
    public static void bfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0 ; i<graph.length ; i++){
            if(!vis[i]){
                bfsUtil(graph , vis);
            }
        }
    }
    public static void bfsUtil(ArrayList<Edge> graph[] , boolean vis[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(0); //start source 0

        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr + " ");
                vis[curr] = true;

                //add all neighbour of src in queue
                for(int i=0 ; i<graph[curr].size() ; i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }



    //dfs traversal
    // public static void dfs(ArrayList<Edge> graph[] , int curr , boolean vis[]){
    //     System.out.print(curr +  " ");
    //     vis[curr] = true;

    //     for(int i=0 ; i<graph[curr].size(); i++){
    //         Edge e = graph[curr].get(i);
    //         if(!vis[e.dest]){
    //             dfs(graph , e.dest , vis);
    //         }
    //     }
    // }



    //DFS traversal for connected graphs
    public static void dfs(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        for(int i=0 ; i<graph.length ; i++){
            if(!vis[i]) dfsUtil(graph , i , vis);
        }
    }

    public static void dfsUtil(ArrayList<Edge> graph[] ,int curr , boolean vis[]){
        System.out.print(curr + " ");
        vis[curr] = true;

        for(int i=0 ; i<graph[curr].size() ; i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph , e.dest , vis);
            }
        }
    }
    public static void main(String[] args) {


        //         1 ------- 3
        //       /           | \
        //     /             |   \
        //    0              |    5 --- 6
        //     \             |   /
        //       \           | /
        //         2 ------- 4


        int V=7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.err.print("BFS traversal ");
        bfs(graph);

        System.out.println();


        System.out.print("DFS traversal ");
        dfs(graph);
    }
}
