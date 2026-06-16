package com.ankurmaurya.prefixsum;

import com.ankurmaurya.twopointers.utility.Utilities;


/*
 * Minimum Average Difference
 * 
 * Type : Medium
 * 
 * 
 * You are given a 0-indexed integer array nums of length n.
 * 
 * The average difference of the index i is the absolute difference between the average of 
 * the first i + 1 elements of nums and the average of the last n - i - 1 elements. 
 * Both averages should be rounded down to the nearest integer.
 * 
 * Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.
 * 
 * Note:
 * - The absolute difference of two numbers is the absolute value of their difference.
 * - The average of n elements is the sum of the n elements divided (integer division) by n.
 * - The average of 0 elements is considered to be 0.
 * 
 * 
 * Example 1:
 * Input: nums = [2,5,3,9,5,3]
 * Output: 3
 * Explanation:
 *  - The average difference of index 0 is: |2 / 1 - (5 + 3 + 9 + 5 + 3) / 5| = |2 / 1 - 25 / 5| = |2 - 5| = 3.
 *  - The average difference of index 1 is: |(2 + 5) / 2 - (3 + 9 + 5 + 3) / 4| = |7 / 2 - 20 / 4| = |3 - 5| = 2.
 *  - The average difference of index 2 is: |(2 + 5 + 3) / 3 - (9 + 5 + 3) / 3| = |10 / 3 - 17 / 3| = |3 - 5| = 2.
 *  - The average difference of index 3 is: |(2 + 5 + 3 + 9) / 4 - (5 + 3) / 2| = |19 / 4 - 8 / 2| = |4 - 4| = 0.
 *  - The average difference of index 4 is: |(2 + 5 + 3 + 9 + 5) / 5 - 3 / 1| = |24 / 5 - 3 / 1| = |4 - 3| = 1.
 *  - The average difference of index 5 is: |(2 + 5 + 3 + 9 + 5 + 3) / 6 - 0| = |27 / 6 - 0| = |4 - 0| = 4.
 * The average difference of index 3 is the minimum average difference so return 3.
 *  
 *  
 * Example 2:
 * Input: nums = [0]
 * Output: 0
 * Explanation:
 * The only index is 0 so return 0.
 * The average difference of index 0 is: |0 / 1 - 0| = |0 - 0| = 0.
 * 
 * 
 * Constraints:
 *  1 <= nums.length <= 10 power 5
 *  0 <= nums[i] <= 10 power 5
 * 
 * 
 * 
 * Solution:
 *  Time Complexity  : O(2n) = O(n)
 *   Prefix Sum - O(n)
 *   Iteration  - O(n)
 *   
 *  Space Complexity : O(n)
 *   Prefix Sum - O(n)
 * 
 * 
 * 
 */


public class MinimumAverageDifference {

	public static void main(String[] args) {
		solution(new int[] {2,5,3,9,5,3}, 3);
		solution(new int[] {0}, 0);
		solution(new int[] {5}, 0);
		solution(new int[] {7,7}, 0);
		solution(new int[] {3,3,3}, 0);
		solution(new int[] {1,2,3,4,5}, 0);
	}
	
	
	public static void solution(int[] nums,  int expectedResult) {
		Utilities.printElements(nums);
		int noOfTriplets = minimumAverageDifference(nums);
		System.out.println("Number Of triplet that can be formed is '" + noOfTriplets + "', Assert : " + (expectedResult==noOfTriplets));
		System.out.println();
	}
	
	
	 public static int minimumAverageDifference(int[] nums) {
		 long minAverageDiffrence = Integer.MAX_VALUE;
	     int minAverageDifferenceIndex = nums.length-1;
	     
		 long[] prefixSum = new long[nums.length];
		 prefixSum[0] = nums[0];
		 for(int i=1; i<nums.length; i++) {
			 prefixSum[i] = prefixSum[i-1] + nums[i];
		 }
		 
		 for(int i=0; i<=nums.length-1; i++) {
			 long firstElementsSum = prefixSum[i];
			 long lastElementsSum = prefixSum[nums.length-1] - prefixSum[i];
			 //System.out.println(firstElementsSum +", "+lastElementsSum);
			 
			 long firstElementsAvg = (firstElementsSum/(i+1));
			 long secondElementsAvg = nums.length-(i+1) == 0 ? 0 : (lastElementsSum/(nums.length-(i+1)));
			 long averageDifference = Math.abs((firstElementsAvg-secondElementsAvg));
			 //System.out.println(averageDifference + ", "+firstElementsAvg+", "+secondElementsAvg);
			 
			 if(averageDifference<=minAverageDiffrence) {
				 minAverageDifferenceIndex = averageDifference==minAverageDiffrence ? minAverageDifferenceIndex : i;
				 minAverageDiffrence = averageDifference;
			 }
		 }
		 
		 return minAverageDifferenceIndex;
	 }
	

}
