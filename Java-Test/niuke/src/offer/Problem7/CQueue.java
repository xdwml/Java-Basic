package offer.Problem7;

import java.util.Stack;

/**
 * Created by liujia on 14-8-26.
 */
public class CQueue {
	/*
	用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
	 */
	private Stack<Integer> stack1=new Stack<Integer>();
	private Stack<Integer> stack2=new Stack<Integer>();
	public void push(Integer node)//改泛型
	{
		stack1.push(node);
	}
	public Integer pop()
	{
		if(stack2.isEmpty())
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}
}
