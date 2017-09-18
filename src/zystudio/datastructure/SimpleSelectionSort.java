package zystudio.datastructure;

/**
 *
 * http://www.cnblogs.com/jingmoxukong/p/4303289.html
 *
 */
public class SimpleSelectionSort {


    public static void showDemo() {
        work();
    }

    private static void work() {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 50};
        simpleSelectionSort(a);
        for (int i : a)
            System.out.print(i + " ");
    }

    private static void simpleSelectionSort(int[] list) {
        //简单选择排序

        // 要注意一点，当要排序 N 个数，已经经过 N-1 次遍历后，已经是有序数列
        for (int i = 0; i < list.length - 1; i++) {
            int temp = 0;
            int index = i; // 用来保存最小值得索引

            // 寻找第i个小的数值
            for (int j = i + 1; j < list.length; j++) {
                if (list[index] > list[j]) {
                    index = j;
                }
            }

            // 交换:将找到的第i个小的数值放在第i个位置上
            temp = list[index];
            list[index] = list[i];
            list[i] = temp;

//            System.out.format("第 %d 趟:\t", i + 1);
        }
    }
}
