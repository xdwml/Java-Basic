package Tree;

public class Problem24 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length<=0) return false;//鲁棒性
        int root=sequence[sequence.length-1];
        //在二叉搜索树中左子树的节点
        return false;
    }

    public static void main(String[] args) {
        int [] arr={5,7,6,9,11,10,8};
        System.out.println(VerifySquenceOfBST(arr));
    }
}
