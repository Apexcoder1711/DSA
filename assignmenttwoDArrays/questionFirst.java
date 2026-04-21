

public class questionFirst {

    public static void printNo(int arr[][] , int key){

        if (arr.length==0||arr[0].length==0) {
            System.out.println("Array is empty ");
            return;
        }


        int count = 0;
        for(int i=0; i<arr.length ; i++){
            
            for(int j=0; j<arr[0].length; j++){
                if (arr[i][j]==key) {
                    count++;
                }
            }
        }
         
        System.out.println("The no of " + key + "=" + count);
    }
    public static void main(String[] args) {
        int arr[][] = {{4,7,8,}, {8,8,7}};
        int key = 9;
        printNo(arr, key);
    }
}
