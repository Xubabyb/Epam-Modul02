package by.jonline.modul02.decomposition;

import java.util.Scanner;

/*
 * Вычислить площадь правильного шестиугольника со стороной а, используя 
 * метод вычисления площади треугольника.
 */

public class Exercise03 {

	public static void main(String[] args) {

		double a;

		a = checkEnter("Введите a>>");

		System.out.format("Площадь правильного шестиугольника с стороной a = %s будет %.2f", a, square(a) * 6);
	}

	public static double square(double a) {

		return Math.pow(a, 2) * Math.sqrt(3) / 4;

	}

	@SuppressWarnings("resource")
	public static double checkEnter(String message) {

		Scanner scan;

		scan = new Scanner(System.in);

		System.out.print(message);

		while (!scan.hasNextDouble()) {
			scan.next();
			System.out.print(message);
		}

		return scan.nextDouble();
	}
}
