package by.jonline.modul02.arrayArray;

import java.util.Scanner;

/*
 * Магическим квадратом порядка n называется квадратная матрица размера n x n, 
 * составленная из чисел 1, 2, 3,...n*n, так, что суммы по каждому столбцу,
 *  каждой строке и каждой из двух больших диагоналей равны между
 * Построить такой квадрат.  
 */

public class Exercise16 {

	public static void main(String[] args) {

		int n;
		n = enterNum("Введите магического порядок квадрата нечетное число n>>");

		// Создаем матрицу порядка 2n-1 и инициализируем внутри нее 
		//ступенчатый ромб со стороной n элементов.
		int[][] result = createArrayRhombus(n);

		packLeftPartRhombus(result);  // Упаковываем левую вершину ромба в квадрат
		packRigthPartRhombus(result); // Упаковываем правую вершину ромба в квадрат
		packUpPartRhombus(result);    // Упаковываем верхнюю вершину ромба в квадрат
		packDownPartRhombus(result);  // Упаковываем нижнюю вершину ромба в квадрат

		result = destroyNull(result, n); //Убираем лишние нули.

		printArray(result); // получаем результат

	}

	public static int[][] destroyNull(int a[][], int n) {

		int[][] result = new int[n][n];
		int x = 0;
		int y;
		int temp = 0;

		for (int i = 0; i < a.length; i++) {

			y = 0;

			for (int j = 0; j < a.length; j++) {

				if (a[i][j] != 0) {

					result[x][y] = a[i][j];
					temp += result[x][y];
					y++;
				}

			}
			if (temp != 0) {
				x++;
			}
		}
		return result;
	}

	public static void packDownPartRhombus(int a[][]) {

		for (int i = a.length - 1; i > (a.length - 1) * 3 / 4; i--) {

			for (int j = (a.length - 1) / 4 + 1; j < (a.length - 1) * 3 / 4; j++) {

				if (a[i][j] != 0) {

					int temp = a[i][j];
					a[i - (a.length + 1) / 2][j] = temp;
					a[i][j] = 0;
				}
			}

		}
	}

	public static void packUpPartRhombus(int a[][]) {

		for (int i = 0; i < (a.length - 1) / 4; i++) {

			for (int j = (a.length - 1) / 4 + 1; j < (a.length - 1) * 3 / 4; j++) {

				if (a[i][j] != 0) {

					int temp = a[i][j];
					a[i + (a.length + 1) / 2][j] = temp;
					a[i][j] = 0;
				}
			}

		}
	}

	public static void packRigthPartRhombus(int a[][]) {

		for (int i = (a.length - 1) / 4 + 1; i < (a.length - 1) * 3 / 4; i++) {

			for (int j = a.length - 1; j > (a.length - 1) * 3 / 4; j--) {

				if (a[i][j] != 0) {

					int temp = a[i][j];
					a[i][j - (a.length + 1) / 2] = temp;
					a[i][j] = 0;
				}
			}
		}
	}

	public static void packLeftPartRhombus(int a[][]) {

		for (int i = (a.length - 1) / 4 + 1; i < (a.length - 1) * 3 / 4; i++) {

			for (int j = 0; j < (a.length - 1) / 4; j++) {

				if (a[i][j] != 0) {

					int temp = a[i][j];
					a[i][j + (a.length + 1) / 2] = temp;
					a[i][j] = 0;
				}
			}
		}
	}

	public static int[][] createArrayRhombus(int n) {

		int[][] a = new int[2 * n - 1][2 * n - 1];

		int num = 0;
		int start = (a.length - 1) / 2;
		int finish = 0;
		int count = 0;

		while (start != a.length) {
			int j = num;
			for (int i = start; i >= finish; i--) {
				a[i][j] = ++count;
				j++;
			}
			start += 1;
			finish += 1;
			num += 1;
		}
		return a;
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
			if (num % 2 == 0) {
				System.out.println("number is even");
			}
		} while (num <= 0 || num % 2 == 0);

		return num;
	}
}