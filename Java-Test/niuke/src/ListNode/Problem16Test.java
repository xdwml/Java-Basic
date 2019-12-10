package ListNode;
import utils.ListNode;

public class Problem16Test {
    public static void main (String args[])
    {
        ListNode head=new ListNode(10);
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        ListNode node6=new ListNode(6);
        ListNode node7=new ListNode(7);
        ListNode node8=new ListNode(8);
        ListNode node9=new ListNode(9);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=node9;
        Problem16 test=new Problem16();

        ListNode node=test.ReverseList(node1);
        System.out.println(node.val);
    }
}
