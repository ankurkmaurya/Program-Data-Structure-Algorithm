package com.ankurmaurya.prefixsum.hashmap;


import java.util.HashMap;
import java.util.Map;

import com.ankurmaurya.twopointers.utility.Utilities;

/*
 * Subarray Sum Equals K
 * 
 * Type : Medium
 * 
 * 
 * Given an array of integers nums and an integer k, 
 * return the total number of subarrays whose sum equals to k.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * 
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * 
 * 
 * Constraints:
 * 1 <= nums.length <= 2 * 10 power 4
 * -1000 <= nums[i] <= 1000
 * -10 power 7 <= k <= 10 power 7
 * 
 * 
 * 
 * Solution;
 *  Time Complexity  : O(n)
 *  Space Complexity : O(n)
 *   - For maintaining the HashTable
 * 
 *  I was not able to find solution and then saw the editorial for the solution.
 *  
 *  My Approach : As it was the Sub-array Sum problem, I thought that sliding window will work here
 *   and then went on to write the code and it was also working for few test cases but it was failing 
 *   for test cases where there was negative number and then I realized, I haven't seen the constraints 
 *   and started working on the solution which was bad and finally realized even if I had seen the constraints 
 *   I was not able to find the solution because i was not knowing the limitations of the Sliding window
 *   where it does not works for negative and positive mixed numbers.
 *  
 *  Learnings : Prefix-Sum and Hash-map technique is efficient to find reliable and correct solution for
 *   Sub-array sum problems having negative numbers here (CurrentSum - Target = Prefix Sum Element) equation
 *   can give the result for counting the number of Sub-array with Sum equals to target.
 *   
 * 
 */



public class SubarraySumEqualsK {

	public static void main(String[] args) {
		
		 solution(new int[]{1,1,1}, 2, 2);
		 solution(new int[]{1,2,3}, 3, 2);
		 solution(new int[]{-1,-1,1}, 0, 1);
		 solution(new int[]{1}, 0, 0);
		 solution(new int[]{1,-1,0}, 0, 3);
		 solution(new int[]{1,2,1,2,1}, 3, 4);

	}
	
	public static void solution(int[] nums, int k, int expectedResult) {
		Utilities.printElements(nums);
		int noOfSubarrays = subarraySum(nums, k);
		System.out.println("Number of Subarrays : " + noOfSubarrays + ", Assert : " + (noOfSubarrays == expectedResult));
		System.out.println();
	}
	
	
	public static int subarraySum(int[] nums, int k) {
		int noOfSubarray = 0;
		
		Map<Integer, Integer> prefixDict = new HashMap<>();
		prefixDict.put(0, 1);
		int prefixSum = 0;
		for(int p=0; p<nums.length; p++) {
			prefixSum += nums[p];
			
			if(prefixDict.containsKey(prefixSum-k)) {
				noOfSubarray += prefixDict.get(prefixSum-k);
			}
			
			if(prefixDict.containsKey(prefixSum)){
				int cnt = prefixDict.get(prefixSum);
				prefixDict.put(prefixSum, ++cnt);
			} else {
				prefixDict.put(prefixSum, 1);
			}
		}
		return noOfSubarray;
	}

}


