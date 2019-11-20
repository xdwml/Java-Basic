/*
三种循环的区别。

1. 如果条件判断从来没有满足过，那么for循环和while循环将会执行0次，但是do-while循环会执行至少一次。
2. for循环的变量在小括号当中定义，只有循环内部才可以使用。while循环和do-while循环初始化语句本来就在外面，所以出来循环之后还可以继续使用。
*/
public class Demo13LoopDifference {
	public static void main(String[] args) {
		for (int i = 1; i < 0; i++) {
			System.out.println("Hello");
		}
		// System.out.println(i); // 这一行是错误写法！因为变量i定义在for循环小括号内，只有for循环自己才能用。
		System.out.println("================");
		
		int i = 1;
		do {
			System.out.println("World");
			i++;
		} while (i < 0);
		// 现在已经超出了do-while循环的范围，我们仍然可以使用变量i
		System.out.println(i); // 2
	}
}