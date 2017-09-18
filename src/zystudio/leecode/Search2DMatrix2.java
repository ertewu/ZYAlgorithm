package zystudio.leecode;

/**
 * Created by wzy on 8/2/17.
 * Ｌeetcode 240题　Ｓearch A 2D Matrix ２
 */
public class Search2DMatrix2 {


    private static int[][] sMatrix = new int[][]{
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
    };

    public void showDemo() {
        int[] result = searchMatrix(sMatrix, 21);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
//        searchMatrix(matrix,14);
    }

    //返回这个target的坐标
    public int[] searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }

        final int ROW_MAX_LENGTH = matrix.length;

        int i = 0;
        int j = matrix[0].length - 1;

        while (i < ROW_MAX_LENGTH && j >= 0) {

            int value = matrix[i][j];
            if (value == target) {
                return new int[]{i, j};
            } else if (value < target) {
                i++;
            } else if (value > target) {
                j--;
            }
        }
        return new int[]{-1, -1};
    }

}
