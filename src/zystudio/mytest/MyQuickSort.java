package zystudio.mytest;

import zystudio.Utils;

/**
 * Created by leeco on 2017/7/23.
 */
public class MyQuickSort {

    public void showDemo() {
//        int[] list = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        int[] list = new int[]{2,8};
//        int[] list = new int[]{2};
//        int[] list = new int[]{};
        quickSort(list);
        Utils.printList(list);
    }

    public void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    public void quickSort(int[] list, int start, int end) {

        if (start >= end) {
            return;
        }
        int anchor = end;
        int leftScan = start;
        int rightScan = end - 1;

        while (leftScan < rightScan) {

            if (list[leftScan] < list[anchor]) {
                leftScan++;
                continue;
            }

            if (list[rightScan] > list[anchor]) {
                rightScan--;
                continue;
            }

            int tmp = list[leftScan];
            list[leftScan] = list[rightScan];
            list[rightScan] = tmp;
        }

        int tmp = list[rightScan];
        list[rightScan] = list[anchor];
        list[anchor] = tmp;

        quickSort(list, start, rightScan - 1);
        quickSort(list, rightScan + 1, end);
    }

}
