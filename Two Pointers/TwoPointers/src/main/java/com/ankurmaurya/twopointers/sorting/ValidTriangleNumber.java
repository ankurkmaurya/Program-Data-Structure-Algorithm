package com.ankurmaurya.twopointers.sorting;

import java.util.Arrays;

import com.ankurmaurya.twopointers.utility.Utilities;



/*
 * Valid Triangle Number
 * 
 * Type : Medium
 * 
 * Given an integer array nums, return the number of triplets chosen from the array 
 * that can make triangles if we take them as side lengths of a triangle.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,2,3,4]
 * Output: 3
 * Explanation: Valid combinations are: 
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * 
 * Example 2:
 * Input: nums = [4,2,3,4]
 * Output: 4
 * 
 * 
 * Constraints:
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * 
 * 
 * Solution:
 * 
 * First Solution -  
 *  Time Complexity: 
 *   Sorting    - O(nlogn)
 *   Iterations - O(n * n-2 * logn) = O(n^2 * logn)
 * 
 *  Space Complexity:
 *   Sorting    - O(log n)
 *  
 *  
 * Second Solution -  
 *  Time Complexity: 
 *   Sorting    - O(nlogn)
 *   Iterations - O(n*(n-2)) = O(n^2)
 * 
 *  Space Complexity:
 *   Sorting    - O(log n)
 * 
 * 
 */





public class ValidTriangleNumber {
	
	public static void main(String[] args) {
		solution(new int[] {2,2,3,4}, 3);
		solution(new int[] {4,2,3,4}, 4);
		solution(new int[] {1,2}, 0);
		solution(new int[] {1}, 0);
		solution(new int[] {1,2,3}, 0);
		solution(new int[] {1,2,4}, 0);
		solution(new int[] {1,2,2}, 1);
		solution(new int[] {1,4,3}, 0);
		solution(new int[] {2,5,6}, 1);
		
	}	
	
	public static void solution(int[] nums,  int expectedResult) {
		Utilities.printElements(nums);
		int noOfTriplets = triangleNumberSecondSolution(nums);
		System.out.println("Number Of triplet that can be formed is '" + noOfTriplets + "', Assert : " + (expectedResult==noOfTriplets));
		System.out.println();
	}
	
	public static int triangleNumberFirstSolution(int[] nums) {
	    int numberOfTriplets = 0;
	    if(nums.length<3) {
	    	return 0;
	    }
	    
	    Arrays.sort(nums);

	    for(int i=0; i<nums.length-1; i++) {
	    	int firstTuple = nums[i];
	    	
	    	int secondTupleIndex = i+1;
	    	while(secondTupleIndex < nums.length-1) {
	    		int secondTuple = nums[secondTupleIndex];
	    		
	    		int thirdTupleIndex = -1;
	    		int low = secondTupleIndex+1;
	    		int high = nums.length-1;
	    		while(low<=high) {
	    			int mid = low + (high-low)/2;
	    			if((firstTuple+secondTuple)>nums[mid]) {
	    				thirdTupleIndex = mid;
	    				low = mid+1;
	    			} else {
	    				high = mid-1;
	    			}
	    		}
	    		
	    		if(thirdTupleIndex>-1) {
	    			numberOfTriplets += thirdTupleIndex-secondTupleIndex;
	    		}
	    		secondTupleIndex++;
	    	}
	    }
	    
	    return numberOfTriplets;
	}
	
	public static int triangleNumberSecondSolution(int[] nums) {
	    int numberOfTriplets = 0;
	    if(nums.length<3) {
	    	return 0;
	    }
	    
	    Arrays.sort(nums);
	    
	    for(int i=nums.length-1; i>=2; i--) {
	    	int left = 0;
	    	int right = i-1;
	    	
	    	while(left<right) {
	    		int total = nums[left] + nums[right];
	    		if(total>nums[i]) {
	    			numberOfTriplets += right-left;
	    			right--;
	    		}else {
	    			left++;
	    		}
	    	}
	    }

	    return numberOfTriplets;
	}
	
	

}
