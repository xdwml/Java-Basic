package Tree;
import java.util.ArrayList;
import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Problem23 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                continue;//结束本次循环，继续下一次循环
            }
            list.add(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }
        return list;

    }
}
/*
ArrayList<Integer> list = new ArrayList<>();
        if(root!=null)
            return list;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode node=queue.poll();

            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }
        return list;
 */