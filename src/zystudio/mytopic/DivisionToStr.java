package zystudio.mytopic;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 今日头条 整数变余过程
 * 我用了 LinkedHashMap,　写完了，很不容易..好累..　回去查查有没更好的方法，不用 LinkedHashMap的
 * 我的典型例子是 17/35
 */
public class DivisionToStr {

    public void showDemo() {
        String result = divisionToStr(17, 35);
        System.out.println("DivisionToStr result:" + result);
    }

    private String divisionToStr(int a, int b) {

        //reminder 我指的是余数记录
        //result 我指的是每一位的结果
        LinkedHashMap<Integer, Integer> reminderWithResultMap = new LinkedHashMap<Integer, Integer>();
        int curReminder = -1;

        int result = a / b;
        curReminder = a % b;

        int loopStartIndex = -1;
        int loopEndIndex = -1;

        while (true) {
            if (reminderWithResultMap.containsKey(curReminder)) {

                //找ＬoopStartIndex
                Iterator iter = reminderWithResultMap.entrySet().iterator();
                int count = 0;
                while (iter.hasNext()) {
                    Map.Entry<Integer, Integer> entry = (Map.Entry) iter.next();
                    if (entry.getKey() == curReminder) {
                        loopStartIndex = count;
                    }
                    count++;
                }
                loopEndIndex = count - 1;

                break;

            } else {
                int dividEnd = curReminder * 10;
                int value = dividEnd / b;
                reminderWithResultMap.put(curReminder, value);
                curReminder = dividEnd % b;
            }
        }

        StringBuilder builder = new StringBuilder();

        builder.append(result).append(".");
        Iterator myIter = reminderWithResultMap.entrySet().iterator();
        int count = 0;
        while ((myIter.hasNext())) {
            Map.Entry<Integer, Integer> entry = (Map.Entry) myIter.next();
            if (count != loopStartIndex && count != loopEndIndex) {
                builder.append(entry.getValue());
            }
            if (count == loopStartIndex) {
                builder.append("(");
                builder.append(entry.getValue());
            }
            if (count == loopEndIndex) {
                builder.append(entry.getValue());
                builder.append(")");
                break;
            }
            count++;
        }

        return builder.toString();


//        Iterator iter = reminderWithResultMap.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry<Integer, Integer> entry = (Map.Entry) iter.next();
//            System.out.print(entry.getValue() + "|" + entry.getKey() + "\n");
//        }
//        return null;
    }


}
