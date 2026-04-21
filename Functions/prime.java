package Functions;

public class prime {
    public static boolean isPrime(int n) {
        //corner cases
        if (n==2) {
            return true;
        }
       for(int i=2; i<=Math.sqrt(n);i++){
        if(n%i==0){
            return false;
        }
       }
       return true;
    }

    // public static void prime(int n){
    //     if(n==2){
    //         System.out.println("not prime");
    //     }
    //     else{
    //         for(int i = 2 ; i<=Math.sqrt(n); i++){
    //             if (n%i==0) {
    //                 System.out.println("not prime");
    //                 break;
    //             }
    //             else{
    //                 System.out.println("prime");
    //                 break;
    //             }            
    //         }
    //     }
    // }


    public static void primesInRange( int n){
        for(int i=2; i<=n;i++){
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(isPrime(2));
        // prime(9);
        primesInRange(100);

    }
}
