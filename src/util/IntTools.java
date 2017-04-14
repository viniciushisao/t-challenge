package util;

import java.util.ArrayList;

/**
 * Created by viniciushisao on 21/03/2017.
 */
public class IntTools {

    public static boolean isIdentical(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] getArray(ArrayList<Integer> integers){

        int[] ret = new int[integers.size()];

        int index = 0;
        for (int i : integers){
            ret[index++] = i;
        }
        return ret;

    }

}
