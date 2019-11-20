package cn.itcast.day05.demo03;

public class Demo06ArrayMin {

    public static void main(String[] args) {
        int[] array = { 5, 15, 30, 20, 10000, -20, 30, 35 };

        int min = array[0]; // 比武擂台
        for (int i = 1; i < array.length; i++) {
            // 如果当前元素，比min更小，则换人
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("最小值：" + min);
    }

}
