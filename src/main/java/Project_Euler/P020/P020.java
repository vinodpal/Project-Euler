/**
 * https://projecteuler.net/problem=20
 
 */

/**
 * @author vinod<vinodpal458@gmail.com
 */
package Project_Euler.P020;

public class P020 {
	public static void main(String... strings) {
		int max = 500;
		int digits[] = new int[max];
		int divident, factor, currentDigit, reminder;
		factor = 2;
		digits[0] = 1;
		while (factor < 101) {
			reminder = 0;
			for (int i = 0; i < 6; ++i) {
				divident = digits[i] * factor + reminder;
				reminder = 0;
				if (divident > 9) {
					currentDigit = divident % 10;
					reminder = divident / 10;
				} else
					currentDigit = divident;
				digits[i] = currentDigit;
			}
			++factor;
		}

		int sum = 0;
		for (int i = max - 1; i >= 0; --i) {
			sum += digits[i];
		}
		System.out.println(sum);
	}
}
