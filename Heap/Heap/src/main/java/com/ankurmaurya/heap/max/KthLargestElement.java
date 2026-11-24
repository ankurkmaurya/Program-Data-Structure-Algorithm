package com.ankurmaurya.heap.max;

import java.util.PriorityQueue;

import com.ankurmaurya.heap.utility.Utilities;

/*
 * Kth Largest Element in an Array
 * 
 * Type : Medium
 * 
 * 
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Can you solve it without sorting?
 * 
 * 
 * Example 1:
 *  Input  : nums = [3,2,1,5,6,4], k = 2
 *  Output : 5
 * 
 * Example 2:
 *  Input  : nums = [3,2,3,1,2,4,5,5,6], k = 4
 *  Output : 4
 * 
 * 
 * Constraints:
 *  1 <= k <= nums.length <= 105
 *  -10power4 <= nums[i] <= 10power4
 * 
 * 
 * 
 * 
 * Solution:
 * 
 * First Solution : Selection Sort (TLE)
 *  Time Complexity  : O(N2)
 *  Space Complexity : O(1)
 *  
 *  As it was given k <= array.length it was possible to implement Selection Sort based on the positional swaps.
 *  The solution was successful but as it's worst case time complexity was O(N2) N square it resulted in 
 *  Time Limit Exceeded error.
 * 
 * 
 * Second Solution : Minimum Heap (69ms)
 *  Time Complexity  : O(Nlogk)
 *  Space Complexity : O(k)
 *  
 *  Using Heap resulted in O(Nlogk) time complexity, first used Max heap which gave 73ms time result but after using 
 *  Min heap it gave 69ms time result which was much optimal.
 *  
 *  
 * 18 Nov 2026
 *  Suggestion showed Quickselect which can give O(N) average time complexity and O(1) space complexity, will try to use
 *  quickselect in the future and see the improvements in runtime results.
 * 
 * 
 * 
 */

public class KthLargestElement {

	public static void main(String[] args) {
		//solution(new int[] {3,2,1,5,6,4}, 2, 5);
		solution(new int[] {3,2,1,5,6,4}, 5, 2);
		solution(new int[] {3,2,3,1,2,4,5,5,6}, 4, 4); 
		solution(new int[] {3,2,3,1,2,4,5,5,6}, 6, 3);
		solution(new int[] {3,2,3,1,2,4,5,5,6}, 7, 2);
	}
	
	
	public static void solution(int[] nums, int k, int answer) {
		Utilities.printElements(nums);
		System.out.println("K - " + k);
		int kthlargestInt = findKthLargestMinHeap(nums, k);
		System.out.println(k + "th Largest Number : " + kthlargestInt + ", Assert : "+ (kthlargestInt==answer));
		System.out.println();
    }
	
	
	 public static int findKthLargestMinHeap(int[] nums, int k) {
		 PriorityQueue<Integer> minQueue = new PriorityQueue<>();
		 for(int num : nums) {
			 minQueue.add(num);
             if (minQueue.size() > k) {
                minQueue.poll();
            }
		 }
		 
		 return minQueue.peek();
	 }
	
	public static int findKthLargestNSquareHalf(int[] nums, int k) {
	     if(nums.length == 1 && k==1) {
	    	 return nums[0];
	     }
	     
	     boolean largest = true;
	     if(k > nums.length/2) {
	    	 largest = false;
	    	 k = (nums.length-k)+1;
	     } 
	     
	     for(int kIerations=0; kIerations < k; kIerations++) {
	    	int itrCompareNumber = largest ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	    	int itrFoundIndex = -1;
	    	for(int index =kIerations; index < nums.length; index++) {
	    		if(largest) {
	    			if(nums[index] > itrCompareNumber) {
	    				itrFoundIndex = index;
		    			itrCompareNumber = nums[index];
		    		}
	    		} else {
	    			if(nums[index] < itrCompareNumber) {
	    				itrFoundIndex = index;
		    			itrCompareNumber = nums[index];
		    		}
	    		}
	    		
	    	}
	    	
	    	int temp = nums[kIerations];
	    	nums[kIerations] = nums[itrFoundIndex];
	    	nums[itrFoundIndex] = temp;
	     }
		 return nums[k-1];
	}
	
	
	public static int findKthLargestNSquare(int[] nums, int k) {
	     if(nums.length == 1 && k==1) {
	    	 return nums[0];
	     }
	     
	     for(int kIerations=0; kIerations < k; kIerations++) {
	    	int largestNumber = Integer.MIN_VALUE;
	    	int largestIndex = -1;
	    	for(int index =kIerations; index < nums.length; index++) {
	    		if(nums[index]>largestNumber) {
	    			largestIndex = index;
	    			largestNumber = nums[index];
	    			
	    		}
	    	}
	    	
	    	int temp = nums[kIerations];
	    	nums[kIerations] = nums[largestIndex];
	    	nums[largestIndex] = temp;
	     }
		 return nums[k-1];
	}

	
}




