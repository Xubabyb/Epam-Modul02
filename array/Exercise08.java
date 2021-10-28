package by.jonline.modul02.array;

import java.util.Scanner;

/*
 *   Дана  последовательность  целых  чисел (a1,a2...n).  Образовать  новую  последовательность,  выбросив  из исходной те члены,
 *    которые равны min(a1,a2...n).
 */

public class Exercise08 {

	public static void main(String[] args) {

		int[] a;
		int n;

		n = checkEnter("Введите количество элементов массива n>>");
		a = enterArray(n, "a");

		arrayPrint(getResult(a), "a");

	}

	public static int[] getResult(int[] x) {

		int[] y;
		int xMin;
		int count;
		int j;

		j = 0;
		count = 0;
		xMin = x[indexMin(x)];

		for (int i = 0; i < x.length; i++) {

			if (x[i] == xMin) {
				count += 1;
			}
		}

		y = new int[x.length - count];

		for (int i = 0; i < x.length; i++) {

			if (x[i] != xMin) {
				y[j] = x[i];
				j++;
			}
		}

		return y;
	}

	public static void arrayPrint(int[] x, String y) {

		for (int i = 0; i < x.length; i++) {
			System.out.print(y + "[" + i + "]= " + x[i] + "; ");
		}
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

	public static int[] enterArray(int n, String y) {

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
