package by.jonline.modul02.arrayArray;

import java.util.Random;
import java.util.Scanner;

/*
 * Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали.
 */

public class Exercise02 {

	public static void main(String[] args) {

		int n;
		int[][] matrix;

		n = enterNum("Введите количество размер квадратной матрицы n>>");
		matrix = new int[n][n];

		iniArray(matrix);

		System.out.println("Элементы стоящие на диагонали:");
		printArrayD(matrix);

	}

	public static void printArrayD(int mas[][]) {

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {
				if (i == j) {

					System.out.print("a[" + i + "," + j + "]= " + mas[i][j] + "; ");
				}
			}
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

		scan.close();

		return num;

	}
}
