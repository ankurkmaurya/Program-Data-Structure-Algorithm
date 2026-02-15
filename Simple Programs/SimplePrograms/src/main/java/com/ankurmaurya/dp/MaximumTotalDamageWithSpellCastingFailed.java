package com.ankurmaurya.dp;

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
 * 1 <= power.length <= 105
 * 1 <= power[i] <= 109
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
		int[] power1 = {1,1,3,4};
		int[] power2 = {7,1,6,6};
		int[] power3 = {7,1,6,3}; //11  //exp 10
		
		
		Utilities.printElements(power1);
		long maxPossibleDamage1 = maximumTotalDamageBruteForce(power1);
		System.out.println("The possible maximum damage is'" + maxPossibleDamage1 + "'");
		
		Utilities.printElements(power2);
		long maxPossibleDamage2 = maximumTotalDamageBruteForce(power2);
		System.out.println("The possible maximum damage is'" + maxPossibleDamage2 + "'");
		
		Utilities.printElements(power3);
		long maxPossibleDamage3 = maximumTotalDamageBruteForce(power3);
		System.out.println("The possible maximum damage is'" + maxPossibleDamage3 + "'");
		
		
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
