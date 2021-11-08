package by.jonline.modul02.arrayArray;

import java.util.Scanner;

/*
 * Сформировать квадратную матрицу порядка N по правилу: A[I,J] = sin (I*I-J*J)/N
 * и подсчитать количество положительных элементов в ней.
 */

public class Exercise07 {

	public static void main(String[] args) {

		int n;
		double a[][];

		n = enterNum("Введите четное число n>>");
		a = new double[n][n];

		iniArray(a);
		printArray(a);
		System.out.print("Количество положительных элементов в массиве : ");
		System.out.println(countPositivElement(a));

	}

	public static int countPositivElement(double mas[][]) {

		int count = 0;

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				if (mas[i][j] > 0) {
					count++;
				}
			}
		}
		return count;
	}

	public static void iniArray(double mas[][]) {

		if (mas == null) {
			return;
		}

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				mas[i][j] = Math.round(Math.sin((i * i - j * j) / mas.length) * 1000) / 1000.0;

			}
		}
	}

	public static void printArray(double mas[][]) {

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
			if (num % 2 != 0) {
				System.out.println("number is odd");
			}
		} while (num <= 0 || num % 2 != 0);

		return num;

	}
}
