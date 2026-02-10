package com.ankurmaurya.binarysearch.ceilfloor;


/*
 * 
 * Arranging Coins
 * You have n coins and you want to build a staircase with these coins. 
 * The staircase consists of k rows where the ith row has exactly i coins. 
 * The last row of the staircase may be incomplete.
 * 
 * Given the integer n, return the number of complete rows of the staircase you will build.
 * 
 * Constraints:
 * 1 <= n <= 2power31 - 1
 * 
 * 
 * Input: n = 5
 * Output: 2
 * Explanation: Because the 3rd row is incomplete, we return 2.
 * 
 * Input: n = 8
 * Output: 3
 * Explanation: Because the 4th row is incomplete, we return 3.
 * 
 * 
 */


public class ArrangingCoins {

	public static void main(String[] args) {
		for(int i=1; i<211; i++) {
			int noOfCompletedRows = arrangeCoins(i);
			long sumofNelements = ((long)i*(i+1))/2;
			System.out.println(sumofNelements + " - Number of completed rows with '" + i +"' coins is '"+ noOfCompletedRows + "'");
		}
	}
	
	
	public static int arrangeCoins(int n) {
		int l=1;
		int h=n;
	
		int m = -1;
		while(l<=h) {
			m = l + (h-l)/2;
			long sumofNelements = (long)m*(m+1)/2;
			
			if(sumofNelements>n) {
				h=m-1;
			} 
			else {
				l=m+1;
			}
		}

		return m;
	}

}
