/*
另一种循环控制语句是continue关键字。
一旦执行，立刻跳过当前次循环剩余内容，马上开始下一次循环。
*/
public class Demo15Continue {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			if (i == 4) { // 如果当前是第4层
				continue; // 那么跳过当前次循环，马上开始下一次（第5层）
			}
			System.out.println(i + "层到了。");
		}
	}
}