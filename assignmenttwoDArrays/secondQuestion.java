

public class secondQuestion {
    public static int rowSum(int arr[][]){
        int sum=0;
        int row=1;
        for(int col=0; col<arr[0].length ; col++){
            if (row==1) {
                sum+=arr[row][col];
            }
        }
        System.out.println("sum is " + sum);
        return sum;
    }
    public static void main(String args[]){
        int arr[][]={{1,4,9},{11,4,3}, {2,2,3}};
        System.out.println(rowSum(arr));
    }

}
