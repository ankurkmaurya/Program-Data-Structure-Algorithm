package com.ankurmaurya.binarysearch.ceilfloor;

import com.ankurmaurya.binarysearch.utility.Utilities;


/*
 * 
 *  
 *  Given an array nums sorted in non-decreasing order, return the maximum between 
 *  the number of positive integers and the number of negative integers.
 *  
 *  Note that 0 is neither positive nor negative.
 *  
 *  
  Example 1:
	Input: nums = [-2,-1,-1,1,2,3]
	Output: 3
	Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
	
  Example 2:
	Input: nums = [-3,-2,-1,0,0,1,2]
	Output: 3
	Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.
	
  Example 3:
	Input: nums = [5,20,66,1314]
	Output: 4
	Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.

 * 
 * 
 * 
 * 
 * 
 */
public class MaximumCountofPositiveIntegerandNegativeInteger {

	public static void main(String[] args) {
		int[] nums1 = {-2,-1,-1,1,2,3};
		int[] nums2 = {-3,-2,-1,0,0,1,2};
		int[] nums3 = {5,20,66,1314};
		int[] nums4 = {0,0};
		
		Utilities.printElements(nums1);
		int nums1Floor = Utilities.findFloorIndex(nums1, 0, false);
		int nums1Ceil =  Utilities.findCeilIndex(nums1, 0, false);
		int nums1NoOfNegCnt = nums1Floor+1;
		int nums1NoOfPosCnt = nums1.length - nums1Ceil;
		System.out.println("Max between of -ve '" + nums1NoOfNegCnt + "' and +ve '" + nums1NoOfPosCnt + "' is : " + (Utilities.findMax(nums1NoOfNegCnt, nums1NoOfPosCnt)));
		System.out.println();
		
		Utilities.printElements(nums2);
		int nums2Floor = Utilities.findFloorIndex(nums2, 0, false);
		int nums2Ceil =  Utilities.findCeilIndex(nums2, 0, false);
		int nums2NoOfNegCnt = nums2Floor+1;
		int nums2NoOfPosCnt = nums2.length - nums2Ceil;
		System.out.println("Max between of -ve '" + nums2NoOfNegCnt + "' and +ve '" + nums2NoOfPosCnt + "' is : " + (Utilities.findMax(nums2NoOfNegCnt, nums2NoOfPosCnt)));
		System.out.println();
		
		Utilities.printElements(nums3);
		int nums3Floor = Utilities.findFloorIndex(nums3, 0, false);
		int nums3Ceil =  Utilities.findCeilIndex(nums3, 0, false);
		int nums3NoOfNegCnt = nums3Floor+1;
		int nums3NoOfPosCnt = nums3.length - nums3Ceil;
		System.out.println("Max between of -ve '" + nums3NoOfNegCnt + "' and +ve '" + nums3NoOfPosCnt + "' is : " + (Utilities.findMax(nums3NoOfNegCnt, nums3NoOfPosCnt)));
		System.out.println();
		
		Utilities.printElements(nums4);
		int nums4Floor = Utilities.findFloorIndex(nums4, 0, false);
		int nums4Ceil =  Utilities.findCeilIndex(nums4, 0, false);
		int nums4NoOfNegCnt = nums4Floor == -1 ? 0 :nums4Floor+1;
		int nums4NoOfPosCnt = nums4Ceil ==-1 ? 0: nums4.length-nums4Ceil;
		System.out.println("Max between of -ve '" + nums4NoOfNegCnt + "' and +ve '" + nums4NoOfPosCnt + "' is : " + (Utilities.findMax(nums4NoOfNegCnt, nums4NoOfPosCnt)));
		System.out.println();
	}
	
	
	
	
}
