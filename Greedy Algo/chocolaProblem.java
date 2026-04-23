import java.util.Arrays;
import java.util.Collections;

public class chocolaProblem {
    public static void main(String[] args) {
        int n = 4; // no. of rows
        int m = 6; // no. of columns

        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int cost = 0;
        int h = 0;
        int v = 0;
        int horipieces = 1;
        int vertipieces = 1;

        while (v < costVer.length && h < costHor.length) {
            if (costHor[h] >= costVer[v]) {// hori cut
                cost += (vertipieces * costHor[h]);
                h++;
                horipieces++;
            } else {
                cost += (horipieces * costVer[v]);
                v++;
                vertipieces++;
            }
        }

        while (h < costHor.length) {
            cost += (vertipieces * costHor[h]);
            h++;
            horipieces++;
        }

        while (v < costVer.length) {
            cost += (horipieces * costVer[v]);
            v++;
            vertipieces++;
        }


        System.out.println("Min cost to cut : " + cost);
    }
}
