
/*
 * Сортировка вставками. Дана последовательность чисел a1,a2....an.
 * Требуется переставить числа в порядке возрастания.
 * Делается это следующим образом. Пусть a1,a2..ai упорядоченная последовательность,
 * т. е. a1<=a2<=...<=ai  Берется следующее число ai+1 и вставляется в 
 * последовательность так, чтобы новая последовательность была тоже возрастающей.
 * Процесс производится до тех пор, пока все элементы от i +1 до n не будут перебраны.
 *  Примечание. Место помещения очередного элемента в отсортированную часть производить
 *   с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
 */

package by.jonline.modul02.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercise05 {

	public static void main(String[] args) {

		int[] a = new int[] { 11, 34, 78, 56, 8, 26 };

		int m = enterNum("Введите количество элементов не сортированного массива m>>");

		int[] b = new int[m];

		Arrays.sort(a);

		iniArray(b);

		System.out.println(Arrays.toString(a));

		System.out.println(Arrays.toString(b));

		a = insertionSortArray(a, b);

		System.out.println(Arrays.toString(a));

	}

	public static int[] insertionSortArray(int[] a, int[] b) {

		int index;

		for (int x : b) {

			index = binarySearch(a, x);

			a = Arrays.copyOf(a, a.length + 1);

			for (int i = a.length - 1; i > index; i--) {

				a[i] = a[i - 1];
			}

			a[index] = x;

		}

		return a;
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
