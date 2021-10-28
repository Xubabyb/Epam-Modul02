package by.jonline.modul02.array;

import java.util.Scanner;

/*
 * Задана последовательность N вещественных чисел. 
 * Вычислить сумму чисел, порядковые номера которых являются простыми числами
 */

public class Exercise06 {

	public static void main(String[] args) {

		double[] a;
		int n;

		n = checkEnter("Введите количество элементов массива n>>");
		a = enterArray(n, "a");

		System.out.println("Сумма элементов массива у которых " 
		+ "\n порядковые номера простые числа = " + getResult(a));
	}

	public static boolean checkSimple(int x) {

		for (int i = 2; i < x; i++) {

			if (x % i == 0) {
				return false;
			}
		}

		return (x > 1);
	}

	public static double getResult(double[] x) {

		double result;

		result = 0;

		for (int i = 0; i < x.length; i++) {

			if (checkSimple(i)) {
				result += x[i];
			}
		}

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
