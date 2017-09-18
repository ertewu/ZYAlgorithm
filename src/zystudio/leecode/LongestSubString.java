package zystudio.leecode;

import java.util.HashMap;

/**
 * Created by leeco on 2017/6/28.
 */
public class LongestSubString {

    public static void showDemo() {
//        String test1 = "pwwkew";
//        String test1 = "pwwkewp";
        String test1 = "qwnfenpglqdq";
//        String test1 = "abcabcbb";
//        String test1="b";
//        String test1 = "";
        int value = lengthOfLongestSubstring(test1);
        System.out.println("maxLength subString:" + value);
    }

    public static int lengthOfLongestSubstring(String str) {

        HashMap<Character, Integer> map = new HashMap<>();
        char[] charList = str.toCharArray();

        int curStrStartIndex = 0;
        int maxLength = 0;

        for (int i = 0; i < charList.length; i++) {
            char key = charList[i];

            if (map.containsKey(key)) {
                int duplicateIndex = map.get(key);
                if (duplicateIndex >= curStrStartIndex) {
                    curStrStartIndex = map.get(key) + 1;
                }
            }
            map.put(key, i);
            int curSubStrLength = i - curStrStartIndex + 1;
            maxLength = maxLength > curSubStrLength ? maxLength : curSubStrLength;
        }

        return maxLength;
    }

    //这个倒是通过了,但是只比5%的提交好一点,也不说啥了,再想想其它方案
    public static int lengthOfLongestSubstring1(String str) {

        if (str.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        int tmp = 0;
        char[] charList = str.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < charList.length; i++) {

            map = new HashMap<>();
            map.put(charList[i], charList[i]);
            for (int k = i + 1; k < charList.length; k++) {
                if (map.containsKey(charList[k])) {
                    tmp = k - i;
                    maxLength = maxLength > tmp ? maxLength : tmp;
                    break;
                } else {
                    map.put(charList[k], charList[k]);
                }

                if (k == charList.length - 1) {
                    tmp = charList.length - i;
                    maxLength = maxLength > tmp ? maxLength : tmp;
                    break;
                }
            }
        }
        return maxLength;
    }
}
