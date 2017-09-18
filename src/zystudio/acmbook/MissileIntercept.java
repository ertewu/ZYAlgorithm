package zystudio.acmbook;

import java.util.ArrayList;

/**
 * Created by leeco on 2017/7/2.
 */
public class MissileIntercept {

    public static void showDemo() {
//        int[] missileArray = new int[]{
//                389, 207, 155, 300, 299, 170, 158, 65
//        };

        int[] missileArray = new int[]{389, 207, 155, 300, 299, 170, 158, 65};
        int maxLength = maxInterceptValue(missileArray);
        System.out.println("maxLength is:" + maxLength);
    }

    public static int maxInterceptValue(int[] missileArray) {

        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(missileArray[0]);

        int maxLength = 1;

        for (int i = 1; i < missileArray.length; i++) {

            int j = maxLength - 1;
            while (j >= 0) {
                if (missileArray[i] <= path.get(j)) {
                    break;
                }
                j--;
            }
            path.add(j + 1, missileArray[i]);
            if (j == maxLength - 1) {
                maxLength++;
            }
        }
        return maxLength;
    }
}
