package Tree;

import java.util.Arrays;

public class Problem24 {
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length<=0) return false;//鲁棒性
        int root=sequence[sequence.length-1];
        //在二叉搜索树中左子树的节点小于根节点
        int cut=0;
        for(int i=0;i<sequence.length-1;i++){
            if (sequence[i]>root){
                cut=i+1;
                break;
            }
        }
        //在二叉搜索树中右子树的节点大于根节点
        for(int j=cut;j<sequence.length-1;j++){
            if (sequence[j]<root){
                break;
            }
        }
        //判断左子树是不是二叉搜索树
        boolean left=false;
        boolean right=false;

        if(cut>0){
            left=VerifySquenceOfBST(Arrays.copyOfRange(sequence,0,cut));
        }
        //判断左子树是不是二叉搜索树
        if(cut<sequence.length-1){
            right=VerifySquenceOfBST(Arrays.copyOfRange(sequence,cut,sequence.length-1));
        }
        return left &&right;
    }

    public static void main(String[] args) {
        int [] arr={4,8,6,12,16,14,10};//true
        //int [] arr={7,4,5,6};//false
        //int [] arr={5,7,6,9,11,10,8};//true
        System.out.println(VerifySquenceOfBST(arr));
    }
}
