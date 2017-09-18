package zystudio.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leeco on 2017/6/27.
 */
public class TwoSum {

    public static void showDemo() {

        System.out.println("Hello World!");
        int[] nums = new int[]{1, 2, 3, 19, 18, 21, -1, 100, -9};
        int target = 20;
//        int[] result = TwoSum.twoSum(nums, target);
        int[] result = TwoSum.twoSum3(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] twoSum3(int[] nums, int target) {
        /*
         * 让我来想想除了普通冒泡之外,有哪些可以精进的方法
         * 1. 重复元素,但是这不足以 变成o(n)
         * 2. 怎么样变为 o(n) 呢,所以排序可能是可以的.因为排序之后 会少很多没用的判断
         *    排序的话,有没o(n)的呢
         * 3. 传说中的 hashmap的方案,会是怎么样呢.再想想
         *    啊已经看答案了,自己再默背着实现一下吧
         */
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int v1 = nums[i];
            int pendValue = target - v1;

            if (!map.containsKey(pendValue)) {
                map.put(v1, i);
            } else {
                result.add(i);
                result.add(map.get(pendValue));
            }
        }
        int[] resultList = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultList[i] = result.get(i);
        }
        return resultList;
    }

    public static int[] twoSum(int[] nums, int target) {
        ArrayList<Integer> listResult = new ArrayList<>();
        int len = nums.length;

        for (int i = 0; i < nums.length; i++) {
            int v1 = nums[i];
            for (int k = i + 1; k < nums.length; k++) {
                int v2 = nums[k];

                if ((v1 + v2) == target) {
                    listResult.add(i);
                    listResult.add(k);
                }
            }
        }
        int[] result = new int[listResult.size()];
        for (int i = 0; i < listResult.size(); i++) {
            result[i] = listResult.get(i);
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        int[] result = new int[]{};

        for (int i = 0; i < nums.length; i++) {
            int v1 = nums[i];
            for (int k = i + 1; k < nums.length; k++) {
                int v2 = nums[k];

                if ((v1 + v2) == target) {
                    int[] tmp = new int[(result.length + 2)];
                    System.arraycopy(result, 0, tmp, 0, result.length);
                    tmp[result.length] = i;
                    tmp[result.length + 1] = k;
                    result = tmp;
                }
            }
        }
        return result;
    }
}