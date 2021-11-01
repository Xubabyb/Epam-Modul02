package by.jonline.modul02.decomposition;

import java.util.Scanner;

/*
 * Составить программу, которая в массиве A[n] находит второе по величине число
 * (вывести на печать число, которое меньше максимального, 
 * но больше всех других элементов).
 */

public class Exercise05 {

	public static void main(String[] args) {

		int n;
		int[] a;
		int result;
		int numberResult;

		n = checkEnter("Введите количество элементов массива n>>");
		a = arrayRandom(n);
		result = a[0];
		numberResult = 0;
		
		// arrayPrint(a,"a");

		for (int i = 0; i < n; i++) {
			if (a[i] > result && a[i] != a[indexMax(a)]) {
				result = a[i];
				numberResult = i;
			}
		}

		System.out.println("Значение второго по величине элемент массива " + result);
		System.out.println("Индекс  этого элемента массива " + numberResult);

	}

	public static int indexMax(int[] x) {

		int max;
		int maxX;

		max = 0;
		maxX = x[0];

		for (int j = 0; j < x.length; j++) {
			if (x[j] > maxX) {
				maxX = x[j];
				max = j;
			}
		}

		return max;
	}

	public static void arrayPrint(int[] x, String y) {

		for (int i = 0; i < x.length; i++) {
			System.out.print(y + "[" + i + "]= " + x[i] + ";");
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
