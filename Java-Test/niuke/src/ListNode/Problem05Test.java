package ListNode;
import utils.ListNode;

import java.util.ArrayList;

public class Problem05Test {
    public static void main (String args[])
    {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        node1.next=node2;
        node2.next=node3;
        Problem05 test=new Problem05();
        //test.printListReverse(node1);
        ArrayList<Integer> list= test.printListFromTailToHead(node1);
        for ( int i =0 ; i<list.size(); i++ ) {
            System.out.print(list.get(i)+"<--");//遍历获得一个 ArrayList链表输出。
        }
    }
}
