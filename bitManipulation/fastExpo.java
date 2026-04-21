public class fastExpo {

    public static long fastExpo(int n , int i){ //in logn TC
        int a = n;
        long ans = 1;
        while ( i > 0) {
            if((i&1) == 1){//check LSB
                ans = ans * a;
            }

            a = a*a;
            i =  i>>1;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(fastExpo(3, 5));
        System.out.println(fastExpo(5, 5));
        System.out.println(fastExpo(8, 9));
    }
}
