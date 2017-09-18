package zystudio.datastructure;

import zystudio.Utils;

/**
 * Created by leeco on 2017/7/26.
 */
public class InsertSort {

    public void showDemo() {
//        int[] list = new int[]{5, 4, 3, 1};
        int[] list=new int[]{};
//        int[] list=new int[]{5};
        Utils.printList(insertSort(list));
    }

    public int[] insertSort(int[] list) {

        for (int i = 1; i < list.length; i++) {

            int valueToInsert = list[i];
            int posToInsert = -1;

            //这里的边界要考虑好
            for (int j = i; j > 0; j--) {
                if (list[j - 1] > valueToInsert) {
                    list[j] = list[j - 1];
                    posToInsert = j - 1;
                }
            }
            if (posToInsert >= 0) {
                list[posToInsert] = valueToInsert;
            }

        }
        return list;
    }
}
