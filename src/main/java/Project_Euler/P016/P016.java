/**
 * @author vinod<vinodpal458@gmail.com
 */
package Project_Euler.P016;

import java.math.BigInteger;

/*2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
What is the sum of the digits of the number 2^1000?*/


public class P016 {
	
	public static void main(String [] args){
			System.out.println((new P016()).getSumDigitsPowerOfTwo(1000));
	}
	
	long getSumDigitsPowerOfTwo(int power){
		BigInteger powerOfTwo = new BigInteger("2");
		powerOfTwo = powerOfTwo.pow(power);
		String str = powerOfTwo.toString();
		long sum=0;
		//Iterate digits
		for(int i=0;i<str.length();++i){
			sum+=Character.getNumericValue(str.charAt(i));
		}
		//System.out.println(powerOfTwo);
		return sum;
	}
	
}
