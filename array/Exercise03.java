package by.jonline.modul02.array;

import java.util.Scanner;

/*
 * Дан  массив  действительных  чисел,  размерность  которого N.  
 * Подсчитать,  сколько  в  нем  отрицательных, положительных и нулевых элементов
 */

public class Exercise03 {

	public static void main(String[] args) {

		int n;
		double[] a;

		n = checkEnter("Введите количество элементов массива n>>");
		a = enterArray(n, "a");

		getResult(a);

	}

	public static void getResult(double[] x) {

		int count_1;
		int count_2;
		int count_3;

		count_1 = 0;
		count_2 = 0;
		count_3 = 0;

		for (int i = 0; i < x.length; i++) {

			if (x[i] == 0) {
				count_1++;
			} else if (x[i] > 0) {
				count_2++;
			} else {
				count_3++;
			}
		}

		System.out.println("Количество элементов равных 0 : " + count_1 + ";");
		System.out.println("Количество положительных элементов : " + count_2 + ";");
		System.out.println("Количество отрицательных элементов : " + count_3 + ";");

	}

	public static double[] enterArray(int n, String y) {

		double[] x;

		x = new double[n];

		for (int i = 0; i < n; i++) {

			x[i] = checkElement(y + "[" + i + "]>>");
		}
		return x;
	}

	@SuppressWarnings("resource")
	public static double checkElement(String message) {

		Scanner scan;

		scan = new Scanner(System.in);

		System.out.print(message);
		while (!scan.hasNextDouble()) {
			scan.next();
			System.out.println(message);
		}

		return scan.nextDouble();
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
