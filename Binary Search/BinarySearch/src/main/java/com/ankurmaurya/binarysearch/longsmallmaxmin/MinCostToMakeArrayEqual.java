package com.ankurmaurya.binarysearch.longsmallmaxmin;

import java.util.Arrays;
import java.util.Comparator;

import com.ankurmaurya.binarysearch.utility.Utilities;

/*
 * 
 * Minimum Cost to Make Array Equal
 * 
 * Type : Hard
 * 
 * 
 * You are given two 0-indexed arrays nums and cost consisting each of n positive integers.
 * You can do the following operation any number of times:
 * 
 * Increase or decrease any element of the array nums by 1.
 * The cost of doing one operation on the ith element is cost[i].
 * 
 * Return the minimum total cost such that all the elements of the array nums become equal.
 * 
 * 
 * 
 * Example 1:
 * Input: nums = [1,3,5,2], cost = [2,3,1,14]
 * Output: 8
 * Explanation: We can make all the elements equal to 2 in the following way:
 * - Increase the 0th element one time. The cost is 2.
 * - Decrease the 1st element one time. The cost is 3.
 * - Decrease the 2nd element three times. The cost is 1 + 1 + 1 = 3.
 * The total cost is 2 + 3 + 3 = 8.
 * It can be shown that we cannot make the array equal with a smaller cost.
 * 
 * 
 * Example 2:
 * Input: nums = [2,2,2,2,2], cost = [4,2,8,1,3]
 * Output: 0
 * Explanation: All the elements are already equal, so no operations are needed.
 * 
 * 
 * Constraints:
 * n == nums.length == cost.length
 * 1 <= n <= 10power5
 * 1 <= nums[i], cost[i] <= 10power6
 * Test cases are generated in a way that the output doesn't exceed 2power53 - 1
 * 
 * 
 * 
 * 
 * Solution:
 * 
 * BruteForce: 
 * --- Got TLE error
 * The problem can be solved with BruteForce very easily with just maintaining only constant space O(1) 
 * but runtime complexity will be O(npower2) and it gave Time Limit Exceeded(TLE) error for large input.
 * 
 * Time Complexity  : O(npower2)
 * Space Complexity : O(1)
 * 
 * 
 * First Optimization: 
 * --- Runtime 19ms Beats only 20.00% [Sort + Weighted Median]
 * In this the optimization strategy was with respect to Weighted Median.
 * The weighted median is the smallest value x such that: ∑wi>=1/2​∑w 
 * Means: The smallest value in ordered data for which the total weight accumulated up to that 
 *        value is at least half of the total weight of all data points.
 * 
 * In order to do that first the nums array need to be sorted so the complexity for this solution 
 * became O(nlogn) 
 * !!!but this weighted solution was filing for few testcase due to 'totalCostOfMedianNumber>=medianCost'
 * and it was solved by removing equality 'totalCostOfMedianNumber>medianCost'
 * 
 * Time Complexity  : O(nlogn)
 * Space Complexity : O(n)
 * 					  Since we have to maintain the dictionary of numbers with its index position to
 *                    calculate the correct cost for each number position as sorting dissolves the 
 *                    cost index of every number.
 * 
 * 
 * Second Optimization: 
 * --- Runtime 11ms Beats only 90.70% [Binary Search : Binary Search on Answer]
 * We can find the MAX and MIN of the array as the conversion will be performed on these two extreme points,
 * now we can perform Binary Search on numbers lying between these two end points and as per observation the 
 * target number giving min cost will be lying between these end point and we can perform selection based on
 * the total cost of mid and mid+1 number and based on the lower cost of the mid or mid+1 number we can 
 * eliminate the invalid half.
 * 
 * Time Complexity  : O(nlog(Maxnum−Minnum))
 * Space Complexity : O(1)
 * 
 * 
 * 
 */


public class MinCostToMakeArrayEqual {

	public static void main(String[] args) {

		 int[] nums1 = {1,3,5,2};
		 int[] cost1 = {2,3,1,14};
		 //int[] cost1 = {2,3,14,1};
		 System.out.print("Numbers : ");
		 Utilities.printElements(nums1);
		 System.out.print("Cost : ");
		 Utilities.printElements(cost1);
		 long minCost1 = minCostOptimizedBinarySearch(nums1, cost1);
		 System.out.println("Min Cost to make the array equal '" + minCost1 + "'");
		 System.out.println();
		 
		 
		 int[] nums2 = {2,2,2,2,2};
		 int[] cost2 = {4,2,8,1,3};
		 System.out.print("Numbers : ");
		 Utilities.printElements(nums2);
		 System.out.print("Cost : ");
		 Utilities.printElements(cost2);
		 long minCost2 = minCostOptimizedBinarySearch(nums2, cost2);
		 System.out.println("Min Cost to make the array equal '" + minCost2 + "'");
		 System.out.println();
		 
		 
		 int[] nums3 = {735103,366367,132236,133334,808160,113001,49051,735598,686615,665317,999793,426087,587000,649989,509946,743518};
		 int[] cost3 = {724182,447415,723725,902336,600863,287644,13836,665183,448859,917248,397790,898215,790754,320604,468575,825614};
		 System.out.print("Numbers : ");
		 Utilities.printElements(nums3);
		 System.out.print("Cost : ");
		 Utilities.printElements(cost3);
		 long minCost3 = minCostOptimizedBinarySearch(nums3, cost3);
		 System.out.println("Min Cost to make the array equal '" + minCost3 + "'");
		 System.out.println();
		 
		 
		 int[] nums4 = {7,4};
		 int[] cost4 = {7,6};
		 System.out.print("Numbers : ");
		 Utilities.printElements(nums4);
		 System.out.print("Cost : ");
		 Utilities.printElements(cost4);
		 long minCost4 = minCostOptimizedBinarySearch(nums4, cost4);
		 System.out.println("Min Cost to make the array equal '" + minCost4 + "'");
		 System.out.println();
		 
	}
	
	
	
