
/*
 * (Пузырьковая сортировка)
 * Сортировка обменами. Дана последовательность чисел a1<=a2<=...<=an
 * Требуется переставить числа в порядке возрастания. Для этого сравниваются два 
 * соседних числа ai + ai+1. Если ai>ai+1, то делается перестановка. Так 
 * продолжается до тех пор, пока все элементы не станут расположены в порядке 
 * возрастания.Составить алгоритм сортировки, подсчитывая при этом 
 * количества перестановок. 
 *          БАГ В СПЕКЕ  ПОСЛЕДОВАТЕЛЬНОСТЬ ДАНА В ПОРЯДКЕ
 *                         ВОЗРАСТАН�?Я!!!  
 */

package by.jonline.modul02.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercise04 {

	public static void main(String[] args) {

		int n = enterNum("Введите количество элементов массива n>>");

		int[] a = new int[n];

		iniArray(a);

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

		int count1 = 0;
		int count2 = 0;
		boolean flag = true;

		while (flag) {

			flag = false;

			for (int i = 0; i < mass.length - 1; i++) {

				if (mass[i] > mass[i + 1]) {

					swap(mass, i + 1, i);

					count2++;

					flag = true;

				}
			}
			count1++;
		}
		System.out.println("Количество итераций массива " + count1 + "\nКоличество перестановок " + count2);

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
