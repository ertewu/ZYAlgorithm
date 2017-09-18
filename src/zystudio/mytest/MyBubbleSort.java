package zystudio.mytest;

import zystudio.Utils;

/**
 * Created by leeco on 2017/7/26.
 */
public class MyBubbleSort {

    public void showDemo() {
//        int[] list = new int[]{5, 4, 1, 3};
//        int[] list = new int[]{5 };
        int[] list = new int[]{};
        Utils.printList(bubbleSort(list));
    }

    public int[] bubbleSort(int[] list) {

        for (int i = 0; i < list.length; i++) {
            for (int j = list.length - 1; j > i; j--) {

                if (list[j] < list[j - 1]) {
                    int tmp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = tmp;
                }
            }
        }
        return list;
    }

}
