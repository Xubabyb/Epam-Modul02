package by.jonline.modul02.array;

import java.util.Scanner;

/*
 *  В массив A[N] занесены натуральные числа.
 *   Найти сумму тех элементов, которые кратны данному К.
 */

public class Exercise01 {

	public static void main(String[] args) {

		int[] a;
		int n;
		int k;

		n = checkEnter("Введите количество элементов массива n>>");
		a = arrayRandom(n);
		k = checkEnter("Введите число k>>");

		arrayPrint(a, "a");
		System.out.print("\n Сумма элементов массива кратных  " + k);
		System.out.println(", будет равна " + getResult(a, k)+";");
	}

	public static void arrayPrint(int[] x, String y) {

		for (int i = 0; i < x.length; i++) {
			System.out.print(y + "[" + i + "]= " + x[i] + ";");
		}
	}

	public static int getResult(int[] x, int y) {

		int result;

		result = 0;

		for (int i = 0; i < x.length; i++) {

			if (x[i] % y == 0) {
				result += x[i];
			}
		}
		return result;

	}

	public static int[] arrayRandom(int n) {

		int[] x;

		x = new int[n];

		for (int i = 0; i < n; i++) {
			x[i] = (int) (Math.random() * 100);

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
