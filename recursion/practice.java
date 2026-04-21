public class practice {
    public static void returnIndices(int[] n, int key , int i){
        if(i == n.length){
            return;
        }

        if(n[i] == key){
            System.out.print(i+ " ");
        }

        returnIndices(n, key, i+1);
    }

    static String digits[] = {"zero" , "one" , "two" , "three" , "four" , "five" , "six" , "seven" , "eight" , "nine"};
    public static void printNumber(int n){
        if(n==0){
            return;
        }

        int lastDigit = n%10;
        printNumber(n/10);
        System.out.print(digits[lastDigit] + " ");
    }


    public static void main(String[] args) {
        int arr[] = {3, 2, 4, 5, 6, 2, 7, 2, 2};
        int key = 2;
        returnIndices(arr, key, 0);


        System.out.println();

        printNumber(130);
    }
}
