package ListNode;
import utils.ListNode;
public class Problem17 {
	/*
	 * 输入两个递增的链表，合并这两个链表并使新链表仍然是递增的
	 */
	public ListNode merge(ListNode list1, ListNode list2)
	{
		if(list1==null){
			return list2;
		}else if(list2==null){
			return list1;
		}
		ListNode mergeHead=null;
		if(list1.value<=list2.value)
		{
			mergeHead=list1;
			mergeHead.next=merge(list1.next,list2);
		}else{
			mergeHead=list2;
			mergeHead.next=merge(list1,list2.next);
		}
		return mergeHead;
	}
}


