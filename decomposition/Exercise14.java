package by.jonline.modul02.decomposition;

import java.util.Scanner;

/*
 * Натуральное  число,  в  записи  которого n цифр,  называется  числом  Армстронга,
 *   если  сумма  его  цифр, возведенная в степень n, равна самому числу. 
 *   Найти все числа Армстронга от 1 до k.
 *   Для решения задачи использовать декомпозицию.
 */

public class Exercise14 {

	public static void main(String[] args) {

		int k;

		k = checkNaturalNum("Введите число k>>");

		getResult(k);

	}

	public static void getResult(int x) {

		for (int i = 1; i < x; i++) {

			if (arm(i)) {
				System.out.print(i + "; ");
			}
		}

	}

	public static boolean arm(int i) {

		int summ = 0;
		int []x = iniArrayNum(i);

		for (int j : x) { // улучшенный for

			summ += Math.pow(j, x.length);
		}

		return (summ == i ? true : false);
	}

	public static int[] iniArrayNum(int i) {

		String str = String.valueOf(i);
		int[] x = new int[str.length()];

		for (int j = str.length() - 1; j >= 0; j--) {

			if (i == 0) {
				x[0] = i;
			}

			x[j] = i % 10;
			i /= 10;
		}

		return x;
	}

	public static int checkNaturalNum(String message) {

		int num;
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

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
