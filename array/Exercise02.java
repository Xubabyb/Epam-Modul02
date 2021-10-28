package by.jonline.modul02.array;

import java.util.Scanner;

/*
 * Дана последовательность действительных чисел а1,а2 ,..., ап.
 *  Заменить все ее члены, большие данного Z, этим числом.
 *  Подсчитать количество замен
 */
public class Exercise02 {

	public static void main(String[] args) {

		int n;
		int[] a;
		int z;

		n = checkEnter("Введите количество элементов массива n>>");
		a = arrayRandom(n);
		z = checkEnter("Введите число z>>");

		System.out.println("\n количество замен равно " + getResult(a, z));

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

			if (x[i] > y) {
				x[i] = y;
				result++;
			}
		}
		arrayPrint(x, "a");

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
