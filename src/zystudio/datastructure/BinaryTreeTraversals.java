package zystudio.datastructure;

import zystudio.bean.TreeNode;

import java.util.*;

/**
 * http://dyygusi.iteye.com/blog/2162617
 */
public class BinaryTreeTraversals {


    public static void showDemo() {
        work();
    }

    private static void work() {
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

//        trasveralLoop1(root);
//        trasveralRecursion(root);

//        showReverseTree(root);
        trasveralBreadthFirst(root);
    }

    private static void showReverseTree(TreeNode node) {
        TreeNode reversed = reverseTreeRecurion(node);
        trasveralLoop1(reversed);
    }


    //这个循环得特殊在于,其每加完一个点的子结点,就是循环一次了, 下次就要pop一下;这简直就是个节奏
    private static void trasveralLoop1(TreeNode node) {

        //不用stack,用list加index 也可以,但原理是一样的,有list有size, 找最近压进去那个还不是容易的事么
        Stack<TreeNode> myStack = new Stack<TreeNode>();
        myStack.push(node);
        while (true) {
            if (myStack.size() == 0) {
                break;
            }
            TreeNode curNode = myStack.pop();
            System.out.println("node value:" + curNode.val);
            //前序遍历的话,就要先把右边压栈了
            if (curNode.right != null) {
                myStack.push(curNode.right);
            }
            if (curNode.left != null) {
                myStack.push(curNode.left);
            }
        }
    }

    //跟循环比,递归简直就是把栈用在系统上了
    private static void trasveralRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println("node value:" + node.val);
        trasveralRecursion(node.left);
        trasveralRecursion(node.right);
    }

    //层次遍历,直接写通, 而且这个计算深度确实是方便的
    private static void trasveralBreadthFirst(TreeNode root) {

        ArrayList<TreeNode> levelNodes = new ArrayList<>();
        levelNodes.add(root);

        while (levelNodes.size() > 0) {
            ArrayList<TreeNode> nextLevelNodes = new ArrayList<>();
            for (TreeNode item : levelNodes) {
                System.out.println("node value is:" + item.val);
                if (item.left != null) {
                    nextLevelNodes.add(item.left);
                }
                if (item.right != null) {
                    nextLevelNodes.add(item.right);
                }
            }
            levelNodes = nextLevelNodes;
        }
    }


    //反转二叉树,一个递归就可以搞定了
    private static TreeNode reverseTreeRecurion(TreeNode node) {

        if (node == null) {
            return null;
        }

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        reverseTreeRecurion(node.left);
        reverseTreeRecurion(node.right);

        return node;
    }


    //循环反转二叉树
    private static TreeNode reverseTreeLoop(TreeNode node) {
        return null;
    }

}
