package patterns;

public class bottomRightCorner {

    public static void bottomRight(int n){
        for(int row = 1; row<=n; row++){
            for(int col = 1; col<=n; col++){
                if (row+col>=n+1) {
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
       bottomRight(8);
}
}
