/*
运算符：进行特定操作的符号。例如：+
表达式：用运算符连起来的式子叫做表达式。例如：20 + 5。又例如：a + b

四则运算：
加：+
减：-
乘：*
除：/

取模（取余数）：%

首先计算得到表达式的结果，然后再打印输出这个结果。
复习一下小学一年级的除法公式：
被除数 / 除数 = 商 ... 余数

对于一个整数的表达式来说，除法用的是整除，整数除以整数，结果仍然是整数。只看商，不看余数。
只有对于整数的除法来说，取模运算符才有余数的意义。

注意事项：
	1. 一旦运算当中有不同类型的数据，那么结果将会是数据类型范围大的那种。
*/
public class Demo04Operator {
	public static void main(String[] args) {
		// 两个常量之间可以进行数学运算
		System.out.println(20 + 30);
		
		// 两个变量之间也可以进行数学运算
		int a = 20;
		int b = 30;
		System.out.println(a - b); // -10
		
		// 变量和常量之间可以混合使用
		System.out.println(a * 10); // 200
		
		int x = 10;
		int y = 3;
		
		int result1 = x / y;
		System.out.println(result1); // 3
		
		int result2 = x % y;
		System.out.println(result2); // 余数，模，1
		
		// int + double --> double + double --> double
		double result3 = x + 2.5;
		System.out.println(result3); // 12.5
	}
}