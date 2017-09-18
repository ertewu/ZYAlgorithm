package zystudio.datastructure;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void showDemo() {
        work();
    }

    private static void work() {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 50};
        bubbleSort(a);
        for (int i : a)
            System.out.print(i + " ");
    }

    private static int[] bubbleSort(int[] list) {

        for (int i = 0; i < list.length - 1; i++) {
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
