package by.jonline.modul02.arrayArray;



/*
 * Найти положительные элементы главной диагонали квадратной матрицы.
 */

public class Exercise10 {

	public static void main(String[] args) {

		int[][] mass = new int[][] { { 3, -3, 5 }, { -1, -8, -9 }, { -7, 0, 5 } };

		System.out.println("Положительные элементы диагонали матрицы:");

		getResult(mass);
	}

	public static void getResult(int[][] mass) {

		for (int i = 0; i < mass.length; i++) {

			if (mass[i][i] > 0) {

				System.out.println(mass[i][i] + " позиция [" + i + "][" + i + "]");
			}
		}
	}

}