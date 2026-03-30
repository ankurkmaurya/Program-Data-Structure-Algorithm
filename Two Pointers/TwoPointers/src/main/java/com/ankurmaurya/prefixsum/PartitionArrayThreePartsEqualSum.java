package com.ankurmaurya.prefixsum;

import com.ankurmaurya.twopointers.utility.Utilities;

/*
 * Partition Array Into Three Parts With Equal Sum
 * 
 * Type : Easy
 * 
 * 
 * 
 * Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.
 * 
 * Formally, we can partition the array if we can find indexes i + 1 < j with 
 * (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])
 * 
 * 
 * 
 * Example 1
 *  Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
 *  Output: true
 *  Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 
 * 
 * Example 2:
 *  Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
 *  Output: false
 * 
 * 
 * Example 3:
 *  Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
 *  Output: true
 *  Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *  
 *  
 *  
 *  Constraints:
 *   3 <= arr.length <= 5 * 10 power 4
 *   -10 power 4 <= arr[i] <= 10 power 4
 * 
 * 
 * Solution:
 *  Time Complexity  : O(n)
 *  Space Complexity : O(n)
 * 
 * 
 * 
 */



public class PartitionArrayThreePartsEqualSum {

	public static void main(String[] args) {
		solution(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}, true);
		solution(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}, false);
		solution(new int[]{3,3,6,5,-2,2,5,1,-9,4}, true);
		solution(new int[]{6,1,1,13,-1,0,-10,20}, false);
		solution(new int[]{1,-1,1,-1}, false);
	}
	
	
	
	public static void solution(int[] nums, boolean expectedResult) {
		Utilities.printElements(nums);
		boolean canWePartition = canThreePartsEqualSum(nums);
		System.out.println("Result : " + canWePartition+", Expected : " + (expectedResult));
		System.out.println();
	}
	
	
	
	
    public static boolean canThreePartsEqualSum(int[] arr) {
        boolean canWePartition = false;

        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for(int p=1; p<arr.length; p++) {
        	prefixSum[p] = prefixSum[p-1] + arr[p];
        }
        
        for(int i=0; i<arr.length; i++) {
        	int firstSum = prefixSum[i];
        	int secondAndThirdSum = prefixSum[arr.length-1] - prefixSum[i];
        	if((firstSum*2) == secondAndThirdSum) {
        		for(int j=i+1; j<arr.length-1; j++) {
        			int secondSum = prefixSum[j]-prefixSum[i];
        			int thirdSum = prefixSum[arr.length-1] - prefixSum[j];
        			if(secondSum==thirdSum) {
        				canWePartition = true;
                		break;
        			}
        		}
        		if(canWePartition) {
        			break;
        		}
        	}
        }
        
        return canWePartition;
    }
}

