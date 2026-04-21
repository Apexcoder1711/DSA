package patterns;

public class bottomLeftTriangle {

    public static void zeroOneTriangle(int N){
        for(int row=1; row<=N ; row++){
            for(int col=1;col<=N; col++){
                if ((row-col)>=0) {
                    if ((row+col)%2==0) {
                        System.out.print(1); 
                    }
                    else{
                        System.out.print(0);
                    }
                    
                }
            }
            System.out.println();
        }
    }

    public static void bottomLeft(int n){
        for(int row=1; row<=n ; row++){
            for(int col=1;col<=n; col++){
                if ((row-col)>=0) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
       bottomLeft(5); 
       zeroOneTriangle(6);
    }
       
}
