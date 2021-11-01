package by.jonline.modul02.decomposition;

/*
 * Написать метод для вычисления суммы факториалов всех нечетных чисел от 1 до 9
 */

public class Exercise07 {

	public static void main(String[] args) {

		System.out.println(getSummFactorial(9, 0));

	}

	public static int getSummFactorial(int x, int y) {
		if (x < 1) {
			
			return y;
		}
		
		y += getFactorial(x);
		
		return getSummFactorial(x - 2, y);
	}

	public static int getFactorial(int f) {
		if (f <= 1) { // условие выхода из рекурсии
			return 1;
		} else {
			return f * getFactorial(f - 1);// следующее захождение в метод
		}
	}
}
