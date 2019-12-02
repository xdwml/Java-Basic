/**
 * 旋转正方形矩阵：给定一个整型正方形矩阵matrix， 请把该矩阵调整成
 顺时针旋转90度的样子
 */
public class Code_05_RotateMatrix {

	public static void rotate(int[][] matrix) {
		int a = 0;
		int b = 0;
		int c= matrix.length - 1;
		int d = matrix[0].length - 1;
		while (a < d) {
			rotateEdge(matrix, a++, b++, c--, d--);
		}
	}

	public static void rotateEdge(int[][] m, int a, int b, int c, int d) {
		int times = d - b;//计算交换次数
		int tmp = 0;
		//找出发点的循环
		for (int i = 0; i != times; i++) {
			tmp = m[a][b + i];
			m[a][b + i] = m[c - i][b];//原始出发点=
			m[c - i][b] = m[c][d - i];
			m[c][d - i] = m[a + i][d];
			m[a + i][d] = tmp;
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		printMatrix(matrix);//转换前打印
		rotate(matrix);//转换
		System.out.println("=============");
		printMatrix(matrix);//转换后打印

	}

}
