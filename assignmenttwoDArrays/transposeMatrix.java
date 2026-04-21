

public class transposeMatrix {

    public static int[][] transposedMatrix(int arr[][]){
        int transpose[][] = new int[arr[0].length][arr.length];

        for(int i=0; i<arr.length ; i++){
            for(int j=0; j<arr[0].length ; j++){
                transpose[j][i] = arr[i][j];
            }
        }
        return transpose;
    }

    public static void printArr(int arr[][]){
        for(int i=0; i<arr.length ; i++){
            for(int j=0; j<arr[0].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        int arr[][]={{1,2,3},{4,5,6}};
         
        //display original matrix 
        System.out.println("original array ");
        printArr(arr);

        //display transpose matrix
        int[][] transpose = transposedMatrix(arr);
        System.out.println("transposed array ");
        printArr(transpose);
    }
    
}