package com.ankurmaurya.heap.pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import com.ankurmaurya.heap.utility.Utilities;

/*
 * Find K Pairs with Smallest Sums
 * 
 * Type : Medium
 * 
 * You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 * 
 * Example 1:
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 
 * Example 2:
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 
 * 
 * Constraints:
 *  1 <= nums1.length, nums2.length <= 105
 *  -10power9 <= nums1[i], nums2[i] <= 10power9
 *  nums1 and nums2 both are sorted in non-decreasing order.
 *  1 <= k <= 10power4
 *  k <= nums1.length * nums2.length
 * 
 * 
 * Solution:
 *  Time Complexity  : O(klogN)
 *  Space Complexity : O(N)
 * 
 */



public class KPairWithSmallestSum {

	
	public static void main(String[] args) {
		List<List<Integer>> l1 = kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3);
		System.out.println(l1);
		System.out.println();
		
		List<List<Integer>> l2 = kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 2);
		System.out.println(l2);
		System.out.println();
		
		List<List<Integer>> l3 = kSmallestPairs(new int[]{1,1,1,2}, new int[]{3,6,7,8}, 5);
		System.out.println(l3);
		System.out.println();
	}
	
	
   public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
	 Utilities.printElements(nums1);
	 Utilities.printElements(nums2);
	 
	 List<List<Integer>> ksmallestPairs = new ArrayList<>();
	 
	 PriorityQueue<int[]> pqueue = new PriorityQueue<>((a,b)->a[0]-b[0]);
	 for(int i=0; i<nums1.length && i < k; i++) {
		 pqueue.add(new int[] {nums1[i]+nums2[0], 0}); 
	 }
	 
	 while(k > 0 && !pqueue.isEmpty()) {
		 int[] element = pqueue.poll();
		 int sum = element[0];
		 int index = element[1];
		 
		 List<Integer> pair = new ArrayList<>();
		 pair.add(sum - nums2[index]);
		 pair.add(nums2[index]);
		 ksmallestPairs.add(pair);
		 
		 if((index+1) <= nums2.length-1) {
			 pqueue.add(new int[] {(sum-nums2[index]) + nums2[index+1], index+1}); 
		 }

		 k--;
	 }
	   
	 return ksmallestPairs;  
   }
	
}



