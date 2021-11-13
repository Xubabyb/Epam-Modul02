
/*
 * Сортировка выбором. Дана последовательность чисел a1<=a2<=....<=an
 * Требуется переставить элементы так, чтобы они были расположены по убыванию. 
 * Для этого в массиве, начиная с первого, выбирается наибольший элемент 
 * и ставится на первое место, а первый - на место наибольшего. 
 * Затем, начиная со второго, эта процедура повторяется. 
 * Написать алгоритм сортировки выбором.
 */

package by.jonline.modul02.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercise03 {

	public static void main(String[] args) {

		int n = enterNum("Введите количество элементов массива n>>");

		int[] a = new int[n];

		iniArray(a);

		Arrays.sort(a);

		System.out.println(Arrays.toString(a));

		sortDescending(a);

		System.out.println(Arrays.toString(a));

	}

	public static void swap(int[] mass, int j, int index) {

		int temp = mass[j];
		mass[j] = mass[index];
		mass[index] = temp;
	}

	public static void sortDescending(int[] mass) {

		for (int j = 0; j < mass.length; j++) {

			int indexMinNumber = j;

			for (int i = 0; i < mass.length; i++) {

				if (mass[i] < mass[indexMinNumber]) {

					indexMinNumber = i;

				}
				swap(mass, j, indexMinNumber);
			}
		}
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
