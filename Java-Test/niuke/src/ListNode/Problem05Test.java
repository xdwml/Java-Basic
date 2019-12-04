package ListNode;
import utils.ListNode;
public class Problem05Test {
    public static void main (String args[])
    {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        Problem05 test=new Problem05();
        test.printListReverse(node1);
    }
}
