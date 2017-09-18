package zystudio.mytopic;


import java.util.ArrayList;

/**
 * Created by leeco on 2017/7/23.
 */
public class MaxSubStringOfTwoStr {

    public void showDemo() {
        String str1 = "abcdefghij";
        String str2 = "34cdefgff";

//        String result = getMaxSubString1(str1, str2);
        String result = getMaxSubString(str1, str2);
        System.out.println("MaxSubStringOfTwoStr:" + result);
    }

    /**
     * http://blog.csdn.net/guangmingfupin/article/details/25539737
     * 这个多个变量for循环,也是用得够精致的
     */
    public String getMaxSubString(String s1, String s2) {

        String max = "", min = "";
        max = (s1.length() > s2.length()) ? s1 : s2;
        min = (max == s1) ? s2 : s1;
        for (int i = 0; i < min.length(); i++) {
            //这句话,终于貌似懂那么一刹那了 k!=min.length+1  确实是很好的条件,但是写 k< min.length 其实更好理解
            for (int j = 0, k = min.length() - i; k != min.length() + 1; j++, k++) {
                String temp = min.substring(j, k);
                System.out.println(" i  j  k :" + i + "|" + j + "|" + k + "|" + temp);
//                    System.out.println("temp--:"+temp);
                //其实这一步要是写的话,还可麻烦呢..
                if (max.contains(temp))
                    return temp;
            }
        }
        return "";
    }

    //这是我自己的写法,最终写出来了.我几乎用了一个小时,而且带debug .这样子白板可不行
    public String getMaxSubString1(String str1, String str2) {

        String shortStr = str1.length() > str2.length() ? str2 : str1;
        String longStr = str1.length() > str2.length() ? str1 : str2;

        char[] shortCharList = shortStr.toCharArray();
        char[] longCharList = longStr.toCharArray();

        ArrayList<Character> sameCharList = new ArrayList<>();
        for (int i = 0; i < shortCharList.length; i++) {

            char firstChar = shortCharList[i];

            ArrayList<Character> loopCharList = new ArrayList<>();

            int sameStartIndex = -1;

            for (int k = 0; k < longCharList.length; k++) {

                char curChar = longCharList[k];
                if (curChar == firstChar) {
                    loopCharList.clear();
                    loopCharList.add(curChar);
                    sameStartIndex = k;
                    continue;
                }

                if (sameStartIndex > 0) {

                    int offset = k - sameStartIndex;
                    int nextShortCharListIndex = i + offset;

                    if (nextShortCharListIndex < shortCharList.length - 1 && curChar == shortCharList[nextShortCharListIndex]) {
                        loopCharList.add(curChar);
                    } else {
                        printlnStr(loopCharList);
                        if (loopCharList.size() > 0 && (loopCharList.size() > sameCharList.size())) {
                            sameCharList = loopCharList;
                        }
                        sameStartIndex = -1;
                        i = i + offset;
                    }
                }

            }
        }
        return printlnStr(sameCharList);
    }

    private String printlnStr(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder();
        for (Character ch : list) {
            builder.append(ch);
        }
        System.out.println("printlnStr is:" + builder.toString());
        return builder.toString();
    }

}
