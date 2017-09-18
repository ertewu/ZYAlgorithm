package zystudio.datastructure;

import zystudio.Utils;
import zystudio.bean.DoubleLinkNode;

/**
 * Created by leeco on 2017/7/30.
 * 双向链表的操作, 第一个操作是 相临节点 交换位置
 */
public class DoubleLinkListOperations {

    private DoubleLinkNode mSingleList;

    public DoubleLinkListOperations() {
        initSingleLinkList();
    }

    private void initSingleLinkList() {
        mSingleList = new DoubleLinkNode(1);
        DoubleLinkNode node2 = new DoubleLinkNode(2);
        DoubleLinkNode node3 = new DoubleLinkNode(3);
        DoubleLinkNode node4 = new DoubleLinkNode(4);
        DoubleLinkNode node5 = new DoubleLinkNode(5);
        DoubleLinkNode node6 = new DoubleLinkNode(6);

        mSingleList.next = node2;
        node2.previous = mSingleList;
        node2.next = node3;

        node3.previous = node2;
        node3.next = node4;

        node4.previous = node3;
        node4.next = node5;

        node5.previous = node4;
        node5.next = node6;

        node6.previous = node5;
    }

    public void showDemo() {
        exchangeAdjacentNodes();
    }

    /**
     * 交换两个相邻节点, 双向链表额,比如这个Demo交换2和5. 这个蠢方法,用了5个寄存变量
     */
    private void exchangeAdjacentNodes() {

        DoubleLinkNode index2Node = null;
        DoubleLinkNode index5Node = null;


        DoubleLinkNode curNode = mSingleList;
        int index = 0;
        while (curNode != null) {
            if (index == 1) {
                index2Node = curNode;
            }
            if (index == 4) {
                index5Node = curNode;
            }
            curNode = curNode.next;
            index++;
        }

        DoubleLinkNode pre2Node = index2Node.previous;
        DoubleLinkNode pre5Node = index5Node.previous;
        DoubleLinkNode after5Node = index5Node.next;
        //我最终用了高达5个寄存变量, 除了那2个结点外,还用了三个.实际上,双向链表貌似只用更少就可以,只要在顺序上有些变化

        //index5 与 pre2Node之间
        pre2Node.next = index5Node;
        index5Node.previous = pre2Node;

        //index5与 他下个结点之间
        index5Node.next = index2Node.next;
        index5Node.next.previous = index5Node;

        pre5Node.next = index2Node;
        index2Node.previous = pre5Node;

        index2Node.next = after5Node;
        after5Node.previous= index2Node;

        Utils.printDoubleLinkNode(mSingleList);
    }

    /**
     *这个,目标是用最少的寄存变量, 不多想了,找答案看思路吧
     */
    private void exchangeAdjacentNodes2(){

        DoubleLinkNode index2Node = null;
        DoubleLinkNode index5Node = null;

        DoubleLinkNode curNode = mSingleList;
        int index = 0;
        while (curNode != null) {
            if (index == 1) {
                index2Node = curNode;
            }
            if (index == 4) {
                index5Node = curNode;
            }
            curNode = curNode.next;
            index++;
        }


        Utils.printDoubleLinkNode(mSingleList);
    }

}
