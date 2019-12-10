package ListNode;
import utils.ListNode;
/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
import java.util.Stack;
public class Problem15 {
    public ListNode FindKthToTail(ListNode head,int k) {
        //判断条件
        if(head==null || k<=0)
            return null;
        ListNode result;
        ListNode list=head;//赋值
        for(int i=0;i<k-1;++i)
        {
            if(list.next!=null)
                list=list.next;//判断走到头了
            else
                return null;//如果节点数小于K，返回空
        }
        result=head;//赋值
        while(list.next!=null)
        {
            list=list.next;
            result=result.next;
        }
        return result;
    }
}
