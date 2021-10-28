package by.jonline.modul02.array;

import java.util.Scanner;

/*
 * В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число.
 *  Если таких чисел несколько, то определить наименьшее из них.
 */

public class Exercise09 {

	public static void main(String[] args) {

		int[] a;
		int n;

		n = checkEnter("Введите количество элементов массива n>>");
		a = enterArray(n, "a");

		System.out.print("Наименьший из наиболее часто встречаемых элементов = ");
		System.out.println(getResult(arrayCountRepeat(a), a) + ";");
	}

	public static int getResult(int[] y, int[] x) {

		int yMax;
		int result;

		yMax = y[0];
		result = x[0];

		for (int i = 0; i < y.length; i++) {

			if (yMax < y[i]) {
				yMax = y[i];
				result = x[i];
			} else if (yMax == y[i] && result > x[i]) {
				result = x[i];
			}
		}

		return result;
	}

	public static int[] arrayCountRepeat(int[] x) {

		int[] y;
		int j;
		int count;

		j = 0;
		y = new int[x.length];

		while (j < x.length) {

			count = -1;

			for (int i = 0; i < x.length; i++) {

				if (x[j] == x[i]) {
					count += 1;
					y[j] = count;
				}
			}
			j++;
		}

		return y;
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
