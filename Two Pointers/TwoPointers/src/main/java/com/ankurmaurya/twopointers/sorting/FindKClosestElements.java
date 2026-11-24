package com.ankurmaurya.twopointers.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ankurmaurya.twopointers.utility.Utilities;

/*
 * 
 * Find K Closest Elements
 * 
 * Type : Medium
 * 
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
 * 
 * An integer a is closer to x than an integer b if:
 *  a) |a - x| < |b - x|, or
 *  b) |a - x| == |b - x| and a < b
 *  
 *  
 *  
 * Example 1:
 *  Input: arr = [1,2,3,4,5], k = 4, x = 3
 *  Output: [1,2,3,4]
 *  
 * Example 2:
 *  Input: arr = [1,1,2,3,4,5], k = 4, x = -1
 *  Output: [1,1,2,3]
 *  
 * 
 * Constraints:
 *  1 <= k <= arr.length
 *  1 <= arr.length <= 104
 *  arr is sorted in ascending order.
 *  -10power4 <= arr[i], x <= 10power4
 * 
 * 
 * 
 * Solution:-
 * 
 * First Solution - 567ms (Brute Force)
 *  Time Complexity  : O(N)
 *  Space Complexity : O(1)
 *  
 *  This solution first calculates the lowest distance for each array element while tracking the 
 *  lowest distance appeared and marking the index, as it traverses the whole given array it took the
 *  maximum time to complete
 *  
 *  
 * Second Solution - 4ms (Two Pointer)
 *  Time Complexity  : O(N)
 *  Space Complexity : O(1)
 *  
 *  This solution uses the two pointer approach where it first covers all the array length and starts reducing the 
 *  elements up-to K based on the absolute value of each element located at the extreme positions of the current 
 *  pointers, since the array was sorted the result space lies between the two pointers as for any given array inputs
 *  it will just has to run (N-K) times this solution took lesser time than first solution but the Time and Space Complexity 
 *  was same as the First Solution.
 * 
 * 17 Nov 2026 :-
 *  The best Solution for this would be the Binary Search if figured out somehow, I tried to first do it through the 
 *  Binary Search only but it was failing multiple test cases. As I think Binary Search solution is possible in this 
 *  solution I will try it again in future.
 * 
 * 
 * 
 * 
 * 
 */



public class FindKClosestElements {

	public static void main(String[] args) {
		solution(new int[] {1,2,3,4,5}, 4, 3, new int[] {1,2,3,4});
		solution(new int[] {1,1,2,3,4,5}, 4, -1, new int[] {1,1,2,3});
		solution(new int[] {0,1,1,1,2,3,6,7,8,9}, 9, 4, new int[] {0,1,1,1,2,3,6,7,8});
		solution(new int[] {1,1,1,10,10,10}, 1, 9, new int[] {10});
		solution(new int[] {1,1,1,10,10,10}, 4, 1, new int[] {1,1,1,10});
		solution(new int[] {0,1,1,1,2,3,6,7,8,9}, 9, 5, new int[] {1,1,1,2,3,6,7,8,9});
		solution(new int[] {0,0,1,2,3,3,4,7,7,8}, 3, 5, new int[] {3,3,4});
		solution(new int[] {1,2,3,4,4,4,4,5,5}, 3, 3, new int[] {2,3,4});
	}
	
	
	public static void solution(int[] arr, int k, int x, int[] answer) {
		Utilities.printElements(arr);
		System.out.println("K - " + k + ", X - " + x);
		//List<Integer> closestElements = findClosestElementsTwoPointer(arr, k, x);
		List<Integer> closestElements = findClosestElementsBF(arr, k, x);
		System.out.println("Result - " + closestElements);
		System.out.println("Assert - " + Arrays.equals(closestElements.stream().mapToInt(Integer::intValue).toArray(), answer));
		System.out.println();
	}

	
	public static List<Integer> findClosestElementsTwoPointer(int[] arr, int k, int x) {
        List<Integer> closestElements = new ArrayList<>();
        int fp = 0;
        int bp = arr.length-1;
        while((bp-fp)>=k) {
            if(Math.abs(arr[fp]-x)>Math.abs(arr[bp]-x)) {
                fp++;
            } else {
                bp--;
            }
        }

        for(int index = fp; index <= bp; index++){
            closestElements.add(arr[index]);
        }
        return closestElements;
    }
	
	
	
    public static List<Integer> findClosestElementsBF(int[] arr, int k, int x) {
        List<Integer> closestElements = new ArrayList<>();

        int xIndex = getXFloorIndexBF(arr, x);
        //System.out.println("XI - " + xIndex);

        int arrLen = arr.length;
        int kCounter = 1;
        int bIndex = xIndex;
        int fIndex = xIndex;
        int xSmallestDiff = Math.abs(arr[xIndex]-x);
        while(kCounter < k) {
            int bSmallest = Integer.MAX_VALUE;
            int fSmallest = Integer.MAX_VALUE;
            if((bIndex-1) >= 0) {
              bSmallest = Math.abs(arr[bIndex-1]-x);
            }
            if((fIndex+1) < arrLen) {
              fSmallest = Math.abs(arr[fIndex+1]-x);
            }   

            //System.out.println("xSmallestDiff - " + xSmallestDiff); 
           // System.out.println("bSmallest - " + bSmallest);
           // System.out.println("fSmallest - " + fSmallest);

            if(bSmallest > xSmallestDiff && fSmallest == bSmallest){
                xSmallestDiff = bSmallest;
                bIndex = bIndex-1<0?0:bIndex-1;
                //fIndex = fIndex+1<arrLen ? fIndex+1 : arrLen-1;
                kCounter++;
            } 
            else if(bSmallest == xSmallestDiff && fSmallest == xSmallestDiff){
                xSmallestDiff = bSmallest;
                bIndex = bIndex-1<0?0:bIndex-1;
                //fIndex = fIndex+1<arrLen ? fIndex+1 : arrLen-1;
                kCounter++;
            } 
            else if(bSmallest >= xSmallestDiff && fSmallest > bSmallest){
                xSmallestDiff = bSmallest;
                bIndex = bIndex-1<0?0:bIndex-1;
                kCounter++;
            } 
            else if(fSmallest >= xSmallestDiff && bSmallest > fSmallest){
                xSmallestDiff = fSmallest;
                fIndex = fIndex+1<arrLen ? fIndex+1 : arrLen-1;
                kCounter++;
            }  

        }

        //System.out.println("bIndex - " + bIndex);
        //System.out.println("fIndex - " + fIndex);

        //int sIndex=(bIndex<0)?0:bIndex;
         //System.out.println("as --> - " + sIndex);

        for(int index=bIndex; index<(bIndex+k); index++) {
            closestElements.add(arr[index]); 
        }
        return closestElements;
    }
	
	
	private static int getXFloorIndexBF(int[] arr, int x) {
        int lowIndex = -1;
        int lowestDiff = Integer.MAX_VALUE;

        for(int index = 0; index < arr.length; index++) {
            int cDiff = Math.abs(arr[index]-x);  
            if(cDiff < lowestDiff){
               lowestDiff =  cDiff;
               lowIndex = index;
            }
            if(cDiff == 0){
               break; 
            }
        }
        return lowIndex;
    }
	

}






