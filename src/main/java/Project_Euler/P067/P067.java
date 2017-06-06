package Project_Euler.P067;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * https://projecteuler.net/problem=67
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.

3
7 4
2 4 6
8 5 9 3

That is, 3 + 7 + 4 + 9 = 23.

Find the maximum total from top to bottom in triangle.txt (right click and 'Save Link/Target As...'), a 15K text file containing a triangle with one-hundred rows.

NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it would take over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
 */

/**
 * @author vinod<vinodpal458@gmail.com
 */
public class P067 {

	public static void main(String... strings) {
		int[][] araay = readFile();
		if (araay != null) {
			int row = araay.length - 2;
			int column = 0;
			for (; row >= 0; --row) {
				for (column = 0; araay[row][column] != 0; ++column) {
					araay[row][column] += Math.max(araay[row + 1][column], araay[row + 1][column + 1]);
				}

			}
			System.out.println(araay[0][0]);
		}
	}

	private static int[][] readFile() {
		int[][] araay = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					new File("/home/devnew/DO/Project-Euler/src/main/java/Project_Euler/P067/inputFile")));
			String[] line = br.readLine().split(" ");
			System.out.println(br.lines());
			araay = new int[1012][1012];
			int i = 0, j = 0;
			try {
				while (line != null) {
					j = 0;
					for (int itr = 0; itr < line.length; ++itr) {
						araay[i][j++] = Integer.parseInt(line[itr]);
					}
					++i;
					line = br.readLine().split(" ");
				}
			} catch (Exception exception) {
				System.out.println(exception.toString());
			}

			for (i = 0; i < araay.length; ++i) {
				for (j = 0; j < araay.length && araay[i][j] != 0; ++j) {
					System.out.print(araay[i][j] + " ");
				}
				System.out.println();
			}
		} catch (Exception exception) {
			System.out.println(exception.toString());
		}
		return araay;
	}

}
