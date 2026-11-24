package com.ankurmaurya.heap;


import java.util.PriorityQueue;

import com.ankurmaurya.heap.utility.Utilities;


/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


public class Heap {

	public static void main(String[] args) {
		
		String[] l1 = findRelativeRanks(new int[]{5,4,3,2,1});
		Utilities.printElements(l1);
		System.out.println();
		
		String[] l2 = findRelativeRanks(new int[]{10,3,8,9,4});
		Utilities.printElements(l2);
		System.out.println();
		
		String[] l3 = findRelativeRanks(new int[]{});
		Utilities.printElements(l3);
		System.out.println();
		
		String[] l4 = findRelativeRanks(new int[]{6});
		Utilities.printElements(l4);
		System.out.println();
		
	}
	
	
	
    public static String[] findRelativeRanks(int[] score) {
        String[] ranks = new String[score.length];
        
        PriorityQueue<int[]> scoreMax = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        int position = 0;
        for(int ascore : score) {
        	scoreMax.add(new int[] {ascore, position});
        	position++;
        }
        
        PriorityQueue<int[]> awScore = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        for(int rank = 1; rank <= score.length; rank++) {
        	int[] pq = scoreMax.poll();
        	pq[0] = rank;
        	awScore.add(pq);
        }
        
        for(int positions = 0; positions < score.length; positions++) {
        	int[] aw = awScore.poll();
        	if(aw[0]==1) {
        		ranks[positions] = "Gold Medal";
        	}
        	else if(aw[0]==2) {
        		ranks[positions] = "Silver Medal";
        	}
        	else if(aw[0]==3) {
        		ranks[positions] = "Bronze Medal";
        	}
        	else {
        		ranks[positions] = String.valueOf(aw[0]);
        	}
        }
    	return ranks;
    }
	

}


