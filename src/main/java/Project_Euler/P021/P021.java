/**
 * 
 */
package Project_Euler.P021;
/**
 * https://projecteuler.net/problem=21
 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author vinod<vinodpal458@gmail.com
 */
public class P021 {

	public static void main(String... args) {
		Set<Pair> amicablNumbers = getAmicableNumbers(10000);
		List sortedList = new ArrayList(amicablNumbers);
		Collections.sort(sortedList,Pair.pairComparator);
		sortedList.forEach((pair) -> System.out.println(pair));
	}

	/**
	 * @param i
	 * @return
	 */
	private static Set<Pair> getAmicableNumbers(int rangeOfNumbers) {
		Set<Pair> listOfAmicableNumbers = new HashSet<Pair>();
		int sumOfDivisors = 0;
		Pair pair = null;
		for (int itr = 1; itr < rangeOfNumbers; ++itr) {
			sumOfDivisors = getSumOfDivisors(itr);
			if(getSumOfDivisors(sumOfDivisors)==itr){
				pair = new Pair(sumOfDivisors,itr);
				listOfAmicableNumbers.add(pair);
			}
		}
		return listOfAmicableNumbers;
	}
	
	private static int getSumOfDivisors(int num){
		int sumOfDivisors = 0;
		if(num==1)return 1;
		for(int n=1 ; n<=(num/2);++n){
			if((num%n)==0)
				sumOfDivisors+=n;
		}
		return sumOfDivisors;
	}
	
	
}

class Pair implements Comparator{
	private Integer firstNumber;
	private Integer secondNumber;
	Pair(){}
	public Pair(Integer firstNumber, Integer secondNumber){
		setFirstNumber(firstNumber);
		setSecondNumber(secondNumber);
	}
	public Integer getFirstNumber() {
		return firstNumber;
	}
	public void setFirstNumber(Integer firstNumber) {
		this.firstNumber = firstNumber;
	}
	public Integer getSecondNumber() {
		return secondNumber;
	}
	public void setSecondNumber(Integer secondNumber) {
		this.secondNumber = secondNumber;
	}
	@Override
	public String toString(){
		return "FirstNumber : "+getFirstNumber() +" , SecondNumber : "+getSecondNumber();
	}
	
	public int compare(Object o1, Object o2) {
		Pair obj1 = (Pair) o1;
		Pair obj2 = (Pair) o2;
		if (obj1.getFirstNumber() > obj2.getFirstNumber())
			return 1;
		else if (obj1.getFirstNumber() < obj2.getFirstNumber())
			return -1;
		else
			return 0;
	}

	
	public static Comparator<Pair> pairComparator = new Comparator<Pair>(){

		@Override
		public int compare(Pair o1, Pair o2) {
			return o1.getFirstNumber().compareTo(o2.firstNumber);
		}
		
	};
}
