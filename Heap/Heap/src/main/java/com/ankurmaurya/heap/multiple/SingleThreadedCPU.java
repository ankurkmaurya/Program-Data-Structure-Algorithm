package com.ankurmaurya.heap.multiple;

import java.util.Arrays;
import java.util.PriorityQueue;

import com.ankurmaurya.heap.utility.Utilities;


/*
 * 
 * Single-Threaded CPU
 * 
 * Type - Medium
 * 
 * 
 * You are given n​​​​​​ tasks labeled from 0 to n - 1 represented by a 2D integer array tasks, where tasks[i] = [enqueueTimei, processingTimei] 
 * means that the i​​​​​​th​​​​ task will be available to process at enqueueTimei and will take processingTimei to finish processing.
 * 
 * You have a single-threaded CPU that can process at most one task at a time and will act in the following way:
 *  - If the CPU is idle and there are no available tasks to process, the CPU remains idle.
 *  - If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time. 
 *    If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
 *  - Once a task is started, the CPU will process the entire task without stopping.
 *  - The CPU can finish a task then start a new one instantly.
 * 
 * Return the order in which the CPU will process the tasks.
 * 
 * 
 * Example 1:
	Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
	Output: [0,2,3,1]
	Explanation: The events go as follows:
	- At time = 1, task 0 is available to process. Available tasks = {0}.
	- Also at time = 1, the idle CPU starts processing task 0. Available tasks = {}.
	- At time = 2, task 1 is available to process. Available tasks = {1}.
	- At time = 3, task 2 is available to process. Available tasks = {1, 2}.
	- Also at time = 3, the CPU finishes task 0 and starts processing task 2 as it is the shortest. Available tasks = {1}.
	- At time = 4, task 3 is available to process. Available tasks = {1, 3}.
	- At time = 5, the CPU finishes task 2 and starts processing task 3 as it is the shortest. Available tasks = {1}.
	- At time = 6, the CPU finishes task 3 and starts processing task 1. Available tasks = {}.
	- At time = 10, the CPU finishes task 1 and becomes idle.
 * 	
 * 	
 * Example 2:
	Input: tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
	Output: [4,3,2,0,1]
	Explanation: The events go as follows:
	- At time = 7, all the tasks become available. Available tasks = {0,1,2,3,4}.
	- Also at time = 7, the idle CPU starts processing task 4. Available tasks = {0,1,2,3}.
	- At time = 9, the CPU finishes task 4 and starts processing task 3. Available tasks = {0,1,2}.
	- At time = 13, the CPU finishes task 3 and starts processing task 2. Available tasks = {0,1}.
	- At time = 18, the CPU finishes task 2 and starts processing task 0. Available tasks = {1}.
	- At time = 28, the CPU finishes task 0 and starts processing task 1. Available tasks = {}.
	- At time = 40, the CPU finishes task 1 and becomes idle.
 * 
 * 
 * 
 * Constraints:
 * ​​​​​​​	1 <= tasks.length <= 10power5
 * 	tasks[i] = [enqueueTimei, processingTimei]
 * 	1 <= enqueueTimei, processingTimei <= 10power9
 * 
 * 
 * 
 * Solution:
 *  Time Complexity  : O(NlogN)
 *  Space Complexity : O(N)
 * 
 * 
 *  ***** 336ms (9.65%)
 *   It took me less time to think about the solution then implementation, as test cases failed multiple times
 *   first implementation was almost correct where it passed more than 500 test cases but failed during the 
 *   edge cases for max limit, then it took me along time to come up with working solution resulting changing the
 *   whole implementation logic. But doing so also resulted me in runtime complexity of 336ms beating 9.65% which was 
 *   not very good solution.
 *   
 *   
 *  ***** 155ms (77.57%)
 *   This solution was very good it used the int[][] array and 1 Heap instead of 2 Heaps to find the solution where
 *   just by eliminating the 1st Heap and using the int[][] array reduced the time complexity of sorting the task from
 *   NlogN to logN as it was only required to sort the task first based on the enqueue time and to only sort the tasks first 
 *   solution was using Heap which was not efficient. Also this solution eliminated the CPU Idle Time check as this was problem
 *   was not about the CPU Idle Time but the arrival and assignment of the task based on time. 
 *   
 * Learning: Do not use the Heap data structure where there is no need to sort the data during execution and the data can be 
 *            sorted before the start of the execution where the normal sorted array is sufficient.
 *  
 *  
 *  
 */

