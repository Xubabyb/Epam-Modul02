
/*
 * Пусть даны две неубывающие последовательности действительных чисел a1<=a2<=...<=an
 * и b1<=b2<=..<=bn Требуется указать те места, на которые нужно вставлять элементы
 * последовательности b в первую последовательность так, чтобы новая 
 * последовательность оставалась возрастающей.
 */

package by.jonline.modul02.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercise07 {

	public static void main(String[] args) {

		int n = enterNum("Введите количество элементов не сортированного массива n>>");

		int[] a = new int[n];

		int m = enterNum("Введите количество элементов не сортированного массива m>>");

		int[] b = new int[m];

		iniArray(a);

		Arrays.sort(a);

		iniArray(b);

		Arrays.sort(b);

		System.out.println(Arrays.toString(a));

		System.out.println(Arrays.toString(b));

		getIndex(a,b);
		// a = insertionSortArray(a, b);

		// System.out.println(Arrays.toString(a));

	}

	public static void getIndex(int[] a, int[] b) {

		int index;

		for (int x : b) {

			index = binarySearch(a, x);

			System.out.println("Место в массиве а элемента массива в = " + x + "; - " + index);
			a = Arrays.copyOf(a, a.length + 1);

			for (int i = a.length - 1; i > index; i--) {

				a[i] = a[i - 1];
			}

			a[index] = x;

		}
		}


	public static int binarySearch(int[] a, int x) {

		int start = 0;
		int finish = a.length - 1;
		int midle = -1;
		boolean flag = true;

		if (x >= a[a.length - 1]) {
			return a.length;
		}

		while (flag) {

			flag = finish - start != 1 ? true : false;

			midle = (finish + start) / 2;

			if (a[midle] == x) {
				return midle;
			} else if (x < a[midle]) {
				finish = midle;
			} else {
				if (x < a[midle + 1]) {

					return midle + 1;
				}
				start = midle;
			}
		}
		return midle;
	}

	public static int enterNum(String message) {

		int num;

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

		System.out.print(message);
		do {
			while (!scan.hasNextInt()) {

				scan.nextLine();

				System.out.println(" number is not integer");

				System.out.print(message);
			}

			num = scan.nextInt();

			if (num <= 0) {
				System.out.println("number is not natural");
			}
		} while (num <= 0);

		return num;
	}

	public static void iniArray(int[] mass) {

		if (mass == null) {
			return;
		}

		Random rand = new Random();

		for (int i = 0; i < mass.length; i++) {

			mass[i] = rand.nextInt(100);
		}
	}

}
