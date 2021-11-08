package by.jonline.modul02.arrayArray;

/*
 * Найдите наибольший элемент матрицы и заменить все нечетные элементы на него. 
 */

public class Exercise15 {

	public static void main(String[] args) {

		int[][] matrix = new int[][] { { 1, 6, -9 }, { -10, 5, 18 }, { 0, 72, 9 } };

		changeOdd(matrix);

		printArray(matrix);

	}

	public static void changeOdd(int mas[][]) {

		int maxNum = findMax(mas);

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				if (mas[i][j] % 2 != 0) {

					mas[i][j] = maxNum;
				}

			}
		}

	}

	public static int findMax(int mas[][]) {

		int num;

		num = mas[0][0];

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				if (mas[i][j] > num) {

					num = mas[i][j];

				}
			}
		}
		return num;
	}

	public static void printArray(int mas[][]) {

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				System.out.print(mas[i][j] + "\t");
			}
			System.out.println();
		}

	}
}
