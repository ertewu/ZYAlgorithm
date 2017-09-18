package zystudio;

import zystudio.bean.DoubleLinkNode;
import zystudio.bean.LinkNode;

/**
 * Created by leeco on 2017/7/25.
 */
public class Utils {

    public static void printList(int[] list) {
        for (int i : list) {
            System.out.println("" + i);
        }
    }

    public static void printLinkNode(LinkNode head) {
        while (head != null) {
            System.out.print(" " + head.val);
            head = head.next;
        }
    }

    public static void printDoubleLinkNode(DoubleLinkNode head) {
        while (head != null) {
            System.out.print(" " + head.val);
            head = head.next;
        }
    }

}
