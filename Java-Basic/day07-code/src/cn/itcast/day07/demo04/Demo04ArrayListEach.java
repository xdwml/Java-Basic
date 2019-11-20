package cn.itcast.day07.demo04;

import java.util.ArrayList;

public class Demo04ArrayListEach {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("迪丽热巴");
        list.add("古力娜扎");
        list.add("玛尔扎哈");

        // 遍历集合
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
