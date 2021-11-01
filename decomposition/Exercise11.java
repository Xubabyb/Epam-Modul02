package by.jonline.modul02.decomposition;

import java.util.Scanner;

/*
 * Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр.
 */

public class Exercise11 {

	public static void main(String[] args) {

		int num_1;
		int num_2;

		num_1 = checkNaturalNum("Введите первое число >>");
		num_2 = checkNaturalNum("Введите второе число >>");

		System.out.println(getResult(num_1, num_2));
	}

	public static String getResult(int x, int y) {

		String strNum_1;
		String strNum_2;

		strNum_1 = String.valueOf(x);
		strNum_2 = String.valueOf(y);

		if (strNum_1.length() > strNum_2.length()) {
			return "В первом числе цифр больше";
		} else if (strNum_1.length() == strNum_2.length()) {
			return "Количество цифр одинаковое";
		}

		return "Во втором числе цифр больше";

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
