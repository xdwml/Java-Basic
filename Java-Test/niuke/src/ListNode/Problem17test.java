package ListNode;
import utils.ListNode;
public class Problem17test {
	public static void main(String args[])
	{
		ListNode head1=new ListNode(1);
		ListNode second1=new ListNode(2);
		ListNode head2=new ListNode(2);
		ListNode second2=new ListNode(2);
		ListNode third2=new ListNode(6);
		head1.next=second1;
		head2.next=second2;
		second2.next=third2;
		Problem17 test=new Problem17();
		ListNode result=test.merge(head1,head2);
		ListNode temp=result;
		while(temp!=null)
		{
			System.out.print(temp.val+"-->");
			temp=temp.next;
		}
		System.out.println();
		System.out.println(result.val);
	}

}
