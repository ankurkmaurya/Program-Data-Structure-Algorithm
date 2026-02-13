package com.ankurmaurya.binarysearch.missing;

import com.ankurmaurya.binarysearch.utility.Utilities;

/*
 * 
 * Kth Missing Positive Number
 * 
 * Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
 * Return the kth positive integer that is missing from this array.
 * 
 * 
 * Example 1:
 * Input: arr = [2,3,4,7,11], k = 5
 * Output: 9
 * Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
 * 
 * 
 * Example 2:
 * Input: arr = [1,2,3,4], k = 2
 * Output: 6
 * Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
 * 
 * 
 * Constraints:
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * arr[i] < arr[j] for 1 <= i < j <= arr.length
 * 
 * 
 * Follow up:
 * Could you solve this problem in less than O(n) complexity?
 * 
 * 
 */



public class KthMissingPositiveNumber {
	
	
	public static void main(String[] args) {
		int[] arr = {2,3,4,7,11};
		int k1 = 3;
		int k2 = 4;
		int k3 = 5;
		int missingNumber1 = findKthPositive(arr, k1);
		System.out.println("The " + k1 + "th missing positive integer is '" + missingNumber1 + "'");
		int missingNumber2 = findKthPositive(arr, k2);
		System.out.println("The " + k2 + "th missing positive integer is '" + missingNumber2 + "'");
		int missingNumber3 = findKthPositive(arr, k3);
		System.out.println("The " + k3 + "th missing positive integer is '" + missingNumber3 + "'");
		

		int[] arr1 = {1,2,3,4};
		int k4 = 1;
		int k5 = 2;
		int k6 = 3;
		int missingNumber4 = findKthPositive(arr1, k4);
		System.out.println("The " + k4 + "th missing positive integer is '" + missingNumber4 + "'");
		int missingNumber5 = findKthPositive(arr1, k5);
		System.out.println("The " + k5 + "th missing positive integer is '" + missingNumber5 + "'");
		int missingNumber6 = findKthPositive(arr1, k6);
		System.out.println("The " + k6 + "th missing positive integer is '" + missingNumber6 + "'");
		
		
		int[] arr2 = {5,6,7,8,9};
		for(int i=1; i<20; i++) {
			int k = i;
			int missingNumberAtK = findKthPositive(arr2, k);
			System.out.println("The " + k + "th missing positive integer is '" + missingNumberAtK + "'");
		}
		
		int[] arr3 = {2};
		for(int i=1; i<2; i++) {
			int k = i;
			int missingNumberAtK3 = findKthPositive(arr3, k);
			System.out.println("The " + k + "th missing positive integer is '" + missingNumberAtK3 + "'");
		}

	}
	
	
	
	public static int findKthPositiveBruteforce(int[] arr, int k) {
		int missingIndex = 0;
    	int[] missingNumbers = new int[k];
    	int arrIndex =0;
    	int searchSpace = arr[arr.length-1];
    	for(int i=1; i<=searchSpace; i++) {
    		if(i != arr[arrIndex]) {
    			missingNumbers[missingIndex] = i;
    			missingIndex++;
    		} else {
    			arrIndex++;
    		}
    		
    		if(missingIndex == k) {
    			break;
    		}
    	}
    	
    	if(missingIndex != k) {
    		searchSpace++;
    		for(int j=missingIndex; j<k; j++) {
    			missingNumbers[missingIndex] = searchSpace;
    			missingIndex++;
    			searchSpace++;
    		}
    	}

    	Utilities.printElements(missingNumbers);
    	return missingNumbers[missingIndex-1];
    }
	
	
	
    public static int findKthPositive(int[] arr, int k) {
    	int SET_MAX = 1001;
    	
        int l=0;
    	int h=arr.length-1;
    	
    	int missingNumberMIN = 0;
    	int missingNumberMAX = SET_MAX;
    	int missingNumberMINIndex = l;
    	int missingNumberPositionMIN = 1;
    	int missingNumberPositionMAX = 1001;
    	while(l<=h) {
    		int m = l + (h-l)/2;
    		int val = arr[m];
    		int diff = val-(m+1);
    		if(diff>=k) {
    			missingNumberMAX = val;
    			missingNumberPositionMAX = diff;
    			h=m-1;
    		} else {
    			missingNumberMINIndex = m;
    			missingNumberMIN = val;
    			missingNumberPositionMIN = diff;
    			l=m+1;
    		}
    	}
    	
    	if(missingNumberMIN == 0 && missingNumberMAX>=k) {
    		return k;
    	} else if(missingNumberMAX == 1001) {
    		return missingNumberMIN + (k-missingNumberPositionMIN);
    	} else {
    		int arrIndex = missingNumberMINIndex; 
    		for(int i=missingNumberPositionMIN; i<=missingNumberPositionMAX; i++) {
    			if(arr[arrIndex] == i) {
    				arrIndex++;
    			} else {
    				missingNumberMIN++;
    				missingNumberPositionMIN++;
    			}
    			if(missingNumberPositionMIN==k) {
    				return missingNumberMIN;
    			}
    		}
    	}
    	return -1;
    }
    
	
}

