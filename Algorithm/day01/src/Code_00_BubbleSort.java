import java.util.Arrays;

/**
 *冒泡排序算法
 */
public class Code_00_BubbleSort {

	public static void bubbleSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int e = arr.length - 1; e > 0; e--) {
			for (int i = 0; i < e; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
	}
	/*************对数器验证************/
	// for test  2.准备一个绝对正确的方法，使用系统提供
	public static void comparator(int[] arr) {
		Arrays.sort(arr);//系统自带排序，绝对正确
	}

	// for test 1.生成长度随机的数组
	public static int[] generateRandomArray(int size, int value) {
		/*
		Math.random()->double [0,1)
		(int) ((size+1)*Math.random())->[0,size]整数
		size=6,size+1=7
		Math.random() ->[0,1)*7->[0,7) double
		double ->int[0,6]->int
		 */
		int[] arr = new int[(int) ((size + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((value + 1) * Math.random()) - (int) (value * Math.random());
		}
		return arr;
	}

	// for test  拷贝数组
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test 测试两个数组是否相等
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test  打印数组
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test  3.大样本测试
	public static void main(String[] args) {
		int testTime = 500000;
		int size = 100;
		int value = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(size, value);//1.随机生成数组
			int[] arr2 = copyArray(arr1);//拷贝数组
			bubbleSort(arr1);//冒泡排序
			comparator(arr2);//正确算法
			if (!isEqual(arr1, arr2)) {
				succeed = false;//比较绝对正确的算法和自己的排序算法是否结果一致
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(size, value);
		printArray(arr);//打印原数组
		bubbleSort(arr);//排序
		printArray(arr);//打印排序数组
	}

}
