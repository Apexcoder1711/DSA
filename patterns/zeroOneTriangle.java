

public class zeroOneTriangle {
    public static void zeroOneTriangle(int n){
        //outer loop
        for(int row=1; row<= n ; row++){
            //inner loop
            for(int col=1 ; col <= row ; col++){
                if((row+col)%2==0 ){
                    System.out.print("1");
                }
                if((row+col)%2 != 0){
                    System.out.print("0");
                }
                else{
                    System.out.print("");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        zeroOneTriangle(7);
    }
}
