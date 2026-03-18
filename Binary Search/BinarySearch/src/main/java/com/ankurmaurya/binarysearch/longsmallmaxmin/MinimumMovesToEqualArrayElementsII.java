package com.ankurmaurya.binarysearch.longsmallmaxmin;

import java.util.Arrays;

import com.ankurmaurya.binarysearch.utility.Utilities;

/*
 * Minimum Moves to Equal Array Elements II
 * 
 * Type : Medium
 * 
 * 
 * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
 * In one move, you can increment or decrement an element of the array by 1.
 * 
 * Test cases are designed so that the answer will fit in a 32-bit integer.
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: 2
 * Explanation: Only two moves are needed (remember each move increments or decrements one element):
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 
 * 
 * Example 2:
 * Input: nums = [1,10,2,9]
 * Output: 16
 * 
 * 
 * Constraints:
 *  n == nums.length
 *  1 <= nums.length <= 10 power 5
 *  -10 power 9 <= nums[i] <= 10 power 9
 *  
 *  
 *  
 * Solution:
 *  Optimization: 11ms, Beats 31.81%
 *   Time Complexity  : O(nlogn) 
 *   Space Complexity : O(1)
 *  
 *  
 * Observation : 
 *  This problem was solved with Binary Search on Answer method, however when the answer 
 *  for selected element and next element was equal, I faced the issue of where to move
 *  but as this problem can be solved with Median logic we can break the loop if the 
 *  minimum moves comparison of both the elements are equal,
 *  
 *  This works because the median minimizes the sum of absolute deviations.
 * 
 *  
 * 
 */


public class MinimumMovesToEqualArrayElementsII {

	public static void main(String[] args) {
		minMovesToEqual(new int[]{1,2,3}, 2);
		minMovesToEqual(new int[]{1,10,2,9}, 16);
		minMovesToEqual(new int[]{1,2,3,5,-1, -2}, 12);
		minMovesToEqual(new int[]{1}, 0);
		minMovesToEqual(new int[]{1,1}, 0);
		minMovesToEqual(new int[]{203125577,-349566234,230332704,48321315,66379082,386516853,
				                  50986744,-250908656,-425653504,-212123143}, 2127271182);
	}
	
	
    public static void minMovesToEqual(int[] nums, int answer) {
    	 int minMoves = minMoves2(nums);
		 Utilities.printElements(nums);
		 System.out.println("Min. Moves to Equal Array Elements '" + minMoves + "', Assert : " + (minMoves==answer) + "'");
		 System.out.println();
    }
	
    
    public static int minMoves2(int[] nums) {
        int minMoves = Integer.MAX_VALUE;
    	
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        while(low<high) {
        	int mid = low + (high-low)/2;
        	int movesMid = requiredMovesToMakeArrayElementsEqualToTarget(nums, nums[mid]);
        	int movesMidNext = requiredMovesToMakeArrayElementsEqualToTarget(nums, nums[mid+1]);
        	
        	if(movesMid == movesMidNext) {
        		minMoves = Math.min(movesMid, minMoves);
        		break;
        	}
        	else if(movesMidNext>movesMid) {
        		minMoves = Math.min(movesMid, minMoves);
        		high = mid-1;
        	} else {
        		minMoves = Math.min(movesMidNext, minMoves);
        		low = mid +1;
        	}
        }
    	return minMoves == Integer.MAX_VALUE ? 0 : minMoves;
    }
    
    
    public static int requiredMovesToMakeArrayElementsEqualToTarget(int[] nums, int targetElement) {
    	int requiredMoves = 0;
    	for(int i=0; i< nums.length; i++) {
    		if(nums[i]>targetElement) {
    			requiredMoves += nums[i] - targetElement;
    		} else {
    			requiredMoves += targetElement - nums[i];
    		}
    	}
    	return requiredMoves;
    }

}



