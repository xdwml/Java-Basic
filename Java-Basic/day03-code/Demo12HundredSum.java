/*
题目：求出1-100之间的偶数和。

思路：
1. 既然范围已经确定了是1到100之间，那么我就从1、2、3……一直到100这么多数字一个一个进行检查。
2. 总共有100个数字，并非所有数字都能用。必须要是偶数才能用，判断（if语句）偶数：num % 2 == 0
3. 需要一个变量，用来进行累加操作。也就好比是一个存钱罐。
*/
public class Demo12HundredSum {
	public static void main(String[] args) {
		int sum = 0; // 用来累加的存钱罐
		
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) { // 如果是偶数
				sum += i;
			}
		}
		System.out.println("结果是：" + sum);
	}
}