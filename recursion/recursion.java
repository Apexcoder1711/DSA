

public class recursion {


    //recursion for decreasing number
    public static void printDec(int n){
        if(n==1){
            System.out.print(n);
            return;
        }

        System.out.print(n + " ");
        printDec(n-1);
    }

    //recursion for increasing number
    public static void printInc(int n){
        if(n == 1){
            System.out.print(n + " ");
            return;
        }

        printInc(n-1);
        System.out.print(n + " ");
    }


    //recursion for factorial 
    public static int factorial(int n){

        if(n==0){
            return 1;
        }

        int fnm1 = factorial(n-1);
        int fn = n * fnm1;
        
        return fn;
    }


    //recursion for sum of n natural numbers
    public static int calcSum(int n){
        if(n==1) return 1;

        int Smn1 = calcSum(n-1);
        int sum = n + Smn1;
        return sum;
    }


    //recursion for fibonacci series
    public static int fib(int n){
        if (n == 0) return 0;
        if(n==1) return 1;

        int fib1 = fib(n-1);
        int fib2 = fib(n-2);
        int ans = fib1 + fib2;

        return ans;
    } 



    //given array is sorted or not
    public static boolean isSorted(int arr[] , int i){
        if (i == arr.length -1) return true;
        if (arr[i] > arr[i+1]){
            return false;
        }

        return isSorted(arr, i+1);
    }



    //first occurrence of element in array
    public static int firstOccurence(int arr[] , int key , int i){
        if(i == arr.length) return -1;
        if (arr[i] == key) return i;
        return firstOccurence(arr, key, i+1);
    }


    //last occurence of element in array
    public static int lastOccurence(int arr[] , int key , int i){
        if(i == arr.length ) return -1;
        //look forward then compare with self
        int isFound = lastOccurence(arr, key, i+1);

        //compare with self
        if(isFound == -1 && arr[i] == key){
            return i;
        }

        return isFound;
    }
    public static void main(String[] args) {
        printDec(7);
        System.out.println();


        printInc(6);
        System.out.println();

        
        System.out.println(factorial(5)); 
        System.out.println();


        System.out.println(calcSum(5));
        System.out.println();


        System.out.println(fib(5));
        System.out.println();
        
        int arr[] = {1,2,4,5,};
        int arr2[] = {1,2,4,3};
        System.out.println(isSorted(arr, 0));
        System.out.println(isSorted(arr2, 0));

        int arr3[] = {1,2,3,4,53,24,2,3};
        System.out.println(firstOccurence(arr3, 3, 0));
        System.out.println(lastOccurence(arr3, 3, 0));
    }
}
