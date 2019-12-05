package Tree;
import utils.TreeNode;
public class Problem18Test {
    public static void main(String args[])
    {
        TreeNode root1=new TreeNode(8);
        TreeNode node1=new TreeNode(9);
        TreeNode node2=new TreeNode(7);
        TreeNode node3=new TreeNode(9);
        TreeNode node4=new TreeNode(2);
        TreeNode node5=new TreeNode(4);
        TreeNode node6=new TreeNode(7);
        root1.left=node1;
        root1.right=node2;
        node1.left=node3;
        node1.right=node4;
        node4.left=node5;
        node4.right=node6;

        TreeNode root2=new TreeNode(8);
        TreeNode a=new TreeNode(7);
        TreeNode b=new TreeNode(2);
        root2.left=a;
        root2.right=b;
        root2.val=8;
        Problem18 test=new Problem18();
        System.out.println(test.HasSubtree(root1, root2));

    }
}
