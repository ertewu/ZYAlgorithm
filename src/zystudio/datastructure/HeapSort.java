package zystudio.datastructure;

/**
 * Created by leeco on 2017/7/22.
 */
public class HeapSort {


    public void showDemo() {
        int[] myList = {1, 2, 3, 4, 5, 6, 7};
        maxHeapBuild(myList);
    }


    private void maxHeapBuild(int[] list) {
        //k的开始,是第一个非叶子节点
        for (int k = list.length / 2 - 1; k >= 0; k--) {
            subHeapBuild(list, k);
        }
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    private void subHeapBuild(int[] list, int index) {

        int curRoot = index;
        int leftChild = curRoot * 2 + 1;
        int rightChild = curRoot * 2 + 2;

        if (curRoot >= list.length || isLeafNode(list, curRoot)) {
            return;
        }

        int maxValuePoint = curRoot;
        if (leftChild < list.length && list[maxValuePoint] < list[leftChild]) {
            maxValuePoint = leftChild;
        }
        if (rightChild < list.length && list[maxValuePoint] < list[rightChild]) {
            maxValuePoint = rightChild;
        }
        if (maxValuePoint != curRoot) {
            int tmpValue = list[curRoot];
            list[curRoot] = list[maxValuePoint];
            list[maxValuePoint] = tmpValue;
            subHeapBuild(list, maxValuePoint);
        }
    }

    private boolean isLeafNode(int[] list, int index) {
        int length = list.length;
        if (index > (length / 2)) {
            return true;
        }
        return false;
    }


    private int[] maxHeapSort(int[] list) {
        return null;
    }

}
