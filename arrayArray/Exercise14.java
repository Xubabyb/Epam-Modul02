package by.jonline.modul02.arrayArray;

import java.util.Random;

/*
 * Сформировать случайную матрицу m x n, состоящую из нулей и единиц, причем 
 * в каждом столбце число единиц равно номеру столбца.
 */

public class Exercise14 {

	public static void main(String[] args) {

		int m;
		int n;
		int[][] mass;

		m = randomNum(10);

		n = randomNum(m + 1);

		mass = new int[m][n];

		iniArray(mass);

		printArray(mass);

		System.out.println("Размер случайной матрицы " + m + " x " + n);

	}

	public static int randomNum(int m) {

		Random rand = new Random();
		int x;

		do {
			x = rand.nextInt(m);
		} while (x < 2);

		return x;
	}

	public static void printArray(int mas[][]) {

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				System.out.print(mas[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public static void iniArray(int mas[][]) {

		if (mas == null) {
			return;
		}

		Random rand = new Random();

		int count;

		for (int j = 0; j < mas[0].length; j++) {

			count = j;

			for (int i = 0; i < mas.length; i++) {

				while (count > 0) {

					int temp = rand.nextInt(mas.length);

					if (mas[temp][j] == 0) {

						mas[temp][j] = 1;
						count --;
					}
				}
			}
		}
	}
}
