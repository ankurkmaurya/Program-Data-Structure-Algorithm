package com.ankurmaurya.binarysearch.longsmallmaxmin;

import com.ankurmaurya.binarysearch.utility.Utilities;

/*
 * 
 * Minimized Maximum of Products Distributed to Any Store
 * 
 * Type : Medium
 * 
 * 
 * You are given an integer n indicating there are n specialty retail stores. 
 * There are m product types of varying amounts, which are given as a 0-indexed integer array quantities, 
 * where quantities[i] represents the number of products of the ith product type.
 * 
 * You need to distribute all products to the retail stores following these rules:
 * - A store can only be given at most one product type but can be given any amount of it.
 * - After distribution, each store will have been given some number of products (possibly 0). Let x represent 
 *   the maximum number of products given to any store. You want x to be as small as possible, i.e., you want to 
 *   minimize the maximum number of products that are given to any store.
 * 
 * Return the minimum possible x.
 * 
 * Example 1:
 *  Input: n = 6, quantities = [11,6]
 *  Output: 3
 *  Explanation: One optimal way is:
 *   - The 11 products of type 0 are distributed to the first four stores in these amounts: 2, 3, 3, 3
 *   - The 6 products of type 1 are distributed to the other two stores in these amounts: 3, 3
 *  The maximum number of products given to any store is max(2, 3, 3, 3, 3, 3) = 3.
 *  
 * Example 2:
 *  Input: n = 7, quantities = [15,10,10]
 *  Output: 5
 *  Explanation: One optimal way is:
 *   - The 15 products of type 0 are distributed to the first three stores in these amounts: 5, 5, 5
 *   - The 10 products of type 1 are distributed to the next two stores in these amounts: 5, 5
 *   - The 10 products of type 2 are distributed to the last two stores in these amounts: 5, 5
 *  The maximum number of products given to any store is max(5, 5, 5, 5, 5, 5, 5) = 5.
 *  
 * Example 3:
 *  Input: n = 1, quantities = [100000]
 *  Output: 100000
 *  Explanation: The only optimal way is:
 *   - The 100000 products of type 0 are distributed to the only store.
 *  The maximum number of products given to any store is max(100000) = 100000.
 *  
 *  
 *  Constraints:
 *   m == quantities.length
 *   1 <= m <= n <= 10 power 5
 *   1 <= quantities[i] <= 10 power 5
 * 
 * 
 * 
 * Solution:
 * 
 * Optimization:
 *  44ms, Beats 44.60% 
 * 
 *  Time Complexity  : O(nlogn) 
 *  As we are performing Binary Search on the Answer it will take O(logn) time and 
 *  for each selected answer we are evaluating the number of operations with
 *  the MAX operations given by performing operation on all the array elements 
 *  with O(n), Hence O(n)*O(logn) = O(nlogn)
 *  
 *  Space Complexity : O(1)
 *  No extra space is taken for the calculation
 * 
 * 
 */



public class MiniMaxOfProductsDistributedToAnyStore {

	public static void main(String[] args) {
		int[] quantities1 = {11,6};
		int stores1 = 6;
		Utilities.printElements(quantities1);
		int maxBall1 = minimizedMaximum(stores1, quantities1);
		System.out.println("Maximum '" + maxBall1 + "' products can be given to '" + stores1 + "' stores");
		System.out.println();
		
		int[] quantities2 = {15,10,10};
		int stores2 = 7;
		Utilities.printElements(quantities2);
		int maxBall2 = minimizedMaximum(stores2, quantities2);
		System.out.println("Maximum '" + maxBall2 + "' products can be given to '" + stores2 + "' stores");
		System.out.println();
		
		int[] quantities3 = {100000};
		int stores3 = 1;
		Utilities.printElements(quantities3);
		int maxBall3 = minimizedMaximum(stores3, quantities3);
		System.out.println("Maximum '" + maxBall3 + "' products can be given to '" + stores3 + "' stores");
		System.out.println();

	}
	
	
    public static int minimizedMaximum(int n, int[] quantities) {
        int maxProducts = 0;
		
		int maxQuantity = 0;
		for(int i=0; i<quantities.length; i++) {
			if(quantities[i] > maxQuantity) {
				maxQuantity = quantities[i];
			}
		}
		
		int low = 1;
		int high = maxQuantity;
		while(low<=high) {
			int mid = low + (high-low)/2;
			int possibleMaxOper = distributeProductsToNStores(quantities, n, mid);
			if(possibleMaxOper > n) {
				low = mid+1;
			} else {
				maxProducts = mid;
				high = mid-1;
			}
		}
		
		return maxProducts;
    }
    
    
	public static int distributeProductsToNStores(int[] quantities, int stores, int maxProducts) {
		int distributions = 0;
		for(int i=0; i<quantities.length; i++) {
			
			if(quantities[i]%maxProducts==0) {
				distributions += quantities[i]/maxProducts;
			} else {
				distributions += quantities[i]/maxProducts + 1;
			}

			if(distributions > stores) {
				break;
			}
		}
		return distributions;
	}
	
}

