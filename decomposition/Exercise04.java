package by.jonline.modul02.decomposition;

import java.util.Scanner;

/*
 * На плоскости заданы координатами n точек. Написать метод (методы), определяющие
 * между какими точками из пар точек самое большое расстояние.
 * Координаты точек занести в массив.
 */

public class Exercise04 {

	public static void main(String[] args) {

		int n;
		int[] x; // массив абсцисс
		int[] y; // массив ординат

		n = checkEnter("Введите n>>");
		x = arrayEnter(n, "x");
		y = arrayEnter(n, "y");

		System.out.println("Самое больше расстояние будет между точками с координатами:");

		if (length(x, y) > length(y, x)) {

			System.out.println(x[indexMin(x)] + ";" + y[indexMin(x)] + " и " + x[indexMax(x)] + ";" + y[indexMax(x)]);

		} else {

			System.out.println(x[indexMin(y)] + ";" + y[indexMin(y)] + " и " + x[indexMax(y)] + ";" + y[indexMax(y)]);

		}

	}

	public static double length(int[] x, int[] y) {

		double l;
		int max;
		int min;

		max = indexMax(x);
		min = indexMin(x);

		l = Math.sqrt(Math.pow(Math.abs(x[max] - x[min]), 2) + Math.pow(Math.abs(y[max] - y[min]), 2));

		return Math.round(l * 100.0) / 100.0;
	}

	public static int indexMin(int[] x) {

		int min;
		int minX;

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

	public static int indexMax(int[] x) {

		int max;
		int maxX;

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

	public static int[] arrayEnter(int n, String y) {

		int[] x;

		x = new int[n];

		for (int i = 0; i < n; i++) {

			x[i] = checkEnter(y + "[" + i + "]>>");

		}

		return x;
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
