package com.ankurmaurya.binarysearch.longsmallmaxmin;

import com.ankurmaurya.binarysearch.utility.Utilities;

public class IncreasingSequenceMaximumMinimum {

	
	public static void main(String[] args) {
		int[] nums1 = {10,9,2,5,3,7,101,18}; 
		int[] nums2 = {0,1,0,3,2,3};         
		int[] nums3 = {7,7,7,7,7,7,7};       
		int[] nums4 = {15,14,2,10,9,8,3,4,5,6,7,101,101,18}; 
		int[] nums41 = {15,14,2,10,9,8,3,4,5,6,7,101,18}; 
		int[] nums5 = {2,5}; 
		
		Utilities.printElements(nums1);
		int minNum1 = Utilities.getMinimumNumber(nums1, false);
		int minIndex1 = Utilities.getMinimumNumber(nums1, true);
		int maxNum1 = Utilities.getMaximumNumber(nums1, false);
		int maxIndex1 = Utilities.getMaximumNumber(nums1, true);
		System.out.println("Minimum Number -> " + minNum1);
		System.out.println("Minimum Index  -> " + minIndex1);
		System.out.println("Maximum Number -> " + maxNum1);
		System.out.println("Maximum Index  -> " + maxIndex1);
		System.out.println();
		
		Utilities.printElements(nums2);
		int minNum2 = Utilities.getMinimumNumber(nums2, false);
		int minIndex2 = Utilities.getMinimumNumber(nums2, true);
		int maxNum2 = Utilities.getMaximumNumber(nums2, false);
		int maxIndex2 = Utilities.getMaximumNumber(nums2, true);
		System.out.println("Minimum Number -> " + minNum2);
		System.out.println("Minimum Index  -> " + minIndex2);
		System.out.println("Maximum Number -> " + maxNum2);
		System.out.println("Maximum Index  -> " + maxIndex2);
		System.out.println();
		
		Utilities.printElements(nums3);
		int minNum3 = Utilities.getMinimumNumber(nums3, false);
		int minIndex3 = Utilities.getMinimumNumber(nums3, true);
		int maxNum3 = Utilities.getMaximumNumber(nums3, false);
		int maxIndex3 = Utilities.getMaximumNumber(nums3, true);
		System.out.println("Minimum Number -> " + minNum3);
		System.out.println("Minimum Index  -> " + minIndex3);
		System.out.println("Maximum Number -> " + maxNum3);
		System.out.println("Maximum Index  -> " + maxIndex3);
		System.out.println();
		
		Utilities.printElements(nums4);
		int minNum4 = Utilities.getMinimumNumber(nums4, false);
		int minIndex4 = Utilities.getMinimumNumber(nums4, true);
		int maxNum4 = Utilities.getMaximumNumber(nums4, false);
		int maxIndex4 = Utilities.getMaximumNumber(nums4, true);
		System.out.println("Minimum Number -> " + minNum4);
		System.out.println("Minimum Index  -> " + minIndex4);
		System.out.println("Maximum Number -> " + maxNum4);
		System.out.println("Maximum Index  -> " + maxIndex4);
		System.out.println();
		
		Utilities.printElements(nums41);
		int minNum41 = Utilities.getMinimumNumber(nums41, false);
		int minIndex41 = Utilities.getMinimumNumber(nums41, true);
		int maxNum41 = Utilities.getMaximumNumber(nums41, false);
		int maxIndex41 = Utilities.getMaximumNumber(nums41, true);
		System.out.println("Minimum Number -> " + minNum41);
		System.out.println("Minimum Index  -> " + minIndex41);
		System.out.println("Maximum Number -> " + maxNum41);
		System.out.println("Maximum Index  -> " + maxIndex41);
		System.out.println();
		
		Utilities.printElements(nums5);
		int minNum5 = Utilities.getMinimumNumber(nums5, false);
		int minIndex5 = Utilities.getMinimumNumber(nums5, true);
		int maxNum5 = Utilities.getMaximumNumber(nums5, false);
		int maxIndex5 = Utilities.getMaximumNumber(nums5, true);
		System.out.println("Minimum Number -> " + minNum5);
		System.out.println("Minimum Index  -> " + minIndex5);
		System.out.println("Maximum Number -> " + maxNum5);
		System.out.println("Maximum Index  -> " + maxIndex5);
		System.out.println();
		
	}
	
}


