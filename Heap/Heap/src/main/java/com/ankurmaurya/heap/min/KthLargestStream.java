package com.ankurmaurya.heap.min;


import java.util.PriorityQueue;


/*
 * 
 * Kth Largest Element in a Stream
 * 
 * 
 * Type : Easy
 * 
 * 
 * You are part of a university admissions office and need to keep track of the kth highest test score from applicants in real-time. 
 * This helps to determine cut-off marks for interviews and admissions dynamically as new applicants submit their scores.
 * You are tasked to implement a class which, for a given integer k, maintains a stream of test scores and continuously returns the kth highest test score after a new score has been submitted. 
 * More specifically, we are looking for the kth highest score in the sorted list of all scores.
 * 
 * 
 * Implement the KthLargest class:
 * 
 *   - KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of test scores nums.
 *   
 *   - int add(int val) Adds a new test score val to the stream and returns the element representing the kth largest element in the pool of test scores so far.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input:
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 
 * Output: [null, 4, 5, 5, 8, 8]
 *  Explanation:
 * 	 KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 *   kthLargest.add(3); // return 4
 *   kthLargest.add(5); // return 5
 *   kthLargest.add(10); // return 5
 *   kthLargest.add(9); // return 8
 *   kthLargest.add(4); // return 8
 * 
 * 
 * Example 2:
 * 
 * Input:
 * ["KthLargest", "add", "add", "add", "add"]
 * [[4, [7, 7, 7, 7, 8, 3]], [2], [10], [9], [9]]
 * 
 * Output: [null, 7, 7, 7, 8]
 *  Explanation:
 *   KthLargest kthLargest = new KthLargest(4, [7, 7, 7, 7, 8, 3]);
 *   kthLargest.add(2); // return 7
 *   kthLargest.add(10); // return 7
 *   kthLargest.add(9); // return 7
 *   kthLargest.add(9); // return 8
 * 
 * Constraints:
 *  0 <= nums.length <= 10power4
 *  1 <= k <= nums.length + 1
 *  -10power4 <= nums[i] <= 10power4
 *  -10power4 <= val <= 10power4
 * 
 * 
 *  At most 104 calls will be made to add.
 * 
 * Solution:
 *  Time Complexity  : O(klogN)
 *  Space Complexity : O(N)
 * 
 * ***** TLE
 * First solution gave me TLE (Time Limit Exceeded) error as the approach was to maintain the MAX Heap and then first remove the elements upto K 
 * then get the K position element and add the elements again which was not optimal solution.
 * 
 * 
 * ***** 23ms
 * Second and best solution was instead of maintaining the MAX Heap we should maintain the MIN Heap and remove the smallest elements up-to K as
 * we only want the K largest and removing the elements in ascending order till less than K always has the most smallest element up-to K if we
 * look it from backwards in the heap.
 * 
 * 
 * 
 */


public class KthLargestStream {

	private int kthPosition;
	private PriorityQueue<Integer> highestTestScore = new PriorityQueue<>();
	
	
    public KthLargestStream(int k, int[] nums) {
      this.kthPosition = k;
      for(int num : nums) {
    	  highestTestScore.add(num); 
      }
    }

    
    public int add(int val) {
    	highestTestScore.add(val);
    	
    	while(highestTestScore.size() > kthPosition) {
    		highestTestScore.poll();
    	}

    	return highestTestScore.peek();
    }
    
    
    public static void main(String[] args) {
    	KthLargestStream obj1 = new KthLargestStream(3, new int[]{4, 5, 8, 2});
		for(int num : new int[]{ 3, 5, 10, 9, 4}) {
		  int kthLarge1 = obj1.add(num); 
		  System.out.println(kthLarge1);
	    }
		
		KthLargestStream obj2 = new KthLargestStream(4, new int[]{7, 7, 7, 7, 8, 3});
		for(int num : new int[]{ 2, 10, 9, 9}) {
		  int kthLarge2 = obj2.add(num); 
		  System.out.println(kthLarge2);
	    }
	}
	
	
}





