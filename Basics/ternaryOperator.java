public class ternaryOperator {
    public static void main(String[] args) {
        int number = 5;

        //ternary operator

        String type = ((number%2)==0)?"even":"odd";
        System.out.println(type);

        //pass or fail
        int marks = 45;
        String result = (marks>=33)?"pass" : " fail ";
        System.out.println(result);
    }
}
