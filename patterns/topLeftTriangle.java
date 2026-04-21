package patterns;

public class topLeftTriangle {

    public static void topLeftWithStars(int n){
        for(int row=1; row<=n;row++){
            for(int col=1; col<=n; col++){
                if (row+col<=(n+1)) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    public static void topLeftWithNumber(int N){
        
        for(int row=1; row<=N;row++){
            int i=1;
            for(int col=1; col<=N; col++){
                if (row+col<=(N+1)) {
                    System.out.print(i + " ");
                    i++;
                }
            }
            System.out.println();
        }
    }

    
    public static void main(String[] args) {
        topLeftWithStars(5);
        topLeftWithNumber(6);
    }       
}
