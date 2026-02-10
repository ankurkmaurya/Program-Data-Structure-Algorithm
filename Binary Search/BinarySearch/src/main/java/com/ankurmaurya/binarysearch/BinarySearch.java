package com.ankurmaurya.binarysearch;

import com.ankurmaurya.binarysearch.utility.Utilities;

public class BinarySearch {
	
	
	public static void main(String[] args) {
		int[] elements = {0,1,3,5,7,8,9,12,23,34,45};
		
		Utilities.printElements(elements);
		
		int target1 = 12;
		System.out.println("Index of target '" + target1 + "' is : " + (findIndexOfTarget(elements, target1)));

		int target2 = 0;
		System.out.println("Index of target '" + target2 + "' is : " + (findIndexOfTarget(elements, target2)));

		int target3 = 6;
		System.out.println("Index of target '" + target3 + "' is : " + (findIndexOfTarget(elements, target3)));
	}
	
	
	private static int findIndexOfTarget(int[] elements, int target) {
		if(elements.length==0) {
			return -1;
		}
		
		int start = 0;
		int end = elements.length -1;
		
		
		while(start<=end) {
			int mid = start + (end - start)/2;
			
			if(elements[mid]==target) {
				return mid;
			}
			else if(elements[mid]>target) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		return -1;
	}
	
}





