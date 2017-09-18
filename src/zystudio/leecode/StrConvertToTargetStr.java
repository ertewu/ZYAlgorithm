package zystudio.leecode;

import zystudio.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 猿题库考我的题，但是是leetcode上的：
 * leetcode word ladder
 */
public class StrConvertToTargetStr {

    //    private static String[] channel = new String[]{"lit", "cit", "cig", "cfi", "cft"};
    private static String[] channel = new String[]{"lit", "cit", "cig"};
//    private static String[] channel = new String[]{"lit", "cit","cff"};
//    private static String[] channel = new String[]{"lit", "cit"};

    ArrayList<String> list = new ArrayList<String>();


    public void showDemo() {
        String src = "lot";
        String target = "cfg";
        Set<Integer> mySet = new HashSet<>();

//        boolean result = isCanMatchRecursion(src, target, mySet);
        boolean result = isCanMatchLoop(src, target);

        System.out.println("StrConvertToTarget result:" + result);
        for (String item : list) {
            System.out.println("StrConvertToTarget path:" + item);
        }
    }

    //这个没做出来，这个现在是错的
    private boolean isCanMatchLoop(String src, String target) {


        if (src != null && target != null && src.equals(target)) {
            return true;
        }

        if (src == null || target == null || src.length() != target.length()) {
            return false;
        }

        if (isOneStepMatch(src, target)) {
            return true;
        }

        String curSrc = src;

        Set<Integer> ignoreSet = new HashSet<>();

        for (int i = 0; i < channel.length; i++) {
            if (isOneStepMatch(curSrc, target)) {
                return true;
            }
            if (!ignoreSet.contains(i) && isOneStepMatch(curSrc, channel[i])) {
                ignoreSet.add(i);
                curSrc = channel[i];
                i = 0;
            }
        }
        return false;
    }


    //我还是喜欢用递归，而且还有时递归与循环纠缠，这个呆会就算作好了，也得换个别的作法
    private boolean isCanMatchRecursion(String src, String target, Set<Integer> ignore) {
        if (src != null && target != null && src.equals(target)) {
            return true;
        }
        if (isOneStepMatch(src, target)) {
            return true;
        }
        for (int i = 0; i < channel.length; i++) {
            if (!ignore.contains(i) && isOneStepMatch(channel[i], src)) {
                ignore.add(i);
                //在递归向上回溯时，记结果
                if (isCanMatchRecursion(channel[i], target, ignore)) {
                    list.add(channel[i]);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isOneStepMatch(String first, String second) {
        if (first != null && second != null) {

            if (first.length() != second.length()) {
                return false;
            }

            int notMatchCount = 0;
            char[] firstList = first.toCharArray();
            char[] secondList = second.toCharArray();

            for (int i = 0; i < first.length(); i++) {
                if (firstList[i] != secondList[i]) {
                    notMatchCount++;
                    if (notMatchCount > 1) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }

}
