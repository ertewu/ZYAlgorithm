package zystudio.datastructure;

/**
 * Created by leeco on 2017/7/11.
 */
public class BinarySearch {

    public static void showDemo() {
        work();
    }

    private static void work() {

        //8个
        int[] list = {13, 27, 38, 49, 50, 65, 76, 97};
        //9个
//        int[] list = {13, 27, 38, 49, 50, 61, 65, 76, 97};

        int result = binarySearch(list, 13);
        System.out.print("binarySearch position:" + result);
    }

    private static int binarySearch(int[] list, int num) {
        return binSearchInternal(list, 0, list.length - 1, num);
    }

    //循环的
    private static int binSearchInternal(int[] list, int low, int high, int key) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list[mid] == key) {
                return mid;
            } else if (list[mid] > key) {
                high = mid - 1;
            } else if (list[mid] < key) {
                low = mid + 1;
            }
        }
        return -1;
    }

    //这个是网上找的比较简单的 递归实现方法,是我的这个改进方案了
    private static int binSearchInternal2(int[] list, int low, int high, int key) {

        final int mid = low + (low + high) / 2;

        if (low <= high) {

            if (list[mid] == key) {
                return mid;
            } else if (list[mid] > key) {
                return binSearchInternal(list, low, mid - 1, key);
            } else if (list[mid] < key) {
                return binSearchInternal(list, mid + 1, high, key);
            }
        }
        return -1;
    }

    //这是我自己实现的二分法,我的测试是差不多的,但是代码貌似没有很好看.我去找个别人的
    private static int binSearchInternal1(int[] list, int low, int high, int key) {

        int result = -1;

        final int mid = low + (low + high) / 2;

        if (mid == low) {
            //递归 边界条件
            if (list[mid] == key) {
                return mid;
            }
            return -1;
        } else {
            if (list[mid] == key) {
                return mid;
            } else if (list[mid] > key) {
                return binSearchInternal(list, low, mid, key);
            } else if (list[mid] < key) {
                return binSearchInternal(list, mid, high, key);
            }
        }

        return -1;
    }
}
