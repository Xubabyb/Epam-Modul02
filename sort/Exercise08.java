
/*
 * Даны дроби p1/q1 , p2/q2 .... pn/qn (pi ,qi -  натуральные). Составить программу, 
 * которая приводит эти дроби к общему знаменателю и упорядочивает их
 * в порядке возрастания.
 */

package by.jonline.modul02.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exercise08 {

	public static void main(String[] args) {

		int n = enterNum("Введите количество дробей n>>");

		int[] p = new int[n]; // числители
		int[] q = new int[n]; // знаменатели

		iniArray(p);

		iniArray(q);

		print(p, q);

		leadToCommonDenominator(p, q);

		Arrays.sort(p);

		print(p, q);
	}

	public static void leadToCommonDenominator(int[] p, int[] q) {

		int lcm = commonDenominator(q);

		System.out.println("Общий знаменатель_" + lcm);

		for (int i = 0; i < p.length; i++) {

			p[i] = p[i] * lcm / q[i];

			q[i] = lcm;
		}

	}

	public static void print(int[] p, int[] q) {

		for (int i = 0; i < p.length; i++) {

			System.out.print(p[i] + "/" + q[i] + ", ");
		}

		System.out.println("");

	}

	public static int commonDenominator(int[] mass) {

		int num = mass[0];

		int lcm = num;

		for (int i = 1; i < mass.length; i++) {

			lcm = num * mass[i] / gcd(num, mass[i]);

			num = lcm;
		}

		return lcm;
	}

	public static int gcd(int x1, int x2) {

		if (x1 < x2) {
			return gcd(x2, x1);
		}
		if (x2 == 0) {
			return Math.abs(x1);
		}
		return gcd(x2, x1 % x2);

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

			mass[i] = rand.nextInt(10);
			if (mass[i] == 0) {
				i--;
			}
		}
	}
}
