package by.jonline.modul02.decomposition;

import java.util.Scanner;

/*
 * Даны натуральные числа К и N. Написать метод(методы)формирования массива А,
 *  элементами которого являются числа, 
 * сумма цифр которых равна К и которые не большее N.
 */

public class Exercise12 {

	public static void main(String[] args) {

		int k;
		int n;

		k = checkNaturalNum("Введите значение для K>>");
		n = checkNaturalNum("Введите значение для N>>");

		System.out.println("Количество элементов в массиве = " + getCount(n, k));
		arrayPrint(getResult(getCount(n, k), k, n), "a");
	}

	public static void arrayPrint(int[] x, String y) {

		for (int i = 0; i < x.length; i++) {
			System.out.print(y + "[" + i + "]= " + x[i] + "; ");
		}
	}

	public static int[] getResult(int count, int k, int n) {

		int[] a;
		int j;

		a = new int[count];
		j = 0;

		for (int i = 1; i <= n; i++) {
			
			if (checkSumm(k, i)) {
				a[j] = i;
				j++;
			}
		}

		return a;
	}

	public static int getCount(int n, int k) {

		int count;

		count = 0;

		for (int i = 1; i <= n; i++) {
			if (checkSumm(k, i)) {
				count += 1;
			}
		}

		return count;
	}

	public static boolean checkSumm(int k, int x) {

		String str;
		int[] a;
		int summ;

		str = String.valueOf(x);
		a = new int[str.length()];
		summ = 0;

		for (int i = str.length() - 1; i >= 0; i--) {

			if (i == 0) {
				a[i] = x;

			} else {
				a[i] = x % 10;
				x = x / 10;
			}
		}
		for (int i = 0; i < str.length(); i++) {
			summ += a[i];
		}

		return summ == k ? true : false;

	}

	@SuppressWarnings("resource")
	public static int checkNaturalNum(String message) {

		int num;
		Scanner scan;

		scan = new Scanner(System.in);

		do {
			System.out.print(message);

			while (!scan.hasNextInt()) {
				scan.next();
				System.out.println("not an integer");
				System.out.print(message);
			}
			num = scan.nextInt();

			if (num <= 0) {
				System.out.println("enter number not a natural");
			}
		} while (num <= 0);

		return num;

	}
}
