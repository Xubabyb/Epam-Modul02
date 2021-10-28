package by.jonline.modul02.array;

import java.util.Scanner;

/*
 * Даны действительные числа a1, a2 ....an. Найти мах {a1+a2n, a2+a2n-1....an+an+1}
 */

public class Exercise07 {

	public static void main(String[] args) {

		double[] a;
		int n;

		n = checkEnter("Введите количество элементов массива n>>");
		a = enterArray(n, "a");

		System.out.println("сумма = " + getResult(a, n));

	}

	public static double getResult(double[] x, int n) {

		double result;
		int temp_1;
		int temp_2;

		temp_1 = 0;
		temp_2 = n - 1;

		result = 0;

		for (int i = 0; i < n / 2; i++) {

			if ((x[i] + x[n - 1 - i]) > result) {

				result += x[i] + x[n - 1 - i];
				temp_1 = i;
				temp_2 = n - 1 - i;

			}
		}
		System.out.println("Масксимальная сумма будет сумма элементов с индексами " 
				+ temp_1 + "; " + temp_2);

		
		return result;
	}

	public static double[] enterArray(int n, String y) {

		double[] x;

		x = new double[n];

		for (int i = 0; i < n; i++) {

			x[i] = checkElement(y + "[" + i + "]>>");
		}
		return x;
	}

	@SuppressWarnings("resource")
	public static double checkElement(String message) {

		Scanner scan;

		scan = new Scanner(System.in);

		System.out.print(message);
		while (!scan.hasNextDouble()) {
			scan.next();
			System.out.println(message);
		}

		return scan.nextDouble();
	}

	@SuppressWarnings("resource")
	public static int checkEnter(String message) {

		Scanner scan;

		scan = new Scanner(System.in);

		System.out.print(message);
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println(message);
		}

		return scan.nextInt();
	}
}
