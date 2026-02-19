package com.ankurmaurya.dp;

//import com.ankurmaurya.binarysearch.utility.Utilities;
//
///*
// * Number of Longest Increasing Subsequence
// * 
// * Type : Medium
// * 
// * 
// * Given an integer array nums, return the number of longest increasing subsequences.
// * 
// * Notice that the sequence has to be strictly increasing.
// * 
// * 
// * Example 1:
// * Input: nums = [1,3,5,4,7]
// * Output: 2
// * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
// * 
// * 
// * Example 2:
// * Input: nums = [2,2,2,2,2]
// * Output: 5
// * Explanation: The length of the longest increasing subsequence is 1, 
// *              and there are 5 increasing subsequences of length 1, so output 5.
// *           
// *       
// * Constraints:
// * 1 <= nums.length <= 2000
// * -10power6 <= nums[i] <= 10power6
// * 
// * 
// * The answer is guaranteed to fit inside a 32-bit integer.
// * 
// * 
// * 
// * Solution:
// * Time Complexity  : O(n*n)
// *                    We are iterating on the whole data set and then performing 
// *                    Binary Search on the sequential data set that we are creating
// *                    and using to track the longest increasing sequence.
// *                    
// * Space Complexity : O(n)
// * 					  Sequential data set created to hold the tracking of longest 
// *                    increasing sequence.
// * 
// * 
// */
//
//public class NumberOfLongestIncreasingSubsequenceFailed {
//
//	public static void main(String[] args) {
//	  int[] nums1 = {10,9,2,5,3,7,101,18};
//	  int[] nums2 = {1,3,5,4,7};
//	  int[] nums3 = {2,2,2,2,2};
//	  int[] nums4 = {6,5};
//	  int[] nums5 = {7,8};
//	  int[] nums6 = {4};
//	  int[] nums7 = {};
//	  int[] nums8 = {1,2,4,3,5,4,7,2}; //exp 3 -- gives 4
//	  int[] nums9 = {3,1,2}; //exp 1 -- gives 2
//	  
//	  /*
//	  Utilities.printElements(nums1);
//	  int numberOfLIS1 = findNumberOfLIS(nums1);
//	  System.out.println("Number of LIS found '" + numberOfLIS1 + "'");
//	  System.out.println();
//
//	  Utilities.printElements(nums2);
//	  int numberOfLIS2 = findNumberOfLIS(nums2);
//	  System.out.println("Number of LIS found '" + numberOfLIS2 + "'");
//	  System.out.println();
//
//	  Utilities.printElements(nums3);
//	  int numberOfLIS3 = findNumberOfLIS(nums3);
//	  System.out.println("Number of LIS found '" + numberOfLIS3 + "'");
//	  System.out.println();	
//	  
//	  Utilities.printElements(nums4);
//	  int numberOfLIS4 = findNumberOfLIS(nums4);
//	  System.out.println("Number of LIS found '" + numberOfLIS4 + "'");
//	  System.out.println();	
//	  
//	  Utilities.printElements(nums5);
//	  int numberOfLIS5 = findNumberOfLIS(nums5);
//	  System.out.println("Number of LIS found '" + numberOfLIS5 + "'");
//	  System.out.println();	
//	  
//	  Utilities.printElements(nums6);
//	  int numberOfLIS6 = findNumberOfLIS(nums6);
//	  System.out.println("Number of LIS found '" + numberOfLIS6 + "'");
//	  System.out.println();	
//	  
//	  Utilities.printElements(nums7);
//	  int numberOfLIS7 = findNumberOfLIS(nums7);
//	  System.out.println("Number of LIS found '" + numberOfLIS7 + "'");
//	  System.out.println();	
//	  */
//	  Utilities.printElements(nums8);
//	  int numberOfLIS8 = findNumberOfLIS(nums8);
//	  System.out.println("Number of LIS found '" + numberOfLIS8 + "'");
//	  System.out.println();	
//	  /*
//	  Utilities.printElements(nums9);
//	  int numberOfLIS9 = findNumberOfLIS(nums9);
//	  System.out.println("Number of LIS found '" + numberOfLIS9 + "'");
//	  System.out.println();	
//		*/
//	}
//
//
//    public static int findNumberOfLIS(int[] nums) {
//    	if(nums.length == 0) {
//    		return 0;
//    	}
//        
//    	int noOfLIS = -1;
//    	int maxMinInLIS = Integer.MAX_VALUE;
//    	
//    	int[][] lisTable = new int[nums.length][3];
//        for(int num : nums) {
//        	if(num < maxMinInLIS) {
//        		/*
//        		for(int i=0; i<lisTable.length; i++) {
//        			lisTable[i][0] = num;
//            		lisTable[i][1] = 1;
//	        	}
//	        	*/
//        		
//        		noOfLIS = 0;
//        		lisTable[noOfLIS][0] = num;
//        		lisTable[noOfLIS][1] = 1;
//        		
//        		maxMinInLIS = num;
//        	} else {
//        		boolean positionFound = false;
//	    		for(int i=0; i<=noOfLIS; i++) {
//	        		if(lisTable[i][0] < num) {
//	        		   lisTable[i][0] = num;
//	        		   lisTable[i][1] = lisTable[i][1] + 1;
//	        		   positionFound = true;
//	        		   
//	        		}
//	        	}
//	    		if(!positionFound) {
//	    			noOfLIS++;
//	    			lisTable[noOfLIS][0] = num;
//	    			lisTable[noOfLIS][1] = lisTable[noOfLIS][1] + 1;
//	    		}
//        	}
//        }
//    	return noOfLIS + 1;
//    }
//    
//    
//    public static int findFloorIndex(int[] elements, int start, int end, int target) {
//		int floorOfTargetIndex = -1;
//		if(elements.length==0) {
//			return floorOfTargetIndex;
//		}
//		
//		int low = start;
//		int high = end;
//		while(low <= high) {
//			int mid = low + (high - low)/2;
//			
//			if(elements[mid]==target) {
//				high = mid-1;
//			}
//			else if(elements[mid]<target) {
//				low = mid+1;
//				floorOfTargetIndex = mid;
//			}
//			else {
//				high = mid-1;
//			}
//		}
//		return floorOfTargetIndex;
//	}
//	
//
//	
//}





