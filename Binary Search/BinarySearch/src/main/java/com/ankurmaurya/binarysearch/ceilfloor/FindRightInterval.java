package com.ankurmaurya.binarysearch.ceilfloor;

import java.util.Arrays;
import java.util.Comparator;

import com.ankurmaurya.binarysearch.utility.Utilities;

/*
 * Find Right Interval
 * 
 * 
 * You are given an array of intervals, where 
 * intervals[i] = [starti, endi] and each starti is unique.
 * 
 * The right interval for an interval i is an interval j such 
 * that startj >= endi and startj is minimized. Note that i may equal j.
 * 
 * Return an array of right interval indices for each interval i. 
 * If no right interval exists for interval i, then put -1 at index i.
 * 
 * 
 * Example 1:
 *  Input: intervals = [[1,2]]
 *  Output: [-1]
 *  Explanation: There is only one interval in the collection, so it outputs -1.
 * 
 * 
 * Example 2:
 *  Input: intervals = [[3,4],[2,3],[1,2]]
 *  Output: [-1,0,1]
 *  Explanation: There is no right interval for [3,4].
 *  The right interval for [2,3] is [3,4] since start0 = 3 is the smallest start that is >= end1 = 3.
 *  The right interval for [1,2] is [2,3] since start1 = 2 is the smallest start that is >= end2 = 2.
 * 
 * 
 * Example 3:
 *  Input: intervals = [[1,4],[2,3],[3,4]]
 *  Output: [-1,2,-1]
 *  Explanation: There is no right interval for [1,4] and [3,4].
 *  The right interval for [2,3] is [3,4] since start2 = 3 is the smallest start that is >= end1 = 3.
 * 
 * Solution:
 *  It will take O(nlogn) 
 */



public class FindRightInterval {

	public static void main(String[] args) {
		int[][][] intervals = { {{4,4}},
				                {{1,1},{3,4}},
				                {{3,4},{2,3},{1,2}},
				                {{4,5}, {2,5}, {6,7}},
				                {{1,2}},
				                {{3,4}, {2,3}, {1,2}},
				                {{1,4}, {2,3}, {3,4}},
								{{10,11}, {3,4}, {2,3}, {1,2}},
								{{1,4}, {2,3}, {3,4}},
								{{1,4}, {2,3}, {3,4}, {4,4}, {5,6}, {6,7}, {7,8}, {8,15}, {10,12}, {12,13}, {13,14}}
								};

		for(int k=0; k<intervals.length; k++) {
			Utilities.printElements(intervals[k]);
			int[] foundIntervals = findRightInterval(intervals[k]);
			Utilities.printElements(foundIntervals);
			System.out.println("");
		}
	}
	
    public static int[] findRightInterval(int[][] intervals) {
    	int resultLen = intervals.length;
    	int[] result = new int[resultLen];
    	
    	int[][] sortedInterval = new int[resultLen][2];
    	for(int l=0; l<sortedInterval.length; l++) {
    		sortedInterval[l][0] = intervals[l][0];
    		sortedInterval[l][1] = l;
    	}
    	Arrays.sort(sortedInterval, Comparator.comparingInt(e->e[0]));
    	
        for(int i=0; i<intervals.length; i++) {
        	int endInterval = intervals[i][1];
        	int foundIntervalIndex =  getCeilOfNumberIndex(sortedInterval, endInterval);
        	result[i] = foundIntervalIndex;
        }
    	return result;
    }
    
    
    public static int getCeilOfNumberIndex(int[][] intervals, int numberTofind) {
    	int ceilIndex = -1;
    	
    	if(intervals.length==1 && (intervals[0][0]!=numberTofind)) {
    		return ceilIndex;
    	}
    	
    	if(intervals.length==1 && (intervals[0][0]==numberTofind)) {
    		return intervals[0][1];
    	}
    	
    	boolean intervalIsAscending = true;
    	if(intervals[0][0]>intervals[1][0]) {
    		intervalIsAscending = false;
    	}

    	int low = 0;
    	int high = intervals.length-1;
    	while(low <= high) {
    		int mid = low + (high - low) / 2;
    		if(intervals[mid][0]==numberTofind) {
    			ceilIndex = intervals[mid][1];
    			return ceilIndex;
    		} else if(intervals[mid][0]>numberTofind) {
    			ceilIndex = intervals[mid][1];
    			if(intervalIsAscending) {
    			   high = mid - 1;
    			} else {
    			   low = mid + 1;
    			}
    		} else {
    			if(intervalIsAscending) {
    				low = mid + 1;
     			} else {
     				high = mid - 1;
     			}
    		}
    	}
    	return ceilIndex;
    }
    
}


