package by.jonline.modul02.arrayArray;

import java.util.Random;
import java.util.Scanner;

/*
 * Отсортировать строки матрицы по возрастанию и убыванию значений элементов.
 */

public class Exercise12 {

	public static void main(String[] args) {

		int n;
		int m;
		int[][] matrix;

		n = enterNum("Введите количество строк массива n>>");
		m = enterNum("Введите количество столбцов массива m>>");
		matrix = new int[n][m];

		System.out.println("Исходный массив:");
		
		iniArray(matrix);
		printArray(matrix);

		System.out.println("Отсортированный массив с элементами строки по убыванию:");
		
		matrix = findMaxAndSort(matrix);
		printArray(matrix);

		System.out.println("Отсортированный массив с элементами строки по возрастанию:");
		
		matrix = findMinAndSort(matrix);
		printArray(matrix);

	}

	public static int[][] findMinAndSort(int mas[][]) {

		int temp;
		int count = 0;

		while (count < mas[0].length - 1) {

			for (int i = 0; i < mas.length; i++) {

				for (int j = count; j < mas[i].length; j++) {

					if (mas[i][j] < mas[i][count]) {

						temp = mas[i][count];

						mas[i][count] = mas[i][j];

						mas[i][j] = temp;
					}

				}

			}
			count++;
		}

		return mas;
	}

	public static int[][] findMaxAndSort(int mas[][]) {

		int temp;
		int count = 0;

		while (count < mas[0].length - 1) {

			for (int i = 0; i < mas.length; i++) {

				for (int j = count; j < mas[i].length; j++) {

					if (mas[i][j] > mas[i][count]) {

						temp = mas[i][count];

						mas[i][count] = mas[i][j];

						mas[i][j] = temp;
					}

				}

			}
			count++;
		}

		return mas;
	}

	public static void printArray(int mas[][]) {

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				System.out.print(mas[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public static void iniArray(int mas[][]) {

		if (mas == null) {
			return;
		}
		Random rand = new Random();

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				mas[i][j] = rand.nextInt(100);
			}
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
				System.out.println("enter number not a natural");
			}
		} while (num <= 0);

		return num;

	}

}
