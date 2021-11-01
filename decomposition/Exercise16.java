package by.jonline.modul02.decomposition;

import java.util.Scanner;

/*
 * Написать программу, определяющую сумму n - значных чисел, содержащих только нечетные цифры.
 * Определить также, сколько четных цифр в найденной сумме. Для решения задачи использовать декомпозицию.
 */

public class Exercise16 {

	public static void main(String[] args) {

		byte n;
		int summ;

		n = enterNum("Введите количество разрядов числа n>>");
		summ = summ(getStartPoint(n));

		System.out.println("Сумма " + n + "-значных чисел, содержащих только нечетные цифры = " + summ);
		System.out.print("Количество четных цифр в найденной сумме = " + check(summ));

	}

	public static int summ(int num) {

		int summ = 0;

		for (int i = num; i < num * 10; i++) {
			if (check(i) == 0) {
				summ += i;
			}
		}
		return summ;
	}

	public static int check(int i) {

		int count = 0;
		int[] x = iniArrayNum(i);

		for (int j : x) {
			if (j % 2 == 0) {
				count += 1;
			}
		}

		return count;
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

	public static int getStartPoint(byte n) {

		int num = 1;

		for (int i = 1; i < n; i++) {
			num *= 10;
		}
		return num;
	}

	public static byte enterNum(String message) {

		byte num;

		Scanner scan = new Scanner(System.in);

		do {
			System.out.print(message);

			while (!scan.hasNextByte()) {
				scan.next();
				System.out.println("not an integer");
				System.out.print(message);
			}
			num = scan.nextByte();

			if (num <= 0) {
				System.out.println("enter number not a natural");
			} else if (num > 7) {
				System.out.println("Очень много разрядов, возможно расплавление процессора ");
			}
		} while (num <= 0 || num > 7);

		scan.close();

		return num;

	}
}
