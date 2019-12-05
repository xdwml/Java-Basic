package Tree;
import utils.TreeNode;

public class Problem19Test {
    public static void main(String args[])
    {
        TreeNode root1=new TreeNode(8);
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        root1.left=node1;
        root1.right=node2;
        node1.left=node3;
        node1.right=node4;
        node4.left=node5;
        node4.right=node6;


        Problem19 test=new Problem19();
        test.Mirror(root1);


    }
}
