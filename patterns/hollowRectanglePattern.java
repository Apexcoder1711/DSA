package patterns;

public class hollowRectanglePattern {

    public static void hollowRectangle(int totalRows , int totalCols){
        for(int row=1; row<=totalRows; row++){
            for(int col=1; col<=totalCols; col++){
                if(row==1||row==totalRows||col==1||col==totalCols){
                    System.out.print("*" );
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        hollowRectangle(4, 05);
    }
}
