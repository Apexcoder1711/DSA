
import java.util.*;
public class shortestPath {

    public static float getShortestPath(String path){
        int x = 0 , y = 0 ;

        for(int i = 0 ; i < path.length() ; i++){
            if(path.charAt(i) == 'N'){
                y++;
            }
            else if(path.charAt(i) == 'S'){
                y--;
            }
            else if(path.charAt(i) == 'E'){
                x++;
            }
            else{
                x--;
            }
        }

        int value = (x*x) + (y*y) ;

        float shortestPath = (float)Math.sqrt(value);
        return shortestPath;

    }
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(getShortestPath(path));
    }
}
