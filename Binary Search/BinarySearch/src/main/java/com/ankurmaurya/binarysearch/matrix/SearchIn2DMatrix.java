package com.ankurmaurya.binarysearch.matrix;

import com.ankurmaurya.binarysearch.utility.Utilities;

/*
 * Search a 2D Matrix
 * 
 * Type : Medium
 * 
 * 
 * You are given an m x n integer matrix matrix with the following two properties:
 * 
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 * 
 * You must write a solution in O(log(m * n)) time complexity.
 * 
 * 
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * Output: true
 * 
 * 
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 * 
 * 
 * 
 * 
 */

public class SearchIn2DMatrix {

	public static void main(String[] args) {
		int[][] mat1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target1 = 3;
		Utilities.printElements(mat1);
		boolean targetFound1 = searchMatrix(mat1, target1);
		System.out.println("Target '" + target1 + "' found - " + targetFound1);
		
		int target2 = 13;
		Utilities.printElements(mat1);
		boolean targetFound2 = searchMatrix(mat1, target2);
		System.out.println("Target '" + target2 + "' found - " + targetFound2);
		
		int target3 = 60;
		Utilities.printElements(mat1);
		boolean targetFound3 = searchMatrix(mat1, target3);
		System.out.println("Target '" + target3 + "' found - " + targetFound3);
		
		int target4 = 1;
		Utilities.printElements(mat1);
		boolean targetFound4 = searchMatrix(mat1, target4);
		System.out.println("Target '" + target4 + "' found - " + targetFound4);
		
		int[][] mat2 = {{1,3,5,7,8,12,56}};
		int target5 = 13;
		Utilities.printElements(mat2);
		boolean targetFound5 = searchMatrix(mat2, target5);
		System.out.println("Target '" + target5 + "' found - " + targetFound5);
		
		int target6 = 56;
		Utilities.printElements(mat2);
		boolean targetFound6 = searchMatrix(mat2, target6);
		System.out.println("Target '" + target6 + "' found - " + targetFound6);
		
		
	}

	
    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean targetFound = false;
        
        int low = 0;
        int high = matrix.length * matrix[0].length -1;
        
        while(low<=high) {
        	int mid = low + (high - low)/2;
        	
        	int row = mid/matrix[0].length;
        	int col = mid%matrix[0].length;
        	
        	if(matrix[row][col]==target) {
        		targetFound = true;
        		break;
        	} else if(matrix[row][col] > target) {
        		high = mid - 1;
        	} else {
        		low = mid + 1;
        	}
        }
        return targetFound;
    }
	
	
	
	
}
