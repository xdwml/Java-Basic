package Tree;
/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
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
        if(cut==0)
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0 ,sequence.length-1));
        else {
            for(int i=cut;i<sequence.length-1;i++)
            {
                if(sequence[i]<=root)
                    return false;
            }
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0 ,cut));
            VerifySquenceOfBST(Arrays.copyOfRange(sequence, cut,sequence.length-1));
        }
        return true;
    }
    public static void main(String[] args) {
        //int [] arr={4,8,6,12,16,14,10};//true
        int [] arr={7,4,5,6};//false
        //int [] arr={5,7,6,9,11,10,8};//true
        System.out.println(VerifySquenceOfBST(arr));
    }
}
