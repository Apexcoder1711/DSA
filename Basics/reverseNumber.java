public class reverseNumber {
    public static void main(String[] args) {
        int n=10899;
        int reverse = 0;

        while (n>0) {
            int lastDigit = n%10;
            reverse = (reverse*10)+ lastDigit;
            n/=10;
        }
        System.out.println(reverse);
    }
}
