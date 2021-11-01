package by.jonline.modul02.decomposition;

import java.util.Scanner;

/*
 * Найти все натуральные n-значные числа, цифры в которых образуют строго возрастающую
 * последовательность (например, 1234, 5789). Для решения задачи использовать декомпозицию.
 */

public class Exercise15 {

	public static void main(String[] args) {

		int n;

		n = checkNaturalNum("Введите количество разрядов числа n>>");

		System.out.println("Все натуральные " + n 
				+ "-значные, которые образуют возврастающую последовательность:");
		getResult(n);

	}

	public static void getResult(int n) {

		int num = 1;

		for (int i = 1; i < n; i++) {
			num *= 10;
		}
		for (int j = num; j < num * 10; j++) {
			if (check(j)) {
				System.out.print(j + "; ");
			}

		}
	}

	public static boolean check(int i) {

		boolean bool = true;
		int[] x = iniArrayNum(i);

		for (int j = 0; j < x.length - 1; j++) {
			if (x[j] != x[j + 1] - 1) {
				bool = false;
			}
		}

		return bool;
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
		
		scan.close();

		return num;
		

	}
}
