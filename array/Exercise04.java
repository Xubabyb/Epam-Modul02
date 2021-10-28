package by.jonline.modul02.array;

import java.util.Scanner;

/*
 * Даны действительные числа а1,а2,..., аn. 
 * Поменять местами наибольший и наименьший элементы.
 */

public class Exercise04 {

	public static void main(String[] args) {

		int n;
		double[] a;

		n = checkEnter("Введите количество элементов массива n>>");
		a = enterArray(n, "a");
		

		System.out.println("Начальный  массив чисел");

		arrayPrint(a, "a");

		System.out.println("\n Обработанный массив чисел");

		getResultSwap(a, "a");
	}

	public static void getResultSwap(double[] x, String y) {

		int indexMin;
		int indexMax;
		double temp;

		indexMin = indexMin(x);
		indexMax = indexMax(x);

		temp = x[indexMin];
		x[indexMin] = x[indexMax];
		x[indexMax] = temp;

		arrayPrint(x, "a");

	}

	public static void arrayPrint(double[] x, String y) {

		for (int i = 0; i < x.length; i++) {
			System.out.print(y + "[" + i + "]= " + x[i] + "; ");
		}
	}

	public static int indexMin(double[] x) {

		int min;
		double minX;

		min = 0;
		minX = x[0];

		for (int j = 0; j < x.length; j++) {
			if (x[j] < minX) {
				minX = x[j];
				min = j;
			}
		}

		return min;
	}

	public static int indexMax(double[] x) {

		int max;
		double maxX;

		max = 0;
		maxX = x[0];

		for (int j = 0; j < x.length; j++) {
			if (x[j] > maxX) {
				maxX = x[j];
				max = j;
			}
		}

		return max;
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
