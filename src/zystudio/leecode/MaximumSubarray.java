package zystudio.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 53 题
 */
public class MaximumSubarray {

    public static void showDemo() {
//        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

//        int[] nums = new int[]{1, 2, 4, 5, -10, 7, 6, 5};


        int[] nums = new int[]{1, -2, 4, 5};
        int result = maxSubArray(nums);
        System.out.println("result is:" + result);
    }

    public static int maxSubArray(int[] A) {
        if (A == null || A.length == 0)
            return 0;
        int global = A[0];
        int local = A[0];
        for (int i = 1; i < A.length; i++) {

            int tmp = local + A[i];
            //主要是这一步没太好理解
            local = Math.max(A[i], tmp);

            global = Math.max(local, global);
        }
        return global;
    }

}
