package com.ankurmaurya.math;


/*
 * Pow(x, n)
 * 
 * Type : Medium
 * 
 * 
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x power n).
 * 
 * Example 1:
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 * 
 * Example 2:
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 * 
 * Example 3:
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * 
 * 
 * Constraints:
 *  -100.0 < x < 100.0
 *  -2 power 31 <= n <= 2 power 31 -1
 *  n is an integer.
 *  Either x is not zero or n > 0.
 *  -10power4 <= x power n <= 10power4
 * 
 * 
 * 
 * Solution: Fast Exponentiation.
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 * 
 * 
 */




public class PowOfXToN {

	public static void main(String[] args) {
		
		double x1 = 2.00000;
		int n1 = 10;
		double power1 = myPow(x1, n1);
		System.out.println("'" + x1 + "' to the power '" + n1 + "' is '" + power1 + "'");
		System.out.println("");

		double x2 = 2.10000;
		int n2 = 3;
		double power2 = myPow(x2, n2);
		System.out.println("'" + x2 + "' to the power '" + n2 + "' is '" + power2 + "'");
		System.out.println("");

		double x3 = 2.00000;
		int n3 = -2;
		double power3 = myPow(x3, n3);
		System.out.println("'" + x3 + "' to the power '" + n3 + "' is '" + power3 + "'");
		System.out.println("");

		double x4 = 2.00000;
		int n4 = -200000000;
		double power4 = myPow(x4, n4);
		System.out.println("'" + x4 + "' to the power '" + n4 + "' is '" + power4 + "'");
		System.out.println("");

		double x5 = 1.00000;
		int n5 = 2147483647;
		double power5 = myPow(x5, n5);
		System.out.println("'" + x5 + "' to the power '" + n5 + "' is '" + power5 + "'");
		System.out.println("");
		
		double x6 = 2.00000;
		int n6 = -2147483648;
		double power6 = myPow(x6, n6);
		System.out.println("'" + x6 + "' to the power '" + n6 + "' is '" + power6 + "'");
		System.out.println("");
		
		double x7 = 34.00515;
		int n7 = -3;
		double power7 = myPow(x7, n7);
		System.out.println("'" + x7 + "' to the power '" + n7 + "' is '" + power7 + "'");
		System.out.println("");
		
	}
	
	
	public static double myPow(double x, int n) {
		long N = n; // convert to long to handle Integer.MIN_VALUE
	    if (N < 0) {
	        x = 1 / x;
	        N = -N;
	    }

	    double result = 1.0;
	    while (N > 0) {
	        // If the current bit is 1, multiply result by x
	        if ((N & 1) == 1) {
	            result *= x;
	        }
	        // Square x for the next bit
	        x *= x;
	        // Shift N right (divide by 2)
	        N >>= 1;
	    }

	    return result;
	}

}




