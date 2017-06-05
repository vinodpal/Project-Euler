/**
 * @author vinod<vinodpal458@gmail.com
 */
package Project_Euler.P004;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class P004 {
	public static void main(String[] args) {
		(new P004()).pla("14345");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String pla(String numer) {
		int len = numer.length();
		/*System.out.println(len + "  :  " + (len >> 1));*/
		int index = 0;
		boolean flag = true;
		StringBuilder sb= new StringBuilder(numer);
		System.out.println(sb.toString());
		while (index < (len >> 1)) {
			// System.out.println(numer.charAt((len >> 1) - index - 1) + " : " +
			// (numer.charAt((len >> 1) + index+((len&1)==1?1:0))));
			int n1 = Character.getNumericValue(numer.charAt((len >> 1) - index - 1));
			int n2 = Character.getNumericValue((numer.charAt((len >> 1) + index + ((len & 1) == 1 ? 1 : 0))));
			System.out.println(n1 + " : " + n2);
			if (flag && (n1 > n2) ){
				flag = false;
				sb.setCharAt((len >> 1) - index - 1, (numer.charAt((len >> 1) + index + ((len & 1) == 1 ? 1 : 0))));
				// n1 -> n2;
			} else {
				sb.setCharAt((len >> 1) + index + ((len & 1) == 1 ? 1 : 0), numer.charAt((len >> 1) - index - 1));
				// n1 <- n2
			}
			++index;
		}
		System.out.println(sb.toString());
		return null;
	}
}
