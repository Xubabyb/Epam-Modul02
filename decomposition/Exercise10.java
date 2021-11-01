package by.jonline.modul02.decomposition;

import java.util.Scanner;

/*
 * Дано  натуральное  число N. Написать  метод(методы)для  формирования  массива,  
 * элементами  которого являются цифры числа N.
 */

public class Exercise10 {

	public static void main(String[] args) {

		int n;

		n = checkNaturalNum("Введите натуральное число n>>");

		arrayPrint(buildArray(n), "a");

	}

	public static int[] buildArray(int x) {

		int[] a;
		String number;

		number = String.valueOf(x);
		a = new int[number.length()];

		for (int i = number.length() - 1; i >= 0; i--) {

			if (i == 0) {
				a[i] = x;

			} else {
				a[i] = x % 10;
				x = x / 10;
			}
		}

		return a;
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

	public static void arrayPrint(int[] x, String y) {

		for (int i = 0; i < x.length; i++) {
			System.out.print(y + "[" + i + "]= " + x[i] + "; ");
		}
	}
}