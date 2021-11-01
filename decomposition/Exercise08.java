package by.jonline.modul02.decomposition;

import java.util.Scanner;

/*
 * Задан массив D. Определить следующие суммы:D[l] + D[2] + D[3]; D[3] + D[4] + D[5]; D[4] +D[5] +D[6].
 * Пояснение. Составить метод(методы)для вычисления суммы трех последовательно расположенных 
 * элементов массива с номерами от k до m.
 */

public class Exercise08 {

	public static void main(String[] args) {

		int[] d;
		int n;

		n = checkEnter("Введите количество элементов массива n>>");
		d = arrayRandom(n);

		getResult(d);

	}

	public static int summ(int[] x, int k, int m) {

		int summ;

		summ = 0;

		for (int i = k; i <= m; i++) {
			summ += x[i];
		}

		return summ;
	}

	public static void getResult(int[] x) {

		int k;
		int m;

		k = checkEnter("Введите индекс начального элемента k>>");

		if (k > x.length - 1) {
			System.out.println("Вы вышли за предела массива");
		} else if (k == x.length - 1) {
			System.out.println("Начало отрезка приходится на последний элемент массива");
			System.out.println("Сумма равна последнему элементу массива " + x[x.length - 1]);
		} else if (k + 2 > x.length - 1) {
			m = x.length - 1;
			System.out.print("Результат будет равен сумме двух последних элементов " + summ(x, k, m));
		} else {
			m = k + 2;
			System.out.print("Сумма элементов массива c " + k + " по " + m + " = " + summ(x, k, m));
		}

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
