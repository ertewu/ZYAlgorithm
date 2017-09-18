package zystudio.datastructure;

/**
 * 快速排序
 * 这是我自己写的快速排序吧... 擦好滥啊没法看,我得找一个好的代码来看
 */
public class QuickSort {

    //    private static int[] arr = {49, 38, 65, 97, 76, 13, 27, 50};
//    private static int[] arr = {3, 5, 1, 2 };
    private static int[] arr = {5, 3};

    public static void showDemo() {
        work();
    }

    private static void work() {
        quickSort();
        for (int i : arr)
            System.out.print(i + " ");
    }

    private static void quickSort() {
        quick_sort_recursive(0, arr.length - 1);
    }


    private static void quick_sort_recursive(int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = arr[end];
        //上边选瞄点,可见还是有选择的
        int left = start, right = end - 1;
        while (left < right) {
            while (arr[left] <= mid && left < right) {
                left++;
            }
            while (arr[right] >= mid && left < right) {
                right--;
            }
            swap(left, right);
        }
        if (arr[left] >= arr[end]) {
            swap(left, end);
        } else {
            left++;
        }

        quick_sort_recursive(start, left - 1);
        quick_sort_recursive(left, end);
    }

    private static void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


}
