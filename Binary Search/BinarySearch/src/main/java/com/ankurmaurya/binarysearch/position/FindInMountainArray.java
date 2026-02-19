package com.ankurmaurya.binarysearch.position;

import com.ankurmaurya.binarysearch.utility.Utilities;


/*
 * Find in Mountain Array
 * 
 * Type : Hard
 * 
 * 
 * You may recall that an array arr is a mountain array if and only if:
 * arr.length >= 3
 * 
 * There exists some i with 0 < i < arr.length - 1 such that:
 *   arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *   arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 
 * Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. 
 * If such an index does not exist, return -1.
 * 
 * You cannot access the mountain array directly. 
 * 
 * You may only access the array using a MountainArray interface:
 * MountainArray.get(k) returns the element of the array at index k (0-indexed).
 * MountainArray.length() returns the length of the array.
 * Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. 
 * Also, any solutions that attempt to circumvent the judge will result in disqualification.
 * 
 * 
 * Example 1:
 * Input: mountainArr = [1,2,3,4,5,3,1], target = 3
 * Output: 2
 * Explanation: 3 exists in the array, at index=2 and index=5. 
 *              Return the minimum index, which is 2.
 * 
 * 
 * Example 2:
 * Input: mountainArr = [0,1,2,4,2,1], target = 3
 * Output: -1
 * Explanation: 3 does not exist in the array, so we return -1.
 * 
 * 
 * Constraints:
 *  3 <= mountainArr.length() <= 10power4
 *  0 <= target <= 10power9
 *  0 <= mountainArr.get(index) <= 10power9
 * 
 * 
 * 
 * 
 * 
 * Solution:
 * 
 * Time Complexity:
 *  It will take O(logn) time to find the peak element of mountain array and 
 *  O(2logn) time to find the index of the target element in both the side of the 
 *  peak element.Hence it will be O(logn) time complexity.
 *  
 * Space Complexity:
 *  It takes only constant extra space, hence O(1) space complexity.
 * 
 * 
 * 
 */



public class FindInMountainArray {

	
	public static void main(String[] args) {
		
		int[] num1 = {1,5,2};
		int[] num11 = {0,5,3,1};
		int target1 = 1;
		MountainArray mountainArr1 = new MountainArray(num1);
		int indexOfTarget1 = findInMountainArray(target1, mountainArr1);
		Utilities.printElements(num1);
		System.out.println("Index of '" + target1 + "' in Mountain Array is '" + indexOfTarget1 + "'");
		System.out.println();
		
		
		MountainArray mountainArr11 = new MountainArray(num11);
		int indexOfTarget11 = findInMountainArray(target1, mountainArr11);
		Utilities.printElements(num11);
		System.out.println("Index of '" + target1 + "' in Mountain Array is '" + indexOfTarget11 + "'");
		System.out.println();
		
		
		int[] num2 = {1,5,2};
		int target2 = 2;
		MountainArray mountainArr2 = new MountainArray(num2);
		int indexOfTarget2 = findInMountainArray(target2, mountainArr2);
		Utilities.printElements(num2);
		System.out.println("Index of '" + target2 + "' in Mountain Array is '" + indexOfTarget2 + "'");
		System.out.println();
		
		
		int[] num3 = {1,2,3,4,5,3,1};
		int target3 = 3;
		MountainArray mountainArr3 = new MountainArray(num3);
		int indexOfTarget3 = findInMountainArray(target3, mountainArr3);
		Utilities.printElements(num3);
		System.out.println("Index of '" + target3 + "' in Mountain Array is '" + indexOfTarget3 + "'");
		System.out.println();
		
		
		int[] num4 = {3,5,3,2,0};
		int target4 = 0;
		MountainArray mountainArr4 = new MountainArray(num4);
		int indexOfTarget4 = findInMountainArray(target4, mountainArr4);
		Utilities.printElements(num4);
		System.out.println("Index of '" + target4 + "' in Mountain Array is '" + indexOfTarget4 + "'");
		System.out.println();
		
	}
	
	
	
    public static int findInMountainArray(int target, MountainArray mountainArr) {
    	int mountainLength = mountainArr.length();
    	
    	int low = 0;
    	int high = mountainLength-1;
    	
    	if(mountainLength<3) {
    		return -1;
    	}
    	
    	int mountainPeakIndex = -1;
    	while(low<=high) {
    		int mid = low + (high - low)/2;
    		
    		int midVal = mountainArr.get(mid);
    		int midLeftVal = mid-1 == -1 ? -1 : mountainArr.get(mid-1);
    		int midRightVal = mid+1 == mountainLength ? -1 :mountainArr.get(mid+1);
    		
    		if(midLeftVal < midVal && midVal > midRightVal) {
    			mountainPeakIndex = mid;
    			break;
    		}
    		else if(midLeftVal < midVal && midVal < midRightVal) {
    			low = mid+1;
    		} 
    		else if(midRightVal>midVal && midLeftVal<=midVal) {
    			low = mid+1;
    		} else {
    			high = mid-1;
    		}
    	}
    	
    	if(mountainPeakIndex <= 0) {
    		return -1;
    	}
    	
    	int leftTargetIndex = findFloorIndexOfTargetInLeft(target, 0, mountainPeakIndex, mountainArr);
    	int rightTargetIndex = findFloorIndexOfTargetInRight(target, mountainPeakIndex, mountainLength-1, mountainArr);
    	
    	if(leftTargetIndex == -1) {
    		return rightTargetIndex;
    	} else if(rightTargetIndex == -1) {
    		return leftTargetIndex;
    	} else {
    		return leftTargetIndex<rightTargetIndex?leftTargetIndex:rightTargetIndex;
    	}
    } 
    
    
    public static int findFloorIndexOfTargetInLeft(int target, int startIndex, int endIndex, MountainArray mountainArr) {
    	int floorIndex = -1;
    	
    	int start = startIndex;
    	int end = endIndex;
    	while(start<=end) {
    		int mid = start + (end-start)/2;
    		int midVal = mountainArr.get(mid);
    		if(midVal == target) {
    			floorIndex = mid;
    			end = mid-1;
    		} else if(midVal>target) {
    			end = mid-1;
    		} else {
    			start = mid+1;
    		}
    	}
    	
    	return floorIndex;
    }
    
    public static int findFloorIndexOfTargetInRight(int target, int startIndex, int endIndex, MountainArray mountainArr) {
    	int floorIndex = -1;
    	
    	int start = startIndex;
    	int end = endIndex;
    	while(start<=end) {
    		int mid = start + (end-start)/2;
    		int midVal = mountainArr.get(mid);
    		if(midVal == target) {
    			floorIndex = mid;
    			end = mid-1;
    		} else if(midVal>target) {
    			start = mid+1;
    		} else {
    		   end = mid-1;
    		}
    	}
    	
    	return floorIndex;
    }
    
    
}



class MountainArray {

	private int[] num;

	MountainArray(int[] num) {
		this.num = num;
	}

	public int get(int index) {
		return num[index];
	}

	public int length() {
		return num.length;
	}

}

