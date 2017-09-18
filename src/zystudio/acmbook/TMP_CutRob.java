package zystudio.acmbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * https://segmentfault.com/a/1190000008730320
 * 算法导论中的DP例子钢锯问题
 * Created by wzy on 8/1/17.
 */
public class TMP_CutRob {

    private static int[] priceList = new int[]{1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    public void showDemo() {
//        int value = bestCut(4);
//        int value = bestCut(10);
//        int value = mem_cut_rod(4);
//        int value = bottom_up_cut_rod(4);

        int value = bestCut2(4);
        for (int i : record) {
            System.out.println("CutRobIndex:" + i);
        }
        System.out.println("CutRob:" + value);
    }

    Stack<Integer> record = new Stack<>();

    //怎么记录这个事，最终还是没搞出来，这里边的是错误的
    public int bestCut2(int src) {

        if (src == 0) {
            return 0;
        }

        int mid = src / 2;
        int maxValue = priceList[src - 1];

        for (int i = 1; i <= mid; i++) {

            int tmp = bestCut2(i) + bestCut2(src - i);
            if (tmp > maxValue) {
                maxValue = tmp;
                record.clear();
            }
        }

        if (maxValue == priceList[src - 1]) {
            record.add(src);
        }
        return maxValue;
    }


    //自底向上法,这个写得简单又nb,果然是但凡小于n的都算一下而且记着了
    public int bottom_up_cut_rod(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int j = 1; j <= n; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                max = Math.max(max, priceList[i - 1] + dp[j - 1]);
            }
            dp[j] = max;
        }
        return dp[n];
    }

    //自顶向下法
    public int mem_cut_rod(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int result = mem_cut_rod_aux(n, dp);

        //这东西是为了保存每个n的最大値的，为了节省重复运算
        for (int i = 0; i < dp.length; i++) {
            System.out.println("mem_cut_rod:" + dp[i]);
        }
        return result;
    }

    private int mem_cut_rod_aux(int n, int[] dp) {
        if (dp[n] >= 0) {
            return dp[n];
        }
        int max = Integer.MIN_VALUE;
        if (n == 0) {
            max = 0;
        } else {
            for (int i = 1; i <= n; i++) {
                max = Math.max(max, priceList[i - 1] + mem_cut_rod_aux(n - i, dp));
            }
        }
        dp[n] = max;
        return max;
    }


    //但是显示分支结果这个，我没有搞定，我花了挺多时间的，我决定看答案了
    public int solution(int length) {
        if (length == 0) {
            return 0;
        }
        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= length; i++) {
            //这儿还跟我的不太一样,貌似他这个是对的,比我得更省一些
            result = Math.max(result, priceList[i - 1] + solution(length - i));
        }
        return result;
    }


    //先找最大值，不返回分割结果,我自己写的
    public int bestCut(int src) {

        if (src == 0) {
            return 0;
        }

        int mid = src / 2;

        int maxValue = priceList[src - 1];

        for (int i = 1; i <= mid; i++) {

            int tmp = bestCut(i) + bestCut(src - i);
            if (tmp > maxValue) {
                maxValue = tmp;
            }
        }
        return maxValue;
    }


}
