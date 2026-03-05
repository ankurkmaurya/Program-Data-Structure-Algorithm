package com.ankurmaurya.binarysearch.matrix;

import com.ankurmaurya.binarysearch.utility.Utilities;

/*
 * Special Positions in a Binary Matrix
 * 
 * Type : Easy
 * 
 * Given an m x n binary matrix mat, return the number of special positions in mat.
 * A position (i, j) is called special if mat[i][j] == 1 and 
 * all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 * 
 * 
 * 
 * Example 1:
 * Input: mat = [[1,0,0],[0,0,1],[1,0,0]]
 * Output: 1
 * Explanation: (1, 2) is a special position because mat[1][2] == 1 
 * and all other elements in row 1 and column 2 are 0.
 * 
 * Example 2:
 * Input: mat = [[1,0,0],[0,1,0],[0,0,1]]
 * Output: 3
 * Explanation: (0, 0), (1, 1) and (2, 2) are special positions.
 * 
 * 
 * Constraints:
 *  m == mat.length
 *  n == mat[i].length
 *  1 <= m, n <= 100
 *  mat[i][j] is either 0 or 1.
 * 
 * 
 * 
 * Solution:
 * Time Complexity: O(m*n)
 * Space Complexity: O(m+n)
 * 
 * 
 */


public class SpecialPositionsInBinaryMatrix {

	public static void main(String[] args) {
		
		int[][] mat1 = {{1,0,0},{0,0,1},{1,0,0}};
		Utilities.printElements(mat1);
		int sp1 = numSpecial(mat1);
		System.out.println("Special Positions Found '" + sp1 + "'");
		
		int[][] mat2 = {{1,0,0},{0,1,0},{0,0,1}};
		Utilities.printElements(mat2);
		int sp2 = numSpecial(mat2);
		System.out.println("Special Positions Found '" + sp2 + "'");
		
		int[][] mat3 = {{1,0,0},{0,1,1},{1,0,0}};
		Utilities.printElements(mat3);
		int sp3 = numSpecial(mat3);
		System.out.println("Special Positions Found '" + sp3 + "'");
		
		
		
		
		
	}
	
	public static int numSpecial(int[][] mat) {
		int positionCount = 0;
		
        int[] rowsSum = new int[mat.length];
        int[] colsSum = new int[mat[0].length];
        
        for(int i=0; i<mat.length; i++){
             for(int j=0; j<mat[i].length; j++){  
            	 if (mat[i][j] == 1) {
            	   rowsSum[i]++;
                   colsSum[j]++;
            	 }
             }          
        }

        for(int k=0; k<mat.length; k++){
        	if(rowsSum[k]==1) {
        		for(int l=0; l<mat[k].length; l++){   
            		if(mat[k][l]==1 && colsSum[l]==1) {
            			positionCount++;
            		}
            	 }	
        	}
        }
        
        return positionCount;
    }
	
	
	

}
