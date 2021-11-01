package by.jonline.modul02.decomposition;

import java.util.Scanner;

/* 
 * Написать метод (методы) для нахождения наибольшего общего делителя четырех
 * натуральных чисел. 
 */

public class Exercise02 {

	public static void main(String[] args) {

		int a;
		int b;
		int c;
		int d;

		a = checkNaturalNum("Введите a>>");
		b = checkNaturalNum("Введите b>>");
		c = checkNaturalNum("Введите c>>");
		d = checkNaturalNum("Введите d>>");

		System.out.println("НОД чисел " + a + " " + b + " " + c + " " + d + " = " 
							+ gcd(gcd(gcd(a, b), c), d));
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

	@SuppressWarnings("resource")
	public static int checkNaturalNum(String message) {

		int num;
		Scanner scan;

		scan = new Scanner(System.in);

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
}
