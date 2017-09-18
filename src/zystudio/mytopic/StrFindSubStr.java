package zystudio.mytopic;

import zystudio.Utils;

/**
 * Created by leeco on 2017/7/26.
 * 看 String 类的 indexof (String, int)的源码, 可能是最官方的了.
 * 其实吧,与自己写的,也是一个思路
 */
public class StrFindSubStr {

    public void showDemo() {
        String text = "abcdefghij";
//        String targetText = "def";
//        String targetText = "abc";
//        String targetText = "ij";
//        String targetText = "a";
        String targetText = "j";


        int i = myIndexOf(text, targetText);
        System.out.println("StrFindSubStr :" + i);
    }



    //我自己写的方法
    private int myIndexOf(String text, String subtext) {

        if (text == null || text.length() == 0) {
            return -1;
        }
        if (subtext == null || subtext.length() == 0) {
            return -1;
        }
        char[] charList = text.toCharArray();
        char[] targetList = subtext.toCharArray();

        char firstChar = targetList[0];

        int matchIndex = -1;
        for (int i = 0; i < charList.length; i++) {
            if (firstChar == charList[i]) {
                matchIndex = i;

                //不加这个的时候,一个字母的target,这算法都返回-1,擦
                if(targetList.length==1){
                    return matchIndex;
                }

                for (int j = 1; j < targetList.length; j++) {

                    char srcChar = charList[i + j];
                    char targetChar = targetList[j];

                    if (srcChar != targetChar) {
                        matchIndex = -1;
                        break;
                    }
                    if (j == (targetList.length - 1)) {
                        return matchIndex;
                    }
                }
            }
        }

        return -1;
    }
}
