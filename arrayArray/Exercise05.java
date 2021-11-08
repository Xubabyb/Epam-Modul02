package by.jonline.modul02.arrayArray;

import java.util.Scanner;

/*
 * Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * {1 1 1 ......1}
 * {2 2 2 ......0}
 * {3 3 3 ....0 0}
 * {n-1 n-1 0 ..0}
 * {n 0 0 0 ....0}
 */

public class Exercise05 {

	public static void main(String[] args) {

		int n;
		int a[][];

		n = enterNum("Введите четное число n>>");
		a = new int[n][n];

		iniArray(a);
		printArray(a);

	}

	public static void iniArray(int mas[][]) {

		if (mas == null) {
			return;
		}

		int count;

		for (int i = 0; i < mas.length; i++) {

			count = mas[i].length - i;

			for (int j = 0; j < count; j++) {

				mas[j][i] = j + 1;
			}
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
			if (num % 2 != 0) {
				System.out.println("number is odd");
			}
		} while (num <= 0 || num % 2 != 0);

		return num;

	}
}
