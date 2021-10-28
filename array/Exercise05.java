package by.jonline.modul02.array;

import java.util.Scanner;

/*
 * Даны целые числа а1,а2 ,..., аn. 
 * Вывести на печать только те числа, для которых аi> i.
 */

public class Exercise05 {

	public static void main(String[] args) {

		int[] a;
		int n;

		n = checkEnter("Введите количество элементов массива n>>");
		a = enterArray(n, "a");

		getResult(a, "a");

	}

	public static void getResult(int[] x, String y) {

		for (int i = 0; i < x.length; i++) {

			if (x[i] > i) {
				System.out.print(y + "[" + i + "]= " + x[i] + "; ");
			}
		}
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
