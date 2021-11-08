package by.jonline.modul02.arrayArray;

import java.util.Random;
import java.util.Scanner;

/*
 * Матрицу 10x20 заполнить случайными числами от 0 до 15. 
 * Вывести на экран саму матрицу и номера строк, в
 * которых число 5 встречается три и более раз.
 */

public class Exercise11 {

	public static void main(String[] args) {

		int[][] matrix;

		matrix = new int[10][20];

		iniArray(matrix);

		printArray(matrix);
		
		System.out.println("Номера строк в которых цифра 5 встречается более трех раз:");

		getResult(matrix);
	}

	public static void getResult(int mas[][]) {

		int[] count = new int[mas.length];

		for (int i = 0; i < mas.length; i++) {

			int numCount = 0;

			for (int j = 0; j < mas[i].length; j++) {

				if (mas[i][j] == 5) {

					numCount++;
				}
			}
			count[i] = numCount;

			if (count[i] >= 3) {

				System.out.print(i + "\t");
			}
		}

	}

	public static void iniArray(int mas[][]) {

		if (mas == null) {
			return;
		}
		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				mas[i][j] = rand.nextInt(15);
			}
		}

	}

	public static void printArray(int mas[][]) {

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				System.out.print(mas[i][j] + "\t");
			}
			System.out.println();
		}

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
				System.out.println("enter number is not a natural");
			}

		} while (num <= 0);

		return num;

	}
}
