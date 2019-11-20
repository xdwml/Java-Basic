/*
在给变量进行赋值的时候，如果右侧的表达式当中全都是常量，没有任何变量，
那么编译器javac将会直接将若干个常量表达式计算得到结果。
short result = 5 + 8; // 等号右边全都是常量，没有任何变量参与运算
编译之后，得到的.class字节码文件当中相当于【直接就是】：
short result = 13;
右侧的常量结果数值，没有超过左侧范围，所以正确。

这称为“编译器的常量优化”。

但是注意：一旦表达式当中有变量参与，那么就不能进行这种优化了。
*/
public class Demo13Notice {
	public static void main(String[] args) {
		short num1 = 10; // 正确写法，右侧没有超过左侧的范围，
		
		short a = 5;
		short b = 8;
		// short + short --> int + int --> int
		// short result = a + b; // 错误写法！左侧需要是int类型
		
		// 右侧不用变量，而是采用常量，而且只有两个常量，没有别人
		short result = 5 + 8;
		System.out.println(result);
		
		short result2 = 5 + a + 8; // 18
	}
}