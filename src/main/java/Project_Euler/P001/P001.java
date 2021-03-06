/**
 * 
 */
package Project_Euler.P001;
/**
 * @author vinod<vinodpal458@gmail.com
 */
/*If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.*/
public class P001 {

	public static void main(String[] args) {
		System.out.println(sumMulti(15));
	}

	public static long sumMulti(long number) {
		long countMultiThree = number / 3L;
		long sumOfThreeMulti = ((countMultiThree * (countMultiThree + 1L)) / 2L) *3L;
		long countMultiFive = number / 5L;
		long sumOfFiveMulti = ((countMultiFive * (countMultiFive + 1L)) / 2L) * 5L;
		long countMultiFiffty = number / 15L;
		long sumOfFifftyMulti = ((countMultiFiffty * (countMultiFiffty + 1L)) / 2L) * 15L;
		return (sumOfThreeMulti + sumOfFiveMulti - sumOfFifftyMulti);
		
	}
	

}