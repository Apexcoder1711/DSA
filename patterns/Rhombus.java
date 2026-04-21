package patterns;

public class Rhombus {
    public static void solidRhombus(int n){
        for(int i=1;i<=n; i++){
            //spaces
            for(int j=1;j<=(n-i); j++){
                System.out.print(" ");
            }

            //stars
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }

            System.out.println();
        }
    }


    public static void hollowRhombus(int n){
        for(int i=1; i<=n; i++){
            //spaces
            for(int j=1;j<=n-i; j++){
                System.out.print(" ");
            }

            //hollow Rectangle

            for(int j=1;j<=n;j++){
                if (i==1||i==n||j==1||j==n) {
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
        //solidRhombus(6);
        hollowRhombus(7);
    }
}
