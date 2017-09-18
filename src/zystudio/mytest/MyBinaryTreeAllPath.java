package zystudio.mytest;

import zystudio.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leeco on 2017/7/27.
 */
public class MyBinaryTreeAllPath {

    private ArrayList<TreeNode> mPath = new ArrayList<>();

    public void showDemo() {
        TreeNode root = new TreeNode(1);

        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        root.left = node11;
        root.right = node12;


        TreeNode node121 = new TreeNode(121);
        TreeNode node122 = new TreeNode(122);
        node12.left = node121;
        node12.right = node122;

        TreeNode node1211 = new TreeNode(1211);

        node121.right = node1211;

        traversalTree(root);
    }


    public void traversalTree(TreeNode root) {
        mPath.add(root);

        if (root.left != null) {
            traversalTree(root.left);
        }

        if (root.right != null) {
            traversalTree(root.right);
        }

        if (root.left == null && root.right == null) {
            printPath(mPath);
            mPath.remove(mPath.size() - 1);
        }
    }

    private void printPath(List<TreeNode> path) {
        for (TreeNode item : path) {
            System.out.print(" " + item.val);
        }
        System.out.println(" end!");
    }
}
