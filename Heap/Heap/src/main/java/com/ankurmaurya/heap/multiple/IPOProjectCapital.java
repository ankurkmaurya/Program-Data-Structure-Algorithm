package com.ankurmaurya.heap.multiple;

import java.util.Arrays;
import java.util.PriorityQueue;

import com.ankurmaurya.heap.utility.Utilities;

/*
 * 
 * IPO
 * 
 * Type : Hard
 * 
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. 
 * Since it has limited resources, it can only finish at most k distinct projects before the IPO. 
 * Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 * 
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
 * 
 * Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 * 
 * Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
 * 
 * The answer is guaranteed to fit in a 32-bit signed integer.
 * 
 * 
 * 
 * Example 1:
	Input: k = 2, w = 0, profits = [1,2,3], capital = [0,1,1]
	Output: 4
	
	Explanation: Since your initial capital is 0, you can only start the project indexed 0.
	After finishing it you will obtain profit 1 and your capital becomes 1.
	With capital 1, you can either start the project indexed 1 or the project indexed 2.
	Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
	Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.


   Example 2:
	Input: k = 3, w = 0, profits = [1,2,3], capital = [0,1,2]
	Output: 6
 * 
 * 
 * 
 * Constraints:
 *  1 <= k <= 10power5
 *  0 <= w <= 10power9
 *  n == profits.length
 *  n == capital.length
 *  1 <= n <= 10power5
 *  0 <= profits[i] <= 10power4
 *  0 <= capital[i] <= 10power9
 * 
 * 
 * Solution:
 *   Time Complexity  : O(nlogn + klogn)
 *   Space Complexity : O(N)
 * 
 * 
 *   Though being Hard problem through intuition I was able to think about the solution very easily with no hint, 
 *   implementation was also not that difficult but for few test cases it was failing not because of the extreme 
 *   values of the data but due to some misunderstanding about the program exit conditions suppose if there will 
 *   be no capital to handle the next project which require more capital then the existing available capital the 
 *   program should exit, which it was not doing but after doing some debugging through print statements I was able 
 *   to determine that when there will be no more projects in the project queue then only the program should break
 *   the loop and exit sooner instead of exploring for all the K projects (Test-case which is commented).
 * 
 * 
 * Learning: Think about the problem statement logically through real life scenarios and consider the extreme 
 *           cases while implementation, even if the problem is hard sometimes it has a very easy solution in terms 
 *           of the logic and implementation.
 *  
 * 
 * 
 * 
 */


public class IPOProjectCapital {

	
	public static void main(String[] args) {
		
	     solution(2, 0, new int[] {1,2,3}, new int[] {0,1,1}, 4);
	     solution(3, 0, new int[] {1,2,3}, new int[] {0,1,2}, 6);
	     solution(11, 11, new int[] {1,2,3}, new int[] {11,12,13}, 17);
	     solution(2, 11, new int[] {1,2,3}, new int[] {8,9,13}, 16);
	     solution(1, 0, new int[] {1,2,3}, new int[] {1,1,2}, 0);
	     solution(2, 0, new int[] {1,2,3}, new int[] {0,9,10}, 1);
	     
		/* Failing Test-case 37 with error as wrong answer (Output - 152958, Expected - 595057)
	     solution(100000, 100000, 
	    		 new int[] {8013,9262,5853,6418,6507,6611,6521,6162,5154,7315,8322,7231,8519,5175,5944,9453,7262,6138,5308,8926,9143,6307,9050,9870,6147,8684,8169,8654,9547,5376,9001,5698,5039,
	    		            7079,5138,6132,8092,8013,9877,7364,9010,5888,6943,9255,5242,7324,5651,5108,8734,8555,6681,8450,8691,5918,5389,6293,5310,5599,5047,9987,5457,9872,8650,8958,7859,6799......}, 
	    		 new int[] {382840267,715463272,175145915,687984784,529322394,596631219,651873982,709629394,835353469,553215722,675951333,925322906,513237929,123821551,520621105,803045,278190423,
	    		            419201804,789007860,575370944,644751782,300038132,873484753,585941240,682012101,206452983,920134456,872635673,763980325,97956496,69295468,939156407,55589459,51117524,
	    		            591873877,156795819,362505963,49155265,284120664,59176246,868455166,108127286,813855049,109834024,300668152,251516742,808036401,520445076,586057105,851163236,231627156,
	    		            820422904,339794114,823584063,451168031,271081272,978717271,702868978,679598231,732550577,545255356,905289451,87947503,304490986,267257,731337588,385975287,720029624,
	    		            492506610,284825462,634825476,575913523,504762452,729852520,325534019,281706280,178016113,807944973,734483823,862015592,928918195,38931290,106718962,445904588,639102585,
	    		            545754539,976223459,776005836,301070482,862294877,731667477,915799013,459965133,462523959,924904556,194843525,224762588,799521113,752288106,787820802,735628504,982315238.....}, 
	    		 595057);
	    */
	     
	}
	
	
	public static void solution(int k, int w, int[] profits, int[] capital, int answer) {
		System.out.print("Profits - ");
		Utilities.printElements(profits);
		System.out.print("Capital - ");
		Utilities.printElements(capital);
		int result = findMaximizedCapital(k, w, profits, capital);
		System.out.println("Result   - " + result);
		System.out.println("Expected - " + answer);
		System.out.println("Assert : "+ (answer == result));
		System.out.println();
    }
	
	
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
       int finalAccumulatedCapital= w;

       int len = capital.length;
       int[][] lowCapitalProjects = new int[len][2];
       for(int cIndex = 0; cIndex < capital.length; cIndex++) {
    	   lowCapitalProjects[cIndex][0] = capital[cIndex];
    	   lowCapitalProjects[cIndex][1] = profits[cIndex];
       }
       Arrays.sort(lowCapitalProjects, (a,b) -> {
    	   return Integer.compare(a[0], b[0]);
       });
       
    	
    	PriorityQueue<int[]> lessCapitalMaxProfitQueue = new PriorityQueue<>((a,b) -> {
            return Integer.compare(b[1], a[1]);
        });
    	
    	
    	int projectIndex = 0;
    	long runningProfitCapital = finalAccumulatedCapital;
    	while(k > 0) {
    		while(projectIndex < len && lowCapitalProjects[projectIndex][0] <= runningProfitCapital) {
    			lessCapitalMaxProfitQueue.offer(lowCapitalProjects[projectIndex]);
    			projectIndex++;
    		}
    		
    		if(lessCapitalMaxProfitQueue.isEmpty()) {
    			return finalAccumulatedCapital;
    		}
	    		
			int[] maxProfitProject = lessCapitalMaxProfitQueue.poll();
			runningProfitCapital += maxProfitProject[1];
			finalAccumulatedCapital += maxProfitProject[1];
			k--;
    	}
    	
    	return finalAccumulatedCapital;
    }
	
	
	
	
}
