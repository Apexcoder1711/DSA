import java.util.ArrayList;
import java.util.Collections;

public class kruskal {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src , int dest , int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge> edges){
        //edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    static int n = 4;//no. of vertices
    static int par[] = new int[n];
    static int weight[] = new int[n];

    public static void init(){
        for(int i=0 ; i<n; i++){
            par[i] = i;
            weight[i] = 1;
        }
    }

    public static int find(int x){
        if(par[x] == x){
            return x;
        }
        return par[x] = find(par[x]); // path compression
    }

    public static void union(int x , int y){
        int parA = find(x);
        int parB = find(y);

        if(parA == parB) return ;
        else if(weight[parA] >= weight[parB]){
            weight[parA] += weight[parB];
            par[y] = parA;
        }
        else{
            weight[parB] += weight[parA];
            par[x] = parB;
        }
    }

    public static void kruskalMST(ArrayList<Edge> edges , int V){
        init();
        Collections.sort(edges , (e1 , e2)-> e1.wt - e2.wt); //O(ElogE)
        int mstCost = 0 ; 
        int count = 0 ;

        for(int i=0 ; count< V-1 ; i++){//O(V)
            Edge e = edges.get(i);
            //(src , dest ,wt)

            int parA = find(e.src); // src = a;
            int parB = find(e.dest);// dest = b

            if(parA != parB){
                union(e.src , e.dest);
                mstCost += e.wt;
                count++;
            }
        }

        System.out.println(mstCost);
    }
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskalMST(edges, V);
    }
}
