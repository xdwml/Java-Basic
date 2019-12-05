package Tree;

import utils.TreeNode;

/**
 * Created by liujia on 14-8-26.
 */
public class Problem6test {
	public  static void main(String args[]) throws Exception
	{
		Problem6 test=new Problem6();
		int[] pre={1,2,4,7,3,5,6,8};
		int[] in={4,7,2,1,5,3,8,6};
		TreeNode root=test.reConstructBinaryTree(pre,in);
		posOrderRecur(root);

	}
	//后序遍历
	public static void posOrderRecur(TreeNode head) {

		posOrderRecur(head.left);//先打印左孩子
		posOrderRecur(head.right);//再打印右孩子
		System.out.print(head.val + " ");//最后打印头
	}
}
