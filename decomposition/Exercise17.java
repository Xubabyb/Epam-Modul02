package by.jonline.modul02.decomposition;

import java.util.Scanner;

/*
 * Из заданного числа вычли сумму его цифр. Из результата вновь вычли сумму его цифр и т.д. 
 * Сколько таких действий надо произвести, чтобы получился нуль? Для решения задачи использовать декомпозицию.
 */

public class Exercise17 {

	public static void main(String[] args) {

		int n;
		int count;
		int summ;

		n = checkEnter("Введите целое число n>>");
		count = 0;
		summ = summ(iniArrayNum(n));

		System.out.print("Для уменьшения числа " + n + " до нуля понадобится ");
		System.out.print(getResult(summ, n, count));
		System.out.println(" действий");
	}

	public static int getResult(int summ, int n, int count) {

		int temp;

		if (n != 0) {
			temp = n - summ;
			count += 1;
			return getResult(summ(iniArrayNum(temp)), temp, count);

		} else {

			return count;
		}

	}

	public static int summ(int[] x) {
		
		int summ = 0;
		
		for (int i : x) {
			summ += i;
		}
		
		return summ;
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

	public static int checkEnter(String message) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.print(message);

		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println(message);
		}

		return scan.nextInt();
	}

}
