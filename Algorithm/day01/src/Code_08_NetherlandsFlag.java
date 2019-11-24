/**
 * 荷兰国旗问题:小于num的放左边，等于的放中间，大于的放右边
 */
public class Code_08_NetherlandsFlag {
	public static void main(String[] args) {
		int[] test = generateArray();

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 1);
		printArray(test);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}
	public static int[] partition(int[] arr, int l, int r, int num) {
		int less = l - 1;
		int more = r + 1;
		int index=l;
		//条件循环，不撞线
		while (index < more) {
		    //第一种情况：当前索引值小于num,less索引增加，index值和less索引值交换，然后
			if (arr[index] < num) {
				swap(arr, ++less, index++);
				//第二种情况：当前索引值大于num,more索引自减，index的值和more索引值交换
			} else if (arr[index] > num) {
				swap(arr, --more, index);
                //第三种情况：当前索引值等于num,index自增
			} else {
                index++;
			}
		}
		return new int[] { less + 1, more - 1 };
	}

	// for test 交换
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}


}
