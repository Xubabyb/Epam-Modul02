
/*
 * Заданы два одномерных массива с различным количеством элементов и натуральное число k. 
 * Объединить их в один массив, включив второй массив между k-м и (k+1) - м элементами
 *  первого, при этом не используя дополнительный массив.
 */

package by.jonline.modul02.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner; 

public class Exercise01 {

	public static void main(String[] args) {

		int n1 = enterNum("Введите количество элементов 1-го массива n1>>");

		int n2 = enterNum("Введите количество элементов 2-го массива n2>>");

		int[] a1 = new int[n1];

		int[] a2 = new int[n2];

		iniArray(a1);

		iniArray(a2);

		arrayPrint(a1, "a1");

		System.out.println();

		arrayPrint(a2, "a2");

		System.out.println();

		int k = checkNum(n1);

		a1 = Arrays.copyOf(a1, n1 + n2);

		System.arraycopy(a1, k + 1, a1, n2 + k + 1, n1 - (k + 1));

		System.arraycopy(a2, 0, a1, k + 1, n2);

		System.out.println(Arrays.toString(a1));

	}

	public static void arrayPrint(int[] x, String y) {

		for (int i = 0; i < x.length; i++) {
			System.out.print(y + "[" + i + "]= " + x[i] + "; ");
		}
	}

	public static int checkNum(int n) {

		int k;

		while (true) {

			k = enterNum("Введите номер элемента после которого начнется сортировка k>>");

			if (k > n - 1) {

				System.out.println("Значение к превышает размер 1-го массива");
			} else
				break;
		}
		return k;
	}

	public static int enterNum(String message) {

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

	public static void iniArray(int mas[]) {

		if (mas == null) {
			return;
		}
		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {

			mas[i] = rand.nextInt(100);

		}

	}

}
