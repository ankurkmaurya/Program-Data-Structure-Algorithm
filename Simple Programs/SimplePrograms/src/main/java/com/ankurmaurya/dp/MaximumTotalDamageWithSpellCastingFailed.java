package com.ankurmaurya.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.ankurmaurya.utils.Utilities;

/*
 * 
 * 
 * A magician has various spells.
 * You are given an array power, where each element represents the damage of a spell. 
 * Multiple spells can have the same damage value.
 * 
 * It is a known fact that if a magician decides to cast a spell with a damage of power[i], 
 * they cannot cast any spell with a damage of power[i] - 2, power[i] - 1, power[i] + 1, or power[i] + 2.
 * 
 * Each spell can be cast only once.
 * Return the maximum possible total damage that a magician can cast.
 * 
 * 
 * Example 1:
 * Input: power = [1,1,3,4]
 * Output: 6
 * Explanation:
 * The maximum possible damage of 6 is produced by casting spells 0, 1, 3 with damage 1, 1, 4.
 * 
 * Example 2:
 * Input: power = [7,1,6,6]
 * Output: 13
 * Explanation:
 * The maximum possible damage of 13 is produced by casting spells 1, 2, 3 with damage 1, 6, 6.
 * 
 * 
 * Constraints:
 * 1 <= power.length <= 10 power 5
 * 1 <= power[i] <= 10 power 9
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class MaximumTotalDamageWithSpellCastingFailed {

	
	
	public static void main(String[] args) {
		//maxDamageSolution(new int[] {1,1,3,4}, 6);
		maxDamageSolution(new int[] {7,1,6,6}, 13);
		//maxDamageSolution(new int[] {7,1,6,3}, 10);
	}
	
	
	
	public static void maxDamageSolution(int[] power, int expected) {
		Utilities.printElements(power);
		long maxPossibleDamage = maximumTotalDamage(power);
		System.out.println("The possible maximum damage is'" + maxPossibleDamage + "', Assert : "+(maxPossibleDamage==expected));
	}
	
	
	 public static long maximumTotalDamage(int[] power) {
		 Arrays.sort(power);
		 
		 long maxDamage = 0;
		 int[] powerSum = new int[power.length];
		 powerSum[0] = power[0];
		 for(int i=1; i<powerSum.length; i++) {
			 powerSum[i] = power[i] + powerSum[i-1];
		 }
		 
		 
		 for(int pow : power) {
			 int pM3 = pow-3;
			 int pP3 = pow+3;
			 
			 int possibleLowestPowerIndex = getTargetFloorIndex(power, pM3);
			 int possibleHighestPowerIndex = getTargetCeilIndex(power, pP3);

			 int lowerTotalDamage = possibleLowestPowerIndex==-1?0:powerSum[possibleLowestPowerIndex];
			 int upperTotalDamage = possibleHighestPowerIndex==-1?0:
				 (powerSum[powerSum.length-1]-powerSum[possibleHighestPowerIndex-1]);
			 
			 int totalDamage = lowerTotalDamage+upperTotalDamage;	 
			 maxDamage = Math.max(maxDamage, totalDamage);
		 }
		 
		 
		 /*
		 int low=0;
		 int high=power.length-1;
		 while(low<=high) {
			 int mid = low + (high - low)/2;
			 //int pM1 = power[mid]-1;
    		 int pM3 = power[mid]-3;
    		 //int pP1 = power[mid]+1;
    		 int pP3 = power[mid]+3;
			 
			 int possibleLowestPowerIndex = getTargetFloorIndex(power, pM3);
			 int possibleHighestPowerIndex = getTargetFloorIndex(power, pP3);
			 
			
			 
			 
			 if(possibleLowestPowerIndex == possibleHighestPowerIndex) {
				 maxDamage = Math.max(maxDamage, possibleHighestPowerIndex);
				 break;
			 }
			 else if(possibleLowestPowerIndex>possibleHighestPowerIndex) {
				 maxDamage = Math.max(maxDamage, possibleLowestPowerIndex);
				 high = mid-1;
			 } else {
				 maxDamage = Math.max(maxDamage, possibleHighestPowerIndex);
				 low = mid+1;
			 }
		 }
		 */
		 return maxDamage;
	 }
	 
	 
	 
	 public static int getTargetFloorIndex(int[] power, int target) { 
		 int floorIndex = -1;
		 
		 int low = 0;
		 int high = power.length-1;
		 while(low<=high) {
			 int mid = low + (high - low)/2;
			 
			 if(power[mid]==target) {
				 floorIndex = mid;
				 break;
			 }
			 else if(power[mid]<target) {
				 floorIndex = mid;
				 low = mid +1;
			 } else {
				 high = mid-1;
			 }
		 }
		 return floorIndex;
	 }
	 
	 
	 public static int getTargetCeilIndex(int[] power, int target) { 
		 int ceilIndex = -1;
		 
		 int low = 0;
		 int high = power.length-1;
		 while(low<=high) {
			 int mid = low + (high - low)/2;
			 
			 if(power[mid]==target) {
				 ceilIndex = mid;
				 break;
			 }
			 else if(power[mid]<target) {
				 low = mid +1;
			 } else {
				 ceilIndex = mid;
				 high = mid-1;
			 }
		 }
		 return ceilIndex;
	 }
	 
	
	
	
    public static long maximumTotalDamageBruteForce(int[] power) {
    	long maxDamage = 0;
    	
    	Map<Integer, Integer> availableSpells = new HashMap<>();
        long totalSpellsDamage = 0;
    	for(int p : power) {
    		totalSpellsDamage += p;
    		if(availableSpells.containsKey(p)) {
    			availableSpells.put(p, availableSpells.get(p)+1);
    		} else {
    			availableSpells.put(p, 1);
    		}
    	}
    	
    	for(int p : power) {
    		long maxDamageWithp = totalSpellsDamage;
    		int pM1 = p-1;
    		int pM2 = p-2;
    		int pP1 = p+1;
    		int pP2 = p+2;
    		
    		if(pM1 > 0 && availableSpells.containsKey(pM1)) {
    			maxDamageWithp -= availableSpells.get(pM1)*pM1;
			}
    		if(pM2 > 0 && availableSpells.containsKey(pM2)) {
    			maxDamageWithp -= availableSpells.get(pM2)*pM2;
			}
    		if(availableSpells.containsKey(pP1)) {
    			maxDamageWithp -= availableSpells.get(pP1)*pP1;
			}
    		if(availableSpells.containsKey(pP2)) {
    			maxDamageWithp -= availableSpells.get(pP2)*pP2;
			}
    		
    		if(maxDamageWithp > maxDamage) {
    			maxDamage = maxDamageWithp;
    		}
    		availableSpells.remove(p);
    		totalSpellsDamage -= p;
    	}
    	
    	return maxDamage;
    }
	
	
}
