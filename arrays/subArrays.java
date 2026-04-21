

public class subArrays {
   public static void subArray(int arr[]){
        int totalSubarr = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length ; i++){
            for(int j=i; j<arr.length ; j++){

                sum=0;
                for(int k=i ; k<=j ; k++){
                    System.out.print(arr[k] + " ");
                    sum += arr[k];
                }
                System.out.println();
                totalSubarr++ ;
                System.out.println("subarray sum :" + sum);
                if(max < sum){
                    max = sum;
                }
                
            }
            System.out.println();
        }
        System.out.println("total subarray : " + totalSubarr);
        System.out.println("max sum :" + max);
   }
   
   public static void main(String[] args) {
    int arr[] = {1 , -2 , 3, 4, 5, 6};

    subArray(arr);
   }
}
