package com.ankurmaurya.binarysearch.longsmallmaxmin;


import com.ankurmaurya.binarysearch.utility.Utilities;


/*
 * Minimum Operations to Reduce X to Zero
 * 
 * Type : Medium
 * 
 * 
 * You are given an integer array nums and an integer x. 
 * In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. 
 * Note that this modifies the array for future operations.
 * 
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
 * 
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,4,2,3], x = 5
 * Output: 2
 * Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 * 
 * 
 * Example 2:
 * Input: nums = [5,6,7,8,9], x = 4
 * Output: -1
 * 
 * 
 * Example 3:
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 * 
 * 
 * 
 * Constraints:
 * 1 <= nums.length <= 10 power 5
 * 1 <= nums[i] <= 10 power 4
 * 1 <= x <= 10 power 9
 * 
 * 
 * Solution :
 *  Time Complexity  : O(n) 
 *  Space Complexity : O(1)
 * 
 *  I was not able to find the correct solution and struggled for 4 days to get the solution accepted, 
 *  it was passing for some test-cases but failing for every new test-cases. After analyzing my solution 
 *  with the correct solution, I observed that my solution failed because there was no correct selection 
 *  criteria for me to pick either the left or the right number since it can have various combinations 
 *  and we can't determine how much elements we have to pick from left side and how much from the right side.
 * 
 *  However after changing the question of finding the elements to be removed to finding the sub-elements 
 *  to be kept it was easily solvable using sliding window as there was no negative elements and we can find 
 *  the sum of elements to be kept by subtracting the actual target X from Total Sum.
 *  
 *  There were many edge cases and I took good amount of time for implementation.
 * 
 */



public class MinimumOperationsReduceXToZero {

	public static void main(String[] args) {

		int[] nums0 = {5,2,3,1,1};
		int target0 = 5;
		Utilities.printElements(nums0);
		int len0 = minOperations(nums0, target0);
		System.out.println("Minimum sub-array size for Sum '" + target0 + "' is '" + (len0==1) + "'");
		System.out.println();
		
		int[] nums1 = {6016,5483,541,4325,8149,3515,7865,2209,9623,9763,4052,6540,2123,2074,765,7520,4941,5290,5868,6150,6006,6077,2856,7826,9119};
		int target1 = 31841;
		Utilities.printElements(nums1);
		int len1 = minOperations(nums1, target1);
		System.out.println("Minimum sub-array size for Sum '" + target1 + "' is '" + (len1==6) + "'");
		System.out.println();
		
		int[] nums2 = {1,1,4,2,3};
		int target2 = 5;
		Utilities.printElements(nums2);
		int len2 = minOperations(nums2, target2);
		System.out.println("Minimum sub-array size for Sum '" + target2 + "' is '" + (len2==2) + "'");
		System.out.println();
		
		int[] nums3 = {5,6,7,8,9};
		int target3 = 4;
		Utilities.printElements(nums3);
		int len3 = minOperations(nums3, target3);
		System.out.println("Minimum sub-array size for Sum '" + target3 + "' is '" + (len3==-1) + "'");
		System.out.println();
		
		int[] nums4 = {1,1};
		int target4 = 3;
		Utilities.printElements(nums4);
		int len4 = minOperations(nums4, target4);
		System.out.println("Minimum sub-array size for Sum '" + target4 + "' is '" + (len4==-1) + "'");
		System.out.println();
		
		int[] nums5 = {3,2,20,1,1,3};
		int target5 = 10;
		Utilities.printElements(nums5);
		int len5 = minOperations(nums5, target5);
		System.out.println("Minimum sub-array size for Sum '" + target5 + "' is '" + (len5==5) + "'");
		System.out.println();
		
		int[] nums6 = {10,1,1,1,1,1};
		int target6 = 5;
		Utilities.printElements(nums6);
		int len6 = minOperations(nums6, target6);
		System.out.println("Minimum sub-array size for Sum '" + target6 + "' is '" + (len6==5) + "'");
		System.out.println();
		
		int[] nums7 = {5207,5594,477,6938,8010,7606,2356,6349,3970,751,5997,6114,9903,3859,6900,7722,2378,1996,8902,228,4461,90,7321,7893,
						4879,9987,1146,8177,1073,7254,5088,402,4266,6443,3084,1403,5357,2565,3470,3639,9468,8932,3119,5839,8008,2712,2735,825,4236,
						3703,2711,530,9630,1521,2174,5027,4833,3483,445,8300,3194,8784,279,3097,1491,9864,4992,6164,2043,5364,9192,9649,9944,7230,
						7224,585,3722,5628,4833,8379,3967,5649,2554,5828,4331,3547,7847,5433,3394,4968,9983,3540,9224,6216,9665,8070,31,3555,4198,
						2626,9553,9724,4503,1951,9980,3975,6025,8928,2952,911,3674,6620,3745,6548,4985,5206,5777,1908,6029,2322,2626,2188,5639};
		int target7 = 565610;
		Utilities.printElements(nums7);
		int len7 = minOperations(nums7, target7);
		System.out.println("Minimum sub-array size for Sum '" + target7 + "' is '" + (len7==113) + "'");
		System.out.println();
		
		int[] nums8 = {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309};
		int target8 = 134365;
		Utilities.printElements(nums8);
		int len8 = minOperations(nums8, target8);
		System.out.println("Minimum sub-array size for Sum '" + target8 + "' is '" + (len8==16) + "'");
		System.out.println();
		
		int[] nums9 = {5,1,4,2,3};
		int target9 = 6;
		Utilities.printElements(nums9);
		int len9 = minOperations(nums9, target9);
		System.out.println("Minimum sub-array size for Sum '" + target9 + "' is '" + (len9==2) + "'");
		System.out.println();
		
		int[] nums10 = {1,1,99};
		int target10 = 2;
		Utilities.printElements(nums10);
		int len10 = minOperations(nums10, target10);
		System.out.println("Minimum sub-array size for Sum '" + target10 + "' is '" + (len10==2) + "'");
		System.out.println();
		
	}
	
	
	public static int minOperations(int[] nums, int x) {
		int totalSum = 0;
		for(int k=0; k<nums.length; k++) {
			totalSum += nums[k];
		}
		
		int remainingSubarrySum = totalSum - x;
		if(remainingSubarrySum<0) {
			return -1;
		}
		if(remainingSubarrySum==0) {
			return nums.length;
		}
		
		int minOperations = Integer.MAX_VALUE;
		int subarrayStartIndex = 0;
		int currentSubarraySum = 0;
		for(int i=0; i<nums.length; i++) {
			currentSubarraySum += nums[i];
            while(currentSubarraySum>remainingSubarrySum && subarrayStartIndex<nums.length) {
            	currentSubarraySum -=  nums[subarrayStartIndex];
            	subarrayStartIndex++;
			}

            if(currentSubarraySum == remainingSubarrySum) {
            	int operations = nums.length - ((i-subarrayStartIndex)+1);
            	minOperations = operations < minOperations ? operations : minOperations;
            }
		}
		
		return minOperations == Integer.MAX_VALUE ? -1 : minOperations;
	}
	
}



