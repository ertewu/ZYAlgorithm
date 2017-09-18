package zystudio.mytest;

import zystudio.bean.TreeNode;

import javax.transaction.TransactionRequiredException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by leeco on 2017/7/23.
 */
public class MyBinaryTreeTraversal {

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

//        traversalRecursion(root);
//        traversalLoop(root);
        traversalLevel(root);
    }

    private void traversalRecursion(TreeNode root) {

        //递归深度遍历中的 先序遍历
        System.out.println(root.val + " ");
        if (root.left != null) {
            traversalRecursion(root.left);
        }
        if (root.right != null) {
            traversalRecursion(root.right);
        }
    }

    private void traversalLoop(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        //这个循环得特殊在于,其每加完子结点,就要pop一下,
        while (stack.size() > 0) {
            TreeNode curNode = stack.pop();
            System.out.println(curNode.val + " ");

            if (curNode.right != null) {
                stack.push(curNode.right);
            }

            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
    }

    private void traversalLevel(TreeNode root) {
        List<TreeNode> curLevel = new ArrayList<TreeNode>();
        curLevel.add(root);

        while (curLevel.size() > 0) {

            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for (TreeNode curNode : curLevel) {
                System.out.println(curNode.val + " ");

                if (curNode.left != null) {
                    nextLevel.add(curNode.left);
                }
                if (curNode.right != null) {
                    nextLevel.add(curNode.right);
                }
            }
            curLevel = nextLevel;
        }
    }

}
