package com.ankurmaurya.binarysearch.matrix;

import com.ankurmaurya.binarysearch.utility.Utilities;


/*
 * 
 * Count Negative Numbers in a Sorted Matrix
 * 
 * Type : Medium
 * 
 * 
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, 
 * return the number of negative numbers in grid.
 * 
 * 
 * Example 1:
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 * 
 * 
 * Example 2:
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 * 
 * 
 * Constraints:
 * 
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 * 
 * 
 * Follow up: Could you find an O(n + m) solution?
 * 
 * 
 * 
 * Solution:
 * Time Complexity  : O(m + n)
 * Space Complexity : O(1)
 * 
 * 
 * 
 * 
 */


public class CountNegativeInSortedMatrix {

	public static void main(String[] args) {

		int[][] mat1 = { { 3, 2 }, { 1, 0 } };
		Utilities.printElements(mat1);
		int sp1 = countNegatives(mat1);
		System.out.println("Negative Numbers found in Grid '" + sp1 + "'");

		int[][] mat2 = { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
		Utilities.printElements(mat2);
		int sp2 = countNegatives(mat2);
		System.out.println("Negative Numbers found in Grid '" + sp2 + "'");

		int[][] mat3 = { { 4, 3, 2, 1 }, { 3, 2, 1, 0 }, { 2, 1, 0, -1 }, { 1, 0, -1, -2 } };
		Utilities.printElements(mat3);
		int sp3 = countNegatives(mat3);
		System.out.println("Negative Numbers found in Grid '" + sp3 + "'");

	}

	public static int countNegatives(int[][] grid) {
		int negativeCounts = 0;

		int column = grid[0].length - 1;
		for (int row = 0; row < grid.length; row++) {
			int colEndIndex = grid[row].length - 1;
			if (grid[row][colEndIndex] >= 0) {
				continue;
			}
			if (grid[row][0] < 0) {
				negativeCounts += colEndIndex + 1;
				continue;
			}

			while (grid[row][column] < 0 && column > 0) {
				column--;
			}

			if (grid[row][column] >= 0) {
				negativeCounts += colEndIndex - column;
			}
		}

		return negativeCounts;
	}

}
