package zystudio.datastructure;

import zystudio.Utils;
import zystudio.bean.LinkNode;

import java.util.Stack;

/**
 * Created by leeco on 2017/7/30.
 */
public class LinkListOperations {

    private LinkNode mSingleList;

    public void showDemo() {
        initSingleLinkList();

        exchangeTwoNodes();
//        revserseTwoAdjacentNode();
//        reverseSingleLinkList1();
//        reverseSingleList2();
        reverseSingleList3();
    }

    private void initSingleLinkList() {
        mSingleList = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);
        LinkNode node6 = new LinkNode(6);

        mSingleList.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
    }

    public void reverseSingleLinkList1() {
        LinkNode curNode = mSingleList;
        LinkNode reverseNode = null;

        while (curNode != null) {
            LinkNode toInsertNode = curNode;
            curNode = curNode.next;

            if (reverseNode == null) {
                reverseNode = toInsertNode;
                //这个去尾,这个可不能忘啊
                toInsertNode.next = null;
            } else {
                toInsertNode.next = reverseNode;
                reverseNode = toInsertNode;
            }
        }

        while (reverseNode != null) {
            System.out.print(" " + reverseNode.val);
            reverseNode = reverseNode.next;
        }
    }

    public void reverseSingleList2() {
        Stack<LinkNode> myStack = new Stack<LinkNode>();
        LinkNode curNode = mSingleList;

        while (curNode != null) {
            myStack.push(curNode);
            curNode = curNode.next;
        }

        LinkNode reverseNode = null;
        LinkNode traversalNode = null;
        while (myStack.size() != 0) {
            LinkNode popNode = myStack.pop();

            if (reverseNode == null) {
                reverseNode = popNode;
                traversalNode = reverseNode;
            } else {
                traversalNode.next = popNode;
                traversalNode = traversalNode.next;
            }
            if (myStack.size() == 0) {
                traversalNode.next = null;
            }
        }
        Utils.printLinkNode(reverseNode);
    }

    /**
     * 一个单链表, 让中间的两个相临元素逆序.比如这个,就让3和4 换一下位置
     */
    private void revserseTwoAdjacentNode() {
        LinkNode curNode = mSingleList;
        int index = 0;

        LinkNode pre3Node = null;
        while (curNode != null) {
            if (index == 1) {
                pre3Node = curNode;
                break;
            }
            curNode = curNode.next;
            index++;
        }

        LinkNode index3Node = pre3Node.next;
        //用了三步 , 使用了2个寄存用的变量 : 要换的第一个结点的父节点,与要换的这个节点
        pre3Node.next = index3Node.next;
        index3Node.next = pre3Node.next.next;
        pre3Node.next.next = index3Node;

        Utils.printLinkNode(mSingleList);
    }

    //还是上边的链表,这个是替换3和5
    private void exchangeTwoNodes() {
        LinkNode curNode = mSingleList;
        LinkNode pre3Node = null;
        LinkNode pre5Node = null;

        int index = 0;
        while (curNode != null) {

            if (index == 1) {
                pre3Node = curNode;
            }
            if (index == 3) {
                pre5Node = curNode;
            }
            curNode = curNode.next;
            index++;
        }

        //这里很容易乱, 单链表,反正也首先整2个寄存的临时变量; 然后下边操作时,集中把一个点的前后,都先换完,然后再换第二个,这样流程还稍微熟悉些
        LinkNode index3Node = pre3Node.next;
        LinkNode after5Node = pre5Node.next.next;

        pre3Node.next = pre5Node.next;
        pre3Node.next.next = index3Node.next;

        pre5Node.next = index3Node;
        index3Node.next = after5Node;

        Utils.printLinkNode(mSingleList);

    }

    public void reverseSingleList3() {
        int linkListLength = 0;
        LinkNode curNode = mSingleList;
        while (curNode != null) {
            linkListLength++;
            curNode = curNode.next;
        }
        int tailIndex = linkListLength;
        while (tailIndex > 0) {
            moveNode(mSingleList, tailIndex);
            tailIndex--;
        }
        Utils.printLinkNode(mSingleList);
    }

    private void moveNode(LinkNode head, int tailIndex) {
        LinkNode curNode = head;
        int count = 0;
        while (curNode != null && count < tailIndex - 1) {

            LinkNode nextNode = curNode.next;
            if (nextNode != null) {
                curNode.next = nextNode.next;
                nextNode.next = curNode;
                if (count == 0) {
                    mSingleList = nextNode;
                }
            }
//            curNode = curNode.next;
            count++;
        }
    }
}
