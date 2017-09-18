package zystudio.mytopic;

import zystudio.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leeco on 2017/7/26.
 */
public class BinaryTreeAllLeafPath {

    private List<TreeNode> path = new ArrayList<>();

    public void showDemo() {

//        TreeNode root = getTreeRoot1();
        TreeNode root = getTreeRoot2();
//        traversalRecursion(root);
        traversalWhileLoop(root);
    }

    private TreeNode getTreeRoot1() {
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

        return root;
    }

    //果然是错的呢
    private TreeNode getTreeRoot2() {
        TreeNode root = new TreeNode(1);

        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        root.left = node11;
        root.right = node12;

        TreeNode node111 = new TreeNode(111);
        TreeNode node112 = new TreeNode(112);
        node11.left = node111;
        node11.right = node112;

        TreeNode node1111 = new TreeNode(1111);
        node111.left = node1111;

        return root;
    }

    private void traversalWhileLoop(TreeNode root) {

        //也就是说明,stack这东西存的一直是没有被访问的点们,也有顺序,访问过的点,要立即从里边去掉的
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);

        //while之后,我想用for 试一试
        while (stack.size() > 0) {
            TreeNode curNode = stack.get(stack.size() - 1);
            //删除节点的地方在这儿,可不是底下判断的那个地方
            stack.remove(stack.size() - 1);
            path.add(curNode);


            if (curNode.right != null) {
                stack.add(curNode.right);
            }
            if (curNode.left != null) {
                stack.add(curNode.left);
            }

            if (curNode.left == null && curNode.right == null) {
                for (TreeNode node : path) {
                    System.out.print("  " + node.val);
                }
                System.out.println("--------Path end--------");
            }
        }

    }

    //这个循环打印路径的，其实也是错的
    private void traversalWhileLoopErr(TreeNode root) {

        //也就是说明,stack这东西存的一直是没有被访问的点们,也有顺序,访问过的点,要立即从里边去掉的
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);

        //while之后,我想用for 试一试
        while (stack.size() > 0) {
            TreeNode curNode = stack.get(stack.size() - 1);
            //删除节点的地方在这儿,可不是底下判断的那个地方
            stack.remove(stack.size() - 1);
            path.add(curNode);


            if (curNode.right != null) {
                stack.add(curNode.right);
            }
            if (curNode.left != null) {
                stack.add(curNode.left);
            }

            if (curNode.left == null && curNode.right == null) {
                for (TreeNode node : path) {
                    System.out.print("  " + node.val);
                }
                System.out.println("--------Path end--------");
            }
        }
    }

    //这个是对的，和底下我写那个错的比，很多不一样的，但都是必须的。比如把==null的判断提到前边来
    private void traversalRecursion(TreeNode root) {

        //递归深度遍历中的 先序遍历
        path.add(root);
        if (root.left == null && root.right == null) {
            for (TreeNode node : path) {
                System.out.print("  " + node.val);
            }
            System.out.println("--------Path end--------");
        }

        if (root.left != null) {
            traversalRecursion(root.left);
        }
        if (root.right != null) {
            traversalRecursion(root.right);
        }
        //打印树的所有路径，就是差这一步,这个点，实际上就是回溯点
        if (path.size() > 0) {
            path.remove(path.size() - 1);
        }

    }

    //这是我自己做出来的方法,但是是错的
    private void traversalRecursionErr(TreeNode root) {

        //递归深度遍历中的 先序遍历
        path.add(root);
        if (root.left != null) {
            traversalRecursion(root.left);
        }
        if (root.right != null) {
            traversalRecursion(root.right);
        }
        //打印树的所有路径，就是差这一步
        if (path.size() > 0) {
            path.remove(path.size() - 1);
        }

        if (root.left == null && root.right == null) {
            for (TreeNode node : path) {
                System.out.print("  " + node.val);
            }
            System.out.println("--------Path end--------");
            path.remove(path.size() - 1);
        }
    }

    //上边的方法貌似是错的，这个是对
    private void traversalRecursionRight(TreeNode root) {

        //递归深度遍历中的 先序遍历
        path.add(root);
        if (root.left != null) {
            traversalRecursion(root.left);
        }
        if (root.right != null) {
            traversalRecursion(root.right);
        }
        if (root.left == null && root.right == null) {
            for (TreeNode node : path) {
                System.out.print("  " + node.val);
            }
            System.out.println("--------Path end--------");
            path.remove(path.size() - 1);
        }
    }
}
