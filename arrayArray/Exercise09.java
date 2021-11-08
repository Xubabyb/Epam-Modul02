package by.jonline.modul02.arrayArray;

import java.util.Random;
import java.util.Scanner;

/*
 * Задана матрица неотрицательных чисел. Посчитать сумму элементов в каждом столбце.
 *  Определить, какой столбец содержит максимальную сумму.
 */

public class Exercise09 {

	public static void main(String[] args) {

		int n;
		int m;
		int[][] mass;

		n = enterNum("Введите количество строк n>>");
		m = enterNum("Введите количество столбцов m>>");
		mass = new int[n][m];

		iniArray(mass);
		printArray(mass);
		System.out.println();

		System.out.print("Номер столбца с максимальной суммой \t" 
							+ findColumnMaxSumm(mass));

	}

	public static int findColumnMaxSumm(int mass[][]) {

		int[] summColumn = getSummColumn(mass);

		int summMax = summColumn[0];

		int num = 0;

		for (int i = 0; i < summColumn.length; i++) {

			if (summColumn[i] > summMax) {

				summMax = summColumn[i];

				num = i;
			}

		}

		return num;

	}

	public static int[] getSummColumn(int mass[][]) {

		int summColumn[] = new int[mass[0].length];

		for (int i = 0; i < mass[0].length; i++) {

			for (int j = 0; j < mass.length; j++) {

				summColumn[i] += mass[j][i];
			}
		}

		return summColumn;
	}

	public static void iniArray(int mas[][]) {

		if (mas == null) {
			return;
		}
		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				mas[i][j] = rand.nextInt(100);
			}
		}

	}

	public static void printArray(int mas[][]) {

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				System.out.print(mas[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public static int enterNum(String message) {

		int num;

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		do {
			System.out.print(message);

			while (!scan.hasNextInt()) {
				scan.next();
				System.out.println("not an integer");
				System.out.print(message);
			}
			num = scan.nextInt();

			if (num <= 0) {
				System.out.println("enter number is not a natural");
			}

		} while (num <= 0);

		return num;

	}
}
