package zystudio.leecode;

import zystudio.bean.LinkNode;

/**
 * Created by leeco on 2017/6/28.
 */
public class ReverseLinkList {


    public static void showDemo() {

        LinkNode l1 = new LinkNode(2);
        l1.next = new LinkNode(4);
        l1.next.next = new LinkNode(6);
        l1.next.next.next = new LinkNode(8);
        l1.next.next.next.next = new LinkNode(3);

//        LinkNode result = reverseListNode1(l1);
//        LinkNode result = reverseListNode2(l1);
        LinkNode result = reverseListNode3(l1);
        printListNode(result);
    }

    private static void printListNode(LinkNode result) {
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        System.out.println("end");
    }

    //只是2的语法小精简版本,2中多的那个一次循环根本没用
    public static LinkNode reverseListNode3(LinkNode target) {
        LinkNode head = new LinkNode(0);
        head.next = target;

        LinkNode prePtr = target;
        LinkNode curPtr = target.next;

        //只有一个元素的话,他妈的也无所谓逆序了
        if(curPtr==null){
            return target;
        }

        while (curPtr != null) {

            LinkNode tmp = head.next;
            prePtr.next = curPtr.next;
            curPtr.next = tmp;
            head.next = curPtr;

            curPtr = prePtr.next;

            printListNode(head);
        }
        return head.next;
    }


    //这个记 head后边的 结点为tmp的, 比他妈的记移动的 那个,方便太多了,但是代码应该还是可以精简的
    public static LinkNode reverseListNode2(LinkNode target) {

        LinkNode head = new LinkNode(0);
        head.next = target;

        LinkNode prePtr = head;
        LinkNode curPtr = target;

        while (curPtr != null) {
            if (curPtr == target) {
                prePtr = curPtr;
                curPtr = curPtr.next;
                continue;
            }

            LinkNode tmp = head.next;
            prePtr.next = curPtr.next;
            curPtr.next = tmp;
            head.next = curPtr;

            curPtr = prePtr.next;

            printListNode(head);
        }

        return head.next;


    }

    //这是我想的插入逆序的方式,tmp 存储的一直是扫描ptr后边那个因素, 这个代码,一定可以精简
    public static LinkNode reverseListNode1(LinkNode target) {

        LinkNode head = new LinkNode(0);
        head.next = target;

        LinkNode prePtr = head;
        LinkNode curPtr = target;

        while (curPtr != null) {
            if (curPtr == head.next) {
                prePtr = curPtr;
                curPtr = curPtr.next;
                continue;
            }

            LinkNode tmp = curPtr.next;
            prePtr.next = tmp;


            curPtr.next = head.next;
            head.next = curPtr;

            printListNode(head);
            curPtr = tmp;
        }

        return head.next;
    }
}
