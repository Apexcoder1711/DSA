

public class floyds {
    public static void main(String[] args) {
        int n=5;

        for(int row=1; row<=n; row++){
            int val=row;
            for(int col =1 ; col<=n; col++){
                if ((row-col)>=0) {
                    System.out.print(val + " ");
                    // val++;
                }
            }
            System.out.println();
        }


        for(int row=1; row<=n; row++){
            int val=1;
            for(int col =1 ; col<=n; col++){
                if ((row-col)>=0) {
                    System.out.print(val + " ");
                    val++;
                }
            }
            System.out.println();
        }



        for(int row=1; row<=n; row++){
            int val=row;
            for(int col =1 ; col<=n; col++){
                if ((row-col)>=0) {
                    System.out.print(val + " ");
                    val++;
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();


        // int n=5;

        System.out.println("FLOYDS TRIANGLE \n");

        int val=1;
        for(int row=1; row<=n; row++){
            for(int col =1 ; col<=n; col++){
                if ((row-col)>=0) {
                    System.out.print(val + " ");
                    val++;
                }
            }
            System.out.println();
        }
    }
}