public class SingleThreadedCPU {

	
	public static void main(String[] args) {
		
		solution(new int[][] {{1,2},{2,4},{3,2},{4,1}}, new int[] {0,2,3,1});
		solution(new int[][] {{7,10},{7,12},{7,5},{7,4},{7,2}}, new int[] {4,3,2,0,1});
		solution(new int[][] {{19,13},{16,9},{21,10},{32,25},{37,4},{49,24},{2,15},{38,41},{37,34},{33,6},{45,4},{18,18},{46,39},{12,24}}, 
				 new int[] {6,1,2,9,4,10,0,11,5,13,3,8,12,7});
		solution(new int[][] {{8,4},{5,6},{2,2},{7,2},{10,8},{2,1},{5,7},{8,9},{2,7},{3,7}}, new int[] {5,2,1,3,0,6,8,9,4,7});
		
		solution(new int[][] {{1000000000,1000000000},{1000000000,1000000000},{1000000000,1000000000},{1000000000,1000000000},{1000000000,1000000000},{1000000000,1000000000}}, 
				 new int[] {0, 1, 2, 3, 4, 5});
		
		solution(new int[][] {{49,63},{49,76},{49,57},{49,31},{49,1},{49,79},{82,11},{82,15},{82,37},{82,13},{82,58},{82,2},{82,88},{82,63},{82,87},{44,41},{72,27},{37,51},{37,33}}, 
				new int[] {18,4,3,11,6,9,7,16,8,15,17,2,10,0,13,1,5,14,12});
		
		solution(new int[][] {{59,33},{59,72},{59,52},{59,86},{59,40},{59,71},{59,83},{59,65},{59,62},{59,52},{63,56},{63,26},{63,38},{63,35},{63,2},{26,5}}, 
				new int[] {15,0,14,11,13,12,4,2,9,10,8,7,5,1,6,3});
		
	}
	
	
	public static void solution(int[][] tasks, int[] answer) {
		System.out.print("Tasks - ");
		Utilities.printElements(tasks);
		int[] result = getOrder(tasks);
		System.out.print("Result     - ");
		Utilities.printElements(result);
		System.out.print("Expected   - ");
		Utilities.printElements(answer);
		System.out.println("Assert : "+ Arrays.equals(answer, result));
		System.out.println();
    }
	
	
	public static int[] getOrderTwoHeaps(int[][] tasks) {
		int[] cpuProcessOrder = new int[tasks.length];

        PriorityQueue<int[]> taskQueue = new PriorityQueue<>((a,b) -> {
            if(a[0]==b[0]) {
                if(a[1]==b[1]){
                    return a[2]-b[2];
                } else {
                   return a[1]-b[1];
                }
            } else {
                return a[0]-b[0];
            }
        });

        PriorityQueue<int[]> waitingTaskQueue = new PriorityQueue<>((a,b) -> {
            if(a[0]==b[0]) {
                return a[1]-b[1];
            } else {
                return a[0]-b[0];
            }
        });

        int index = 0; 
        for(int[] task : tasks) {
            taskQueue.offer(new int[]{task[0], task[1], index++});    
        }

        long cpuIdleTime = 0;
        long time = taskQueue.peek()[0];
        int taskIndex=0;
        while(taskIndex < tasks.length) {
        	while(!taskQueue.isEmpty() && taskQueue.peek()[0] <= time) {
        		int[] task = taskQueue.poll();
        		waitingTaskQueue.offer(new int[]{task[1], task[2]}); 
        	}
        	
        	if(!waitingTaskQueue.isEmpty() && cpuIdleTime <= time) {
        		int[] waitingTask = waitingTaskQueue.poll();
        		cpuIdleTime = time + waitingTask[0];
        		cpuProcessOrder[taskIndex] = waitingTask[1];
        		taskIndex++;
        		time = cpuIdleTime;
        		//System.out.println("CT - " + cpuIdleTime);
        	} 

        	if(waitingTaskQueue.isEmpty() && !taskQueue.isEmpty()) {
    		   time =  Math.max(cpuIdleTime, taskQueue.peek()[0]);
    	    }
        }
        //System.out.println("CPU - " + cpuIdleTime);
        //System.out.println("T - " + time);

        return cpuProcessOrder;
	}
	
	
	public static int[] getOrder(int[][] tasks) {
		int len = tasks.length;
		int[][] sortedTask = new int[len][3];
		
		
		int index = 0; 
        for(int[] task : tasks) {
        	sortedTask[index][0] = task[0];
        	sortedTask[index][1] = task[1];
        	sortedTask[index][2] = index;
        	index++;
        }
        Arrays.sort(sortedTask, (a,b) -> {
        	return Integer.compare(a[0], b[0]);
        });
        
        
        PriorityQueue<int[]> waitingTaskQueue = new PriorityQueue<>((a,b) -> {
            if(a[1]==b[1]) {
                return a[2]-b[2];
            } else {
                return a[1]-b[1];
            }
        });

       
        int[] cpuProcessOrder = new int[tasks.length];
        long time = 0;
        int taskIndex = 0;
        int ansIndex = 0;
        while(ansIndex < len) {
        	if(waitingTaskQueue.isEmpty() && time<sortedTask[taskIndex][0]) {
        		time = sortedTask[taskIndex][0];
        	}
        	
        	while(taskIndex<len && time>=sortedTask[taskIndex][0]) {
        		waitingTaskQueue.offer(sortedTask[taskIndex]);
        		taskIndex++;
        	}
        	
        	int[] task = waitingTaskQueue.poll();
        	time += task[1];
        	cpuProcessOrder[ansIndex++] = task[2];
        }
        return cpuProcessOrder;
	}
	
	
	
}
