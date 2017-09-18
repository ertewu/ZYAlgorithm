package zystudio.bean;

/**
 * Created by leeco on 2017/7/1.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static boolean isNullNode(TreeNode node) {
        return node == null;
    }
}
