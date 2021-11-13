
/*
 *  Даны две последовательности a1<=a2<=a3<=an и b1<=b2<=b3<=bn.
 * Образовать из них новую последовательность
 * чисел так, чтобы она тоже была неубывающей. Примечание. 
 * Дополнительный массив не использовать.
 */

package by.jonline.modul02.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercise02 {

	public static void main(String[] args) {

		int na = enterNum("na>>");
		int nb = enterNum("nb>>");

		int[] a = new int[na];
		int[] b = new int[nb];

		iniArray(a);
		
		Arrays.sort(a);
		
		System.out.println(Arrays.toString(a));
		
		iniArray(b);
		
		Arrays.sort(b);
		
		System.out.println(Arrays.toString(b));
		
		a = Arrays.copyOf(a, na + nb);
		
		System.arraycopy(b, 0, a, na, nb);
		
		Arrays.sort(a);
		
		System.out.println(Arrays.toString(a));

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
