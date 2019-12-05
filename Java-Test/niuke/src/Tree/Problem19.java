package Tree;
import utils.TreeNode;
/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Problem19 {
    public void Mirror(TreeNode root) {
        if(root==null) return;
        if(root.left==null && root.right==null) return;

        TreeNode node=root.left;
        root.left=root.right;
        root.right=node;
        if(root.left!=null)
            Mirror(root.left);
        if(root.right!=null)
            Mirror(root.right);
    }
}