	public static long minCostBruteForce(int[] nums, int[] cost) {
        long minCost = Long.MAX_VALUE;
        long minCostNum = Long.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
        	long runningNumCost = 0L;
        	for(int j=0; j<nums.length; j++) {
        		if(nums[i]==nums[j]) {
        			continue;
        		}
        		
        		long diff;
        		if(nums[i]<nums[j]) {
        			diff = (long)nums[j] - nums[i];
        		} else {
        			diff = (long)nums[i] - nums[j];
        		}
        		
        		runningNumCost +=diff*cost[j];
        	}
        	
        	if(minCost>runningNumCost) {
        		minCostNum = nums[i];
        		minCost = runningNumCost;
    		}
        }
        System.out.println("Number which gives Minimum Cost is " + minCostNum);
        return minCost;
    }
	
	
	
    public static long minCostOptimizedWeightedMedian(int[] nums, int[] cost) {
        long minCost = 0L;

        NumberWithIndex[] temp = new NumberWithIndex[nums.length];
        long totalCost = 0;
        for (int i = 0; i < nums.length; i++) {
            temp[i] = new NumberWithIndex(nums[i], i);
            totalCost += cost[i];
        }
        long medianCost = totalCost/2;
        
        
        Arrays.sort(temp, Comparator.comparingInt(n -> n.value));
        long totalCostOfMedianNumber = 0L;
        int medianNumber = -1;
        for (NumberWithIndex n : temp) {
        	totalCostOfMedianNumber += cost[n.originalIndex];
        	if(totalCostOfMedianNumber>medianCost) {
        		medianNumber = n.value;
        		break;
        	}
        }
        //System.out.println("Toatl Cost '" + totalCost + "', Median Cost '" + medianCost + "', Median Min Cost Number '" + medianNumber + "'");
        System.out.println("Number which gives Minimum Cost is " + medianNumber);

        for (NumberWithIndex n : temp) {
    		if(n.value==medianNumber) {
    			continue;
    		}
    		
    		long diff;
    		if(medianNumber<n.value) {
    			diff = (long)n.value - medianNumber;
    			
    		} else {
    			diff = (long)medianNumber - n.value;
    		}
    		
    		minCost +=diff*cost[n.originalIndex];
    		
    	}
        return minCost;
    }
    
    
    
    public static long minCostOptimizedBinarySearch(int[] nums, int[] cost) {
        long minCost = 0L;
        
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
        	if(nums[i]<minNum) {
        		minNum = nums[i];
        	}
        	if(nums[i]>maxNum) {
        		maxNum = nums[i];
        	}
        }
        System.out.println("Arrays Min Number '" + minNum +"' and Max Number '" + maxNum + "'");

        
        int low = minNum;
        int high = maxNum;
        while(low<=high) {
        	int mid = low + (high - low)/2;
        	
        	long midNumCost = getTotalNumsChangingCost(nums, cost, mid);
        	long midNextNumCost = getTotalNumsChangingCost(nums, cost, mid+1);
        	
        	if(midNumCost<midNextNumCost) {
        		minCost = midNumCost;
        		high = mid - 1;
        	} else {
        		minCost = midNextNumCost;
        		low = mid + 1;
        	}
        }
        System.out.println("Binary Search Low Number '" + low +"' and High Number '" + high + "'");
        
        return minCost;
    }
    public static long getTotalNumsChangingCost(int[] nums, int[] cost, int targetNum) {
    	long changingCost = 0L;
        for(int i=0; i<nums.length; i++) {
        		if(nums[i]==targetNum) {
        			continue;
        		}
        		
        		long diff;
        		if(nums[i]<targetNum) {
        			diff = (long)targetNum - nums[i];
        			
        		} else {
        			diff = (long)nums[i] - targetNum;
        		}
        		
        		changingCost +=diff*cost[i];
        }
    	return changingCost;
    } 
    

}


class NumberWithIndex {
    int value;
    int originalIndex;

    NumberWithIndex(int value, int originalIndex) {
        this.value = value;
        this.originalIndex = originalIndex;
    }
}

