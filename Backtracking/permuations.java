public class permuations {
    public static void permuation(String str , String ans){
        //base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        //recursion with backtracking
        for(int i=0; i<str.length() ; i++){
            char curr = str.charAt(i);
            //Remove i character by using substring 
            //"abcde" => "ab" + "ce" = "abce";
            String newStr = str.substring(0, i) + str.substring(i+1);
            permuation(newStr, ans+curr);
        } 
    }
    public static void main(String[] args) {
        permuation("abc", "");
    }
}
