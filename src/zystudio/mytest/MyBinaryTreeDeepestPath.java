package zystudio.mytest;

import zystudio.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by leeco on 2017/7/23.
 */
public class MyBinaryTreeDeepestPath {

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

//        deepFirstTrasversal(root);
        deepFirstTraversal2(root);
    }

    public List<TreeNode> getLeafNodes(TreeNode root) {

        List<TreeNode> childNodeList = new ArrayList<TreeNode>();
        childNodeList.add(root);

        for (TreeNode child : childNodeList) {
            List<TreeNode> tmpNodeList = new ArrayList<TreeNode>();
            if (child.left != null) {
                tmpNodeList.add(child);
            }
            if (child.right != null) {
                tmpNodeList.add(child);
            }
            if (tmpNodeList.size() == 0) {
                break;
            }
            childNodeList = tmpNodeList;
        }
        //childNodeList
        return childNodeList;
    }


    public void deepFirstTrasversal(TreeNode root) {

        if (root == null) {
            return;
        }
        System.out.println(" " + root.val);
        deepFirstTrasversal(root.left);
        deepFirstTrasversal(root.right);
    }

    public void deepFirstTraversal2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (stack.size() > 0) {
            TreeNode curNode = stack.pop();
            System.out.println("" + curNode.val);

            if (curNode.right != null) {
                stack.push(curNode.right);
            }

            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
    }

}
