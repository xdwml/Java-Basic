package Tree;

import utils.TreeNode;

import java.util.ArrayList;

public class Problem23Test {
    public static void main(String[] args) {
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
        Problem23 test=new Problem23();
        ArrayList<Integer> list=test.PrintFromTopToBottom(root1);
        for (int i = 0; i <list.size() ; i++) {
            System.out.print(list.get(i)+"  ");
        }
    }

}
