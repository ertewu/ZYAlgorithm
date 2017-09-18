package zystudio.mytopic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by leeco on 2017/7/13.
 * 整数分解问题, Apus的面试题
 */
public class IntegerSeparate {


    private static class Composition extends ArrayList<Integer> {
        @Override
        public boolean equals(Object other) {
            Composition comp = (Composition) other;
            Collections.sort(this);
            Collections.sort(comp);
            if (this.isEmpty() || comp.isEmpty() || this.size() != comp.size())
                return false;
            for (int i = 0; i < this.size(); i++)
                if (this.get(i) != comp.get(i))
                    return false;
            return true;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }

    public static void showDemo() {
        work();
    }

    private static void work() {
        toStr(calc(7));
    }

    public static Set<Composition> calc(int n) {
        Set<Composition> possibility = new HashSet<Composition>();
        Composition composition = new Composition();
        switch (n) {
            case 1:
                composition.add(1);
                possibility.add(composition);
                return possibility;
            case 2:
                composition.add(1);
                composition.add(1);
                possibility.add(composition);
                return possibility;
            default:
                for (int i = 1; i <= n / 2; i++) {
                    composition = new Composition();
                    composition.add(i);
                    composition.add(n - i);
                    possibility.add(composition);
                    if (i <= n - i) {
                        //就是这步, 这一步最绕了, 主要我就是没想好,怎么用数据结构来包装这个结果
                        Set<Composition> partial_pos = calc(n - i);
                        for (Composition pos : partial_pos) {
                            pos.add(i);
                            possibility.add(pos);
                        }
                    }
                }
                return possibility;
        }

    }

    public static String toStr(Set<Composition> possibility) {
        String str = "total : " + possibility.size() + "\n";
        for (Composition pos : possibility)
            str += toStr(pos);

        System.out.println(str);
        return str;
    }

    public static String toStr(Composition composition) {
        String str = composition.get(0) + "";
        for (int i = 1; i < composition.size(); i++)
            str += (" + " + composition.get(i));
        str += "\n";
        return str;
    }

}
