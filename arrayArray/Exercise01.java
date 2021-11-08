package by.jonline.modul02.arrayArray;

import java.util.Random;
import java.util.Scanner;

/*
 * Дана матрица. Вывести на экран все нечетные столбцы, у которых первый элемент 
 * больше последнего.
 */

public class Exercise01 {

	public static void main(String[] args) {

		int n;
		int m;
		int[][] matrix;

		n = enterNum("Введите количество строк массива n>>");
		m = enterNum("Введите количество столбцов массива m>>");
		matrix = new int[n][m];

		iniArray(matrix);

		printArray(matrix);

		System.out.println("Нечетные столбцы в которых первый элемент больше последнего:");

		printOddColumn(matrix);

	}

	public static void printOddColumn(int mas[][]) {

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				if (j % 2 != 0 && mas[0][j] > mas[mas.length - 1][j]) {

					System.out.print("a[" + i + "," + j + "]= " + mas[i][j] + ";\t ");
				}
			}
			System.out.println();
		}
	}

	public static void printArray(int mas[][]) {

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				System.out.print("a[" + i + "," + j + "]= " + mas[i][j] + ";\t ");
			}
			System.out.println();
		}

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
				System.out.println("enter number not a natural");
			}
		} while (num <= 0);

		return num;

	}

}
