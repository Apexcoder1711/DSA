

public class DisjointSetUnion {
    static int n = 7;
    static int parent[] = new int[n];
    static int weight[] = new int[n];

    public static void init(){
        for(int i=0 ; i<n ; i++){
            parent[i] = i;
        }

        for(int i=0 ; i<n ;i++){
            weight[i] = 1;
        }
    }

    public static int find(int idx){
        if(parent[idx] == idx) return idx;
        return parent[idx] = find(parent[idx]); //path compression
    }


    public static void union(int a , int b){
        int pa = find(a);
        int pb = find(b);

        if(pa == pb) return;

        if(weight[pa] >= weight[pb]){
            weight[pa] += weight[pb];
            parent[pb] = pa;
        }
        else if(weight[pb] > weight[pa]){
            weight[pb] += weight[pa];
            parent[pa] = pb;
        }
    }


    public static void main(String[] args) {
        init();
        System.out.println(find(3));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
}
