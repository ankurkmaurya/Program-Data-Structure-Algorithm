package com.ankurmaurya.heap.max;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


/*
 * Largest Number After Digit Swaps by Parity
 * 
 * Type : Easy
 * 
 * 
 * You are given a positive integer num. You may swap any two digits of num that have the same parity (i.e. both odd digits or both even digits).
 * 
 * Return the largest possible value of num after any number of swaps.
 * 
 * Example 1:
 *  Input: num = 1234
 *  Output: 3412
 *   Explanation: Swap the digit 3 with the digit 1, this results in the number 3214.
 *   Swap the digit 2 with the digit 4, this results in the number 3412.
 *   Note that there may be other sequences of swaps but it can be shown that 3412 is the largest possible number.
 *   Also note that we may not swap the digit 4 with the digit 1 since they are of different parities.
 *  
 * Example 2:
 *  Input: num = 65875
 *  Output: 87655
 *   Explanation: Swap the digit 8 with the digit 6, this results in the number 85675.
 *   Swap the first digit 5 with the digit 7, this results in the number 87655.
 *   Note that there may be other sequences of swaps but it can be shown that 87655 is the largest possible number.
 *   
 * Constraints:
 *  1 <= num <= 109
 * 
 * 
 * 
 * Solution:
 * The question was confusing first thinking about the position swaps then after reading the suggestions came to know it was 
 * digit swap but then also was thinking of the digit swap with the position wise even/odd swapping in order took long time to
 * understand but upon looking some suggestions find it was just the ordered swaps based on the even/odd descending numbers in the 
 * given number
 * 
 * 
 * 
 * ***** 3ms
 * Segregate Digits : 
 * Time Complexity  : O(klogN)
 * Space Complexity : O(N)
 *  First solution used Priority Heap to track the Even and Odd Max Heaps and then distributed the max heaps based on the occurrence of the
 *  even/odd digit in the given number sequence, also to extract the digit and res-construct used some complex but easy to  understand 
 *  mathematical calculation.
 * 
 * 
 * 
 * ***** 1ms
 * Time Complexity  : O(N)
 * Space Complexity : O(1)
 *  Second and best solution was instead of maintaining the max heap we can just maintain the array of numbers with fixed length of 10 for 
 *  0 to 9 numbers and then assign the occurrence of each digit in the given number to the position of number in the array then using the 
 *  clever digits calculations for odd/even number the final largest number is constructed.
 * 
 * 
 */



public class LargestNumberDigitSwapsByParity {
	
	public static void main(String[] args) {
		largestNumberByParitySwaps(1234, 3412);
		largestNumberByParitySwaps(65875, 87655);
		largestNumberByParitySwaps(247, 427);
		largestNumberByParitySwaps(75865, 75865);
		largestNumberByParitySwaps(98765, 98765);
		largestNumberByParitySwaps(5041119, 9405111);
	}
	
	
	public static void largestNumberByParitySwaps(int num, int answer) {
		System.out.println("Number - " + num);
		int largestInt = largestInteger(num);
		System.out.println("Largest Number Possible : " + largestInt + ", Assert : "+ (largestInt==answer));
		System.out.println();
    }
	
	
    public static int largestIntegerWithHeap(int num) {
    	PriorityQueue<int[]> oddDigitQueue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
    	PriorityQueue<int[]> evenDigitQueue = new PriorityQueue<>((a,b) -> b[0] - a[0]);
    	
    	List<Integer> numb = new ArrayList<>();
    	int quotent = num;
    	int pindex = 0;
    	while(quotent != 0) {
    		int remainder = quotent%10;
    		quotent = quotent/10;
    		
    		if(remainder%2==0) {
    			evenDigitQueue.add(new int[] {remainder, pindex});
    		} else {
    			oddDigitQueue.add(new int[] {remainder, pindex});
    		}
    		pindex++;
    		numb.add(remainder);
    	}
    	
    	int largestNumber = 0;
    	for(int numIndex = numb.size()-1; numIndex >= 0; numIndex--) {
    		int number = numb.get(numIndex);
    		if(number%2 == 0) {
    			int[] maxEvenDigit = evenDigitQueue.poll();
    			numb.set(numIndex, maxEvenDigit[0]);
    			largestNumber += Math.pow(10, numIndex)* maxEvenDigit[0];
    		} else {
    			int[] maxOddDigit = oddDigitQueue.poll();
    			numb.set(numIndex, maxOddDigit[0]);
    			largestNumber += Math.pow(10, numIndex)* maxOddDigit[0];
    		}
    	}
    	
    	return largestNumber;
    }
    
    
    public static int largestInteger(int num) {
    	int[] nums = new int[10];
    	int largestNumber = 0;
    	
    	for(int number = num ; number > 0; number /= 10) {
    		nums[number%10] += 1;
    	}
    	
    	for(char dgt : String.valueOf(num).toCharArray()) {
    		int digit = dgt - '0';
    		int start = digit%2==1?9:8;
    		
    		for(int seq=start; seq>=0 ; seq-=2) {
    			if(nums[seq]>0) {
    				largestNumber = largestNumber*10 + seq;
    				nums[seq] -= 1;
    				break;
    			}
    		}
    	}

    	return largestNumber;
    }

}




