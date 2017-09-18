package zystudio.leecode;

import zystudio.bean.LinkNode;

/**
 * Created by leeco on 2017/6/27.
 */
public class AddTwoNumbers {

    public static void showDemo() {

        LinkNode l1 = new LinkNode(2);
        l1.next = new LinkNode(4);
        l1.next.next = new LinkNode(6);
        l1.next.next.next = new LinkNode(6);
        l1.next.next.next.next = new LinkNode(3);

        LinkNode l2 = new LinkNode(5);
        l2.next = new LinkNode(6);
        l2.next.next = new LinkNode(3);

        LinkNode result = addTwoNumbers1(l1, l2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static LinkNode addTwoNumbers2(LinkNode l1, LinkNode l2) {
        return null;
    }

    //自己写的做法,支持不对奇等,多进位等,是个完整的功能
    //但是这个在letcode中,第一次提交超时了,第二次虽然过了,但肯定不是什么好解法了...,我还得想其它算法
    public static LinkNode addTwoNumbers1(LinkNode l1, LinkNode l2) {


        LinkNode resultPtr = null;
        LinkNode curNodePtr = null;

        LinkNode l1CurNodePtr = l1;
        LinkNode l2CurNodePtr = l2;


        boolean isCarray = false;

        while (l1CurNodePtr != null ||l2CurNodePtr!=null || isCarray) {
            int l1Value = l1CurNodePtr != null ? l1CurNodePtr.val : 0;
            int l2Value = l2CurNodePtr != null ? l2CurNodePtr.val : 0;

            int sum = l1Value + l2Value;
            if (isCarray) {
                sum++;
            }
            int mod = sum % 10;


            if (resultPtr == null) {
                resultPtr = new LinkNode(mod);
                curNodePtr = resultPtr;
            } else {
                curNodePtr.next = new LinkNode(mod);
                curNodePtr = curNodePtr.next;
            }

            l1CurNodePtr = l1CurNodePtr != null ? l1CurNodePtr.next : null;
            l2CurNodePtr = l2CurNodePtr != null ? l2CurNodePtr.next : null;

            if (sum >= 10) {
                isCarray = true;
            }else {
                isCarray=false;
            }
        }
        return resultPtr;
    }

}
