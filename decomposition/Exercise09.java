package by.jonline.modul02.decomposition;

import java.util.Scanner;

/*
 * Даны числа X, Y, Z, Т —длины сторон четырехугольника.
 *  Написать метод(методы) вычисленияего площади,
 *  если угол между сторонами длиной X и Y—прямой.
 */

public class Exercise09 {

	public static void main(String[] args) {

		double x;
		double y;
		double z;
		double t;

		x = checkEnter("x>>");
		y = checkEnter("y>>");
		z = checkEnter("z>>");
		t = checkEnter("t>>");

		System.out.print("Площадь четырехугольника = ");
		System.out.println(squareTriangle(x, y) + squareGeron(tPifagor(x, y), z, t));
	}

	public static double squareGeron(double a, double b, double c) {

		double p;

		p = (a + b + c) * 0.5;

		return Math.sqrt(p * (p - a) * (p - b) * (p - c));

	}

	public static double squareTriangle(double a, double b) {

		return 0.5 * a * b;
	}

	public static double tPifagor(double a, double b) {

		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
	}

	@SuppressWarnings("resource")
	public static double checkEnter(String message) {

		Scanner scan;

		scan = new Scanner(System.in);

		System.out.print(message);
		while (!scan.hasNextDouble()) {
			scan.next();
			System.out.println(message);
		}

		return scan.nextDouble();
	}
}
