package com.ankurmaurya.twopointers;

import java.util.Arrays;

import com.ankurmaurya.utils.Utilities;

/*
 * 
 * Minimum Removals to Balance Array
 * 
 * You are given an integer array nums and an integer k.
 * An array is considered balanced if the value of its maximum element is at most k times the minimum element.
 * 
 * You may remove any number of elements from nums​​​​​​​ without making it empty.
 * Return the minimum number of elements to remove so that the remaining array is balanced.
 * 
 * Note: An array of size 1 is considered balanced as its maximum and minimum are equal, and the condition always holds true.
 * 
 * Example 1:
 * Input: nums = [2,1,5], k = 2
 * Output: 1
 * 
 * Explanation:
 * Remove nums[2] = 5 to get nums = [2, 1].
 * Now max = 2, min = 1 and max <= min * k as 2 <= 1 * 2. Thus, the answer is 1.
 * 
 * 
 * Example 2:
 * Input: nums = [1,6,2,9], k = 3
 * Output: 2
 * Explanation:
 * Remove nums[0] = 1 and nums[3] = 9 to get nums = [6, 2].
 * Now max = 6, min = 2 and max <= min * k as 6 <= 2 * 3. Thus, the answer is 2.
 * 
 * 
 * Example 3:
 * Input: nums = [4,6], k = 2
 * Output: 0
 * Explanation:
 * Since nums is already balanced as 6 <= 4 * 2, no elements need to be removed.
 * 
 * 
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 105
 * 
 * 
 * Optimized:
 * Time Complexity  : O(nlogn)
 * Space Complexity : O(logn)
 * 
 * 
 */


public class MinimumRemovalstoBalanceArray {

	public static void main(String[] args) {
			
		 int[] nums1 = {1,6,2,9};
		 int k1 = 3;
		 int removedNums1 = minRemoval(nums1, k1);
		 Utilities.printElements(nums1);
		 System.out.println("To balance number of elements to be removed '" + removedNums1 + "' after multiplying min with k '" + k1 + "'");
		 
		 int[] nums2 = {2,1,5};
		 int k2 = 2;
		 int removedNums2 = minRemoval(nums2, k2);
		 Utilities.printElements(nums2);
		 System.out.println("To balance number of elements to be removed '" + removedNums2 + "' after multiplying min with k '" + k2 + "'");
		 
		 int[] nums3 = {4,6};
		 int k3 = 2;
		 int removedNums3 = minRemoval(nums3, k3);
		 Utilities.printElements(nums3);
		 System.out.println("To balance number of elements to be removed '" + removedNums3 + "' after multiplying min with k '" + k3 + "'");
		 
		 int[] nums4 = {2,4};
		 int k4 = 2;
		 int removedNums4 = minRemoval(nums4, k4);
		 Utilities.printElements(nums4);
		 System.out.println("To balance number of elements to be removed '" + removedNums4 + "' after multiplying min with k '" + k4 + "'");
		 
		 int[] nums5 = {1,34,23};
		 int k5 = 2;
		 int removedNums5 = minRemoval(nums5, k5);
		 Utilities.printElements(nums5);
		 System.out.println("To balance number of elements to be removed '" + removedNums5 + "' after multiplying min with k '" + k5 + "'");
		  
		 
		 int[] nums6 = {7,48,4,5};
		 int k6 = 4;
		 int removedNums6 = minRemoval(nums6, k6);
		 Utilities.printElements(nums6);
		 System.out.println("To balance number of elements to be removed '" + removedNums6 + "' after multiplying min with k '" + k6 + "'");
		 
		 int[] nums61 = {92,75,335,26,221,19,54};
		 int k61 = 4;
		 int removedNums61 = minRemoval(nums61, k61);
		 Utilities.printElements(nums61);
		 System.out.println("To balance number of elements to be removed '" + removedNums61 + "' after multiplying min with k '" + k61 + "'");
		
		 
		 int[] nums7 = {51,70,9,21};
		 int k7 = 2;
		 int removedNums7 = minRemoval(nums7, k7);
		 Utilities.printElements(nums7);
		 System.out.println("To balance number of elements to be removed '" + removedNums7 + "' after multiplying min with k '" + k7 + "'");
		 
	}
	
	
	
	public static int minRemoval(int[] nums, int k) {
		Arrays.sort(nums);
		int i = 0;
		int maxLen = 0;

		for (int j = 0; j < nums.length; j++) {
			// Use long to prevent integer overflow for nums[i] * k
			while ((long) nums[j] > (long) nums[i] * k) {
				i++;
			}
			maxLen = Math.max(maxLen, j - i + 1);
		}

		return nums.length - maxLen;
	}
	
}



