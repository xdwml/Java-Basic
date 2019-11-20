/*
break关键字的用法有常见的两种：

1. 可以用在switch语句当中，一旦执行，整个switch语句立刻结束。
2. 还可以用在循环语句当中，一旦执行，整个循环语句立刻结束。打断循环。

关于循环的选择，有一个小建议：
凡是次数确定的场景多用for循环；否则多用while循环。
*/
public class Demo14Break {
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			// 如果希望从第4次开始，后续全都不要了，就要打断循环
			if (i == 4) { // 如果当前是第4次
				break; // 那么就打断整个循环
			}
			System.out.println("Hello" + i);
		}
	}
}