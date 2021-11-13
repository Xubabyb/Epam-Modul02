
/*
 * Дан массив n действительных чисел. Требуется упорядочить его по возрастанию.
 * Делается это следующим образом: сравниваются два соседних элемента ai ai+1.
 * Если ai<=ai+1, то продвигаются на один элемент вперед. Если ai>ai+1?
 * то производится перестановка и сдвигаются на один элемент назад.
 * Составить алгоритм этой сортировки.
 */

package by.jonline.modul02.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercise06 {

	public static void main(String[] args) {

		int n = enterNum("Введите количество элементов массива n>>");

		int[] a = new int[n];

		iniArray(a);

		System.out.println(Arrays.toString(a));
		
		shellSortArray(a);
		
		System.out.println(Arrays.toString(a));
	}

	public static void shellSortArray(int[] a) {

		int step = a.length / 2;

		while (step >= 1) {

			for (int i = 0; i < a.length; i++) {

				for (int j = i - step; j >= 0; j -= step) {

					if (a[j] > a[j + step])

						swap(a, j, j + step);
				}
			}
			step = step / 2;
		}
	}

	public static void swap(int[] mass, int j, int index) {

		int temp = mass[j];
		mass[j] = mass[index];
		mass[index] = temp;
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
