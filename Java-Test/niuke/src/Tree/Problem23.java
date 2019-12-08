package Tree;

import java.util.ArrayList;
import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
public class Problem23 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root!=null)
            return list;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();
            System.out.println(node.val);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }
        return list;
    }
}
