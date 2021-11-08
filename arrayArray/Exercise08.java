package by.jonline.modul02.arrayArray;

import java.util.Scanner;

/*
 * В числовой матрице поменять местами два столбца любых столбца, т. е. 
 * все элементы одного столбца поставить на соответствующие им позиции другого,
 *  а его элементы второго переместить в первый. Номера столбцов вводит
 * пользователь с клавиатуры.
 */

public class Exercise08 {

	public static void main(String[] args) {

		int a[][] = new int[][] { { 1, 2, 3, 5 }, { 6, 6, 6, 9 }, { 3, 2, 1, 3 } };
		int swap1;
		int swap2;

		System.out.println("Исходный массив");
		printArray(a);

		swap1 = enterNum("Введите номер столбца который нужно заменить >>", a[0].length);
		swap2 = enterNum("Введите номер столбца на который нужно заменить >>", a[0].length);

		rebuildArray(a, swap1, swap2);

		System.out.println("Перестроенный массив");
		printArray(a);

	} 

	public static int enterNum(String message, int x) {

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

			if (num < 0) {
				System.out.println("enter number is not a natural");
			}
			if (num > x - 1) {
				System.out.println("this column does not exist");
			}
		} while (num < 0 || num > x - 1);

		return num;

	}

	public static void rebuildArray(int mas[][], int swap1, int swap2) {

		int[] swap_1 = iniArrayColumn(mas, swap1);
		int[] swap_2 = iniArrayColumn(mas, swap2);

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				if (j == swap1) {

					mas[i][j] = swap_2[i];

				} else if (j == swap2) {

					mas[i][j] = swap_1[i];
				}

			}
		}
	}

	public static int[] iniArrayColumn(int mas[][], int x) {

		int[] column = new int[mas.length];

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				if (j == x) {

					column[i] = mas[i][j];
				}
			}
		}
		return column;
	}

	public static void printArray(int mas[][]) {

		for (int i = 0; i < mas.length; i++) {

			for (int j = 0; j < mas[i].length; j++) {

				System.out.print(mas[i][j] + "\t");
			}
			System.out.println();
		}

	}
}
