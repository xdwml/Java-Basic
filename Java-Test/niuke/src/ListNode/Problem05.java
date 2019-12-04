package ListNode;
import utils.ListNode;
import java.util.Stack;
public class Problem05 {
    /*
	输入一个链表的头节点，从尾到头反向打印
	 */
    public void printListReverse(ListNode headNode)
    {
        Stack<ListNode> stack=new Stack<ListNode>();
        while(headNode!=null)
        {
            stack.push(headNode);
            headNode=headNode.next;
        }
        while(!stack.isEmpty())
        {
            System.out.print(stack.pop().value+"<--");
        }
    }
}
/*方法2
import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		ListNode head = listNode;//这里需要构造一个ListNode类
		while ( head != null ) {//需要先判断链表时候为空
			list.add( head.val );//定义节点
			head = head.next;
		}
		for ( int i = list.size()-1; i>=0; i-- ) {
			result.add( list.get(i) );//遍历获得一个 ArrayList链表输出。
		}
		return result;
    }
}
 */
