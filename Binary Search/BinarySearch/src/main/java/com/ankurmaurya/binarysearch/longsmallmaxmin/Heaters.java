package com.ankurmaurya.binarysearch.longsmallmaxmin;

import java.util.Arrays;

import com.ankurmaurya.binarysearch.utility.Utilities;

/*
 * Heaters
 * 
 * Type : Medium
 * 
 * Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
 * Every house can be warmed, as long as the house is within the heater's warm radius range. 
 * Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
 * 
 * Notice that all the heaters follow your radius standard, and the warm radius will be the same.
 * 
 * 
 * Example 1:
 * Input: houses = [1,2,3], heaters = [2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * 
 * 
 * Example 2:
 * Input: houses = [1,2,3,4], heaters = [1,4]
 * Output: 1
 * Explanation: The two heaters were placed at positions 1 and 4. We need to use a radius 1 standard, then all the houses can be warmed.
 * 
 * 
 * Example 3:
 * Input: houses = [1,5], heaters = [2]
 * Output: 3
 * 
 * 
 * Constraints:
 *  1 <= houses.length, heaters.length <= 3 * 10 power 4
 *  1 <= houses[i], heaters[i] <= 10 power 9
 * 
 * 
 * Solution:
 *  Time Complexity  : O(nlogn + mlogm + (n+m)logk) 
 *   For Sorting the Houses and Heaters positions
 *  
 *  Space Complexity : O(1)
 *   
 * Test-cases failed for larger integer values during sum, 
 * so always check the constraints and use long data type where sum is used
 * Also was thinking to Sort the Houses and Heaters but assumed it will be sorted
 * but test-cases had unsorted data, so issue was resolved after sorting.
 *   
 * 
 */




public class Heaters {

	public static void main(String[] args) {
		solution(new int[] {1,2,3}, new int[] {2}, 1);
		solution(new int[] {1,2,3,4}, new int[] {1,4}, 1);
		solution(new int[] {1,5}, new int[] {2}, 3);
		solution(new int[] {1,2,3,4,12}, new int[] {1,4}, 8);
		solution(new int[] {1,2,3,4,12}, new int[] {1}, 11);
		solution(new int[] {1}, new int[] {1,2,3,4}, 0);
		solution(new int[] {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923}, 
				 new int[] {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612}, 161834419);
	}

	
	
	public static void solution(int[] houses, int[] heaters, int expectedResult) {
		System.out.print("Houses : ");
		Utilities.printElements(houses);
		System.out.print("Heaters : ");
		Utilities.printElements(heaters);
		int minRadius = findRadius(houses, heaters);
		System.out.println("Min. Radius for Heaters should be '" + minRadius + "', Assert : " + (expectedResult==minRadius));
		System.out.println();
	}

	
	
	public static int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int minRadius = Integer.MAX_VALUE;
		
		int maxPosition = 0;
		for(int house : houses) {
			maxPosition = house> maxPosition ? house : maxPosition;
		}
		for(int heater : heaters) {
			maxPosition = heater> maxPosition ? heater : maxPosition;
		}
		
		int low = 0;
		int high = maxPosition;
		while(low<=high) {
			int mid = low + (high - low)/2;
			boolean coversAllHouses = testRadiusCoversAllHouses(houses, heaters, mid);
			//System.out.println("coversAllHouses : "+coversAllHouses);
			if(coversAllHouses) {
				minRadius = mid<minRadius ? mid : minRadius;
				high = mid-1;
			} else {
				low = mid +1;
			}
		}
		
		return minRadius==Integer.MAX_VALUE ? 0 : minRadius;
	}
	
	
	
	public static boolean testRadiusCoversAllHouses(int[] houses, int[] heaters, int testingRadius) {
		boolean coversAllHouses = false;
		int housePositionIndex = 0;

		int heaterPositionIndex  = 0;
		while(housePositionIndex < houses.length) {
			long heaterLowerReach = (long)heaters[heaterPositionIndex] - (long)testingRadius;
			long heaterHigherReach = (long)heaters[heaterPositionIndex] + (long)testingRadius;
			
			//System.out.println("Radius : " + testingRadius +", HouseP : " + houses[housePositionIndex] +", HeaterP : " + heaters[heaterPositionIndex] 
					//+", heaterLowerReach : " + heaterLowerReach +", heaterHigherReach : " + heaterHigherReach);
			
			if(houses[housePositionIndex]>=heaterLowerReach && houses[housePositionIndex]<=heaterHigherReach) {
				coversAllHouses = true;
				housePositionIndex++;
			} else {
				heaterPositionIndex = (heaterPositionIndex+1)<=heaters.length ? (heaterPositionIndex+1) : heaterPositionIndex;
				coversAllHouses = false;
			}
			
			if(heaterPositionIndex==heaters.length) {
				break;
			}
		}
		return coversAllHouses;
	}
	
	
}




