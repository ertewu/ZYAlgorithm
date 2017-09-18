package zystudio.mytopic;

/**
 * Created by leeco on 2017/7/16.
 */
public class IntegerAddAdd {

    public static void showDemo() {
        int result = computeNum(5);
        // 1  1  2  3  5  8   n=5,实际上是第6项
        System.out.println("IntegerAddAdd:" + result);
    }

    private static int computeNum(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        return computeNum(n - 1) + computeNum(n - 2);
    }
}
