package by.jonline.modul02.decomposition;

import java.util.Scanner;

/*
 * Два простых числа называются «близнецами», если они отличаются 
 * друг от друга на 2 (например, 41 и 43). Найти и напечатать все 
 * пары «близнецов» из отрезка [n,2n], где n-заданное натуральное число больше 2.
 * Для решения задачи использовать декомпозицию.
 */

public class Exercise13 {

	public static void main(String[] args) {

		int n;

		n = checkNaturalNum("Ввведите значение начала отрезка n>>");

		getResult(n);
	}

	public static void getResult(int n) {

		int count;

		count = 0;

		for (int i = n; i <= n * 2; i++) {

			if (checkSimple(i) & checkSimple(i + 2)) {
				System.out.print("Найдена пара близнецов: ");
				System.out.println("(" + i + ";" + (i + 2) + "); ");
				count++;
			}
		}
		if (count == 0) {
			System.out.println("Пар близнецов не найдено");
		}

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

			if (num <= 2) {
				System.out.println("Не соответствуют условию, значение должно быть >2");
			}
		} while (num <= 2);

		return num;

	}

	public static boolean checkSimple(int x) {

		for (int i = 2; i < x; i++) {

			if (x % i == 0) {
				return false;
			}
		}

		return (x > 1);
	}
}
