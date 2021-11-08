package by.jonline.modul02.arrayArray;

import java.util.Random;
import java.util.Scanner;

/*
 * Дана матрица. Вывести k-ю строку и p-й столбец матрицы. 
 */

public class Exercise03 {

	public static void main(String[] args) {

		int n;
		int m;
		int[][] matrix;
		int k;
		int p;

		n = enterNum("Введите количество строк массива n>>");
		m = enterNum("Введите количество столбцов массива m>>");				
		matrix = new int[n][m];

		iniArray(matrix);
		
		k = checkEnter(n,"Введите номер строки>>");
		System.out.println("Строка номер " + k + ":");
		
		printArrayRow(matrix, k);
		
		p =checkEnter(m,"\nВведите номер столбца>>");
		System.out.println("\nСтолбец номер " + p + ":");
		
		printArrayColumn(matrix, p);
	}
	
	
	public static int checkEnter(int x,String message) {
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

			if (num >x-1) {
				System.out.println("Вы вышли за пределы массива");
			}
		} while (num >x-1);

		return num;
	}

	public static void printArrayColumn(int mas[][], int p) {

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				if (j == p) {

					System.out.print("a[" + i + "," + j + "]= " + mas[i][j] + ";\t ");
				}
			}
			System.out.println("");
		}

	}

	public static void printArrayRow(int mas[][], int k) {

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				if (i == k) {

					System.out.print("a[" + i + "," + j + "]= " + mas[i][j] + ";\t ");
				}
			}
			// System.out.println("");
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
