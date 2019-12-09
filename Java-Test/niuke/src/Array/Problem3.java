package Array;

/**
 * 二维数组的查找
 */
public class Problem3 {
    public boolean Find(int target, int [][] array) {
        /*
        思路：
        根据数组的特点可以发现,如果从左下角开始查找更为方便
        左下角的数比同一列的数大，同时比同一行的数小
        也就是从左下角开始比，如果target传入的数大于它则列数加一继续比较
        如果小于它则行数减一继续比较
        */
        //判断二维数组
        int rows = array.length;//行数
        if(rows == 0){
            return false;
        }
        int cols = array[0].length;//列数
        if(cols == 0){
            return false;
        }
        //定义左下角的行数
        int row=rows-1;
        //定义左下角的列数
        int col=0;
        //while里的条件是极限情况，不满足条件的时候则停止
        while( row>=0 && col<cols)
        {
            //目标大于左下角，让列数自增
            if(array[row][col]<target)
            {
                col++;
                //目标小于左下角，让行数自减
            }else if(array[row][col]>target)
            {
                row--;
            }else
            {
                //除了上述两种情况就是相等了，说明已经找到了
                return true;
            }
        }
        //遍历完还没有找到，说明不存在
        return false;
    }
}
