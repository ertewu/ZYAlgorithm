package zystudio.mytest;

import zystudio.Utils;

/**
 * Created by leeco on 2017/7/23.
 */
public class MyHeapSort {

    public void showDemo() {
        int[] list = new int[]{2, 8, 7, 1, 3, 5, 6, 4};
        buildHeap(list);
        Utils.printList(list);
    }

    private void buildHeap(int[] list) {

        int firstNotLeafNodeIndex = list.length / 2;

        for (int i = firstNotLeafNodeIndex; i >= 0; i--) {
            buildHeap(list, i);
        }
    }

    private void buildHeap(int[] list, int index) {

        int leftNode = 2 * index + 1;
        int rightNode = 2 * index + 2;

        int smallestIndex = index;
        if (leftNode < list.length && list[leftNode] < list[index]) {
            smallestIndex = leftNode;
        }
        if (rightNode < list.length && list[rightNode] < list[smallestIndex]) {
            smallestIndex = rightNode;
        }
        if (smallestIndex != index) {
            int tmp = list[index];
            list[index] = list[smallestIndex];
            list[smallestIndex] = tmp;

            buildHeap(list, smallestIndex);
        }
    }


}
