package by.jonline.modul02.array;

import java.util.Scanner;

/*
 * Дан целочисленный массив с количеством элементов п. 
 * Сжать массив, выбросив из него каждый второй элемент 
 * (освободившиеся элементы заполнить нулями).
 * Примечание. Дополнительный массив не использовать
 */

public class Exercise10 {

	public static void main(String[] args) {

		int[] a;
		int n;

		n = checkEnter("Введите количество элементов массива n>>");
		a = arrayRandom(n);

		arrayPrint(getResult(a), "a");
	}

	public static int[] getResult(int[] x) {

		for (int i = 1; i < x.length; i += 2) {
			x[i] = 0;
		}

		return x;
	}

	public static void arrayPrint(int[] x, String y) {

		for (int i = 0; i < x.length; i++) {
			System.out.print(y + "[" + i + "]= " + x[i] + "; ");
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
