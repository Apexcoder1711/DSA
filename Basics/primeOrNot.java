import java.util.*;
public class primeOrNot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("please enter the number for check it s prime or not : ");
        int n = sc.nextInt();


        if(n==2){
            System.out.println("not prime");
        }
        else{
            for(int i = 2 ; i<Math.sqrt(n); i++){
                if (n%i==0) {
                    System.out.println("not prime");
                    break;
                }
                else{
                    System.out.println("prime");
                    break;
                }            
            }
        }
        
    }
}
