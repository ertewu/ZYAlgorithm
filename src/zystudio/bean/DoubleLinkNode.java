package zystudio.bean;

/**
 * Created by leeco on 2017/7/30.
 */
public class DoubleLinkNode {

    public int val;

    public DoubleLinkNode next = null;
    public DoubleLinkNode previous = null;

    public DoubleLinkNode() {

    }

    public DoubleLinkNode(int pVal) {
        val = pVal;
    }
}

