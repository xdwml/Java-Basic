package Tree;
import utils.TreeNode;
/**
 *根据先序中序后序重建二叉树
 */
public class Problem6test {
	public  static void main(String args[]) throws Exception
	{
		Problem6 test=new Problem6();
		int[] pre={1,2,4,7,3,5,6,8};
		int[] in={4,7,2,1,5,3,8,6};
		int[] pos={7,4,2,5,8,6,3,1};
		//根据先序中序重建二叉树
		TreeNode root1=test.reConstructBinaryTree(pre,in);
		//TreeNode root1=test.reConstructBinaryTree(pos,in);
		TreeNode root2=root1;
		TreeNode root3=root2;
		System.out.println("先序遍历为：");
		preOrderRecur(root1);
		System.out.println();
		System.out.println("中序遍历为：");
		inOrderRecur(root2);
		System.out.println();
		System.out.println("后序遍历为：");
		posOrderRecur(root3);

	}
	//先序遍历
	public static void preOrderRecur(TreeNode head) {
		if(head!=null){
			System.out.print(head.val + " ");//先打印头
			preOrderRecur(head.left);//再打印左孩子
			preOrderRecur(head.right);//最后打印右孩子
		}
	}
	//中序遍历
	public static void inOrderRecur(TreeNode head) {
		if(head!=null){
			inOrderRecur(head.left);//先打印左孩子
			System.out.print(head.val + " ");//再打印头
			inOrderRecur(head.right);//最后打印右孩子
		}
	}
	//后序遍历
	public static void posOrderRecur(TreeNode head) {
		if(head!=null){
			posOrderRecur(head.left);//先打印左孩子
			posOrderRecur(head.right);//再打印右孩子
			System.out.print(head.val + " ");//最后打印头
		}
	}
}
