public class pattern {
    public static void main(String[] args) {
        for(int i= 1; i<=4; i++){
            for(int n= 1; n<=i; n++){
                System.out.print("*");
            }
            System.out.println();
        }


        System.out.println();
        System.out.println();

        //inverted star pattern

        int n=4;
        for(int i= 1; i<=n; i++){
            for(int j= 1; j<=n-i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }


        //Half pyramid pattern

        for(int i = 1; i<=4; i++){
            for(int j = 1; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }



        //character pattern

        char a='A';
        for(int i=1; i<=4;i++){
            for(int j=1; j<=i; j++){
                System.out.print(a);
                a++;
            }
            System.out.println();
        }


        // inverted triangle
        for(int i=4 ; i>=1; i--){
            for(int j=1; j<=i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
