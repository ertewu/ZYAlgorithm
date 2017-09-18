package zystudio.leecode;

import zystudio.bean.TreeNode;

import java.util.ArrayList;

/**
 * Created by leeco on 2017/7/1.
 */
public class MaximumDepthOfBinaryTree {

    public static void showDemo() {

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

//        int maxDepth = maxDepth(root);
        int maxDepth = maxDepthWithBFS(root);

        System.out.println("maxDepth is:" + maxDepth);

    }

    //层次遍历求最大深度
    private static int maxDepthWithBFS(TreeNode root) {

        ArrayList<TreeNode> levelNodes = new ArrayList<>();
        levelNodes.add(root);
        //如果想是1的话,那在底下maxDeepth++时,就得判断 levelNodes不为空才++; 这些边界果然是我不擅长的
        int maxDeepth = 0;

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
            maxDeepth++;
        }
        return maxDeepth;
    }

    //第二种方法,自己写个递归, accept,即使如此,也只达到 15.9%的 submission, 还是好差
    public static int maxDepth(TreeNode root) {

        int leftDepth = (root.left == null ? 0 : maxDepth(root.left));
        int rightDepth = (root.right == null ? 0 : maxDepth(root.right));

        int maxDepth = (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
        return maxDepth;
    }


    //做是做出来了,3.9%的 submission. 是不是有点可耻了..
    public static int maxDepth1(TreeNode root) {

        if (root == null) {
            return 0;
        }
        ArrayList<TreeNode> trasversalLists = new ArrayList<TreeNode>();
        trasversalLists.add(root);

        int maxLength = 1;
        int curDepth = 1;

        TreeNode curNode = root;
        TreeNode lastBackTrackNode = null;

        boolean isBackTrack = false;

        while (curNode != null) {

            if (!isBackTrack) {
                if (curNode.left != null) {
                    trasversalLists.add(curNode.left);
                    curNode = curNode.left;
                    curDepth++;
                } else if (curNode.right != null) {
                    trasversalLists.add(curNode.right);
                    curNode = curNode.right;
                    curDepth++;
                } else {
                    lastBackTrackNode = curNode;
                    trasversalLists.remove(trasversalLists.size() - 1);
                    if (trasversalLists.size() == 0) {
                        break;
                    } else {
                        curNode = trasversalLists.get(trasversalLists.size() - 1);
                        curDepth--;
                        isBackTrack = true;
                    }
                }
            } else {
                //如果是回溯的话,你并不知道下一个点会是哪个,有可能是右边的,也有可能是上边的.
                // 当前这个说左右都存在,就要看右边的这个判断,是有问题的,因为它有可能右边也走过了
                // 所以说,难到我再加一个lastNode 变量?
                if (curNode.left != null && curNode.right != null && lastBackTrackNode == curNode.left) {
                    trasversalLists.add(curNode.right);
                    curNode = curNode.right;
                    curDepth++;
                    isBackTrack = false;
                } else if (curNode == root) {
                    break;
                } else {
                    lastBackTrackNode = curNode;
                    trasversalLists.remove(trasversalLists.size() - 1);
                    curNode = trasversalLists.get(trasversalLists.size() - 1);
                    curDepth--;
                    isBackTrack = true;
                }
            }
            maxLength = maxLength > curDepth ? maxLength : curDepth;
        }
        return maxLength;
    }
}
