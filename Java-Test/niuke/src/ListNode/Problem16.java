package ListNode;
import utils.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Problem16 {
    public ListNode ReverseList(ListNode head) {
        //鲁棒性
        if(head==null ||head.next==null){
            return head;
        }
        ListNode pre=null;//当前节点的前一个节点
        ListNode next=null;//当前节点的下一个节点
        while(head!=null){
            next=head.next;//记录当前节点的下一个节点位置
            head.next=pre;//让当前节点指向下一个节点位置，完成反转
            pre=head;//pre往右走
            head=next;//当前节点往右继续走
        }
        return pre;
    }
}
