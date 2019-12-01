package Tree;

import utils.BinaryTreeNode;

/**
 * Created by liujia on 14-8-26.
 */
public class Problem6test {
	public  static void main(String args[]) throws Exception
	{
		Problem6 test=new Problem6();
		int[] pre={1,2,3,4};
		int[] in={5,6,7,1};
		BinaryTreeNode root=test.constructCore(pre,in);
		System.out.println(root);
	}
}
