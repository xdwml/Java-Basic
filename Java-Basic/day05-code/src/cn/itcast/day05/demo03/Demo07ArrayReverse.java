package cn.itcast.day05.demo03;

/*
数组元素的反转：
本来的样子：[1, 2, 3, 4]
之后的样子：[4, 3, 2, 1]

要求不能使用新数组，就用原来的唯一一个数组。
 */
public class Demo07ArrayReverse {

    public static void main(String[] args) {
        int[] array = { 10, 20, 30, 40, 50 };

        // 遍历打印数组本来的样子
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("============");

        /*
        初始化语句：int min = 0, max = array.length - 1
        条件判断：min < max
        步进表达式：min++, max--
        循环体：用第三个变量倒手
         */
        for (int min = 0, max = array.length - 1; min < max; min++, max--) {
            int temp = array[min];
            array[min] = array[max];
            array[max] = temp;
        }

        // 再次打印遍历输出数组后来的样子
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
