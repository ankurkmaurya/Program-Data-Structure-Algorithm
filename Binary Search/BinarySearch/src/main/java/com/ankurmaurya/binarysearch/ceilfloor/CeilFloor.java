package com.ankurmaurya.binarysearch.ceilfloor;

import com.ankurmaurya.binarysearch.utility.Utilities;

public class CeilFloor {

	
	public static void main(String[] args) {
		int[] elements = {0,1,3,5,7,7,7,8,9,12,23,34,45};
		Utilities.printElements(elements);
		
		int target1 = 6;
		boolean returnTargetIfExists1 = false;
		System.out.println("Floor of target '" + target1 + "' is : " + (Utilities.findFloor(elements, target1, returnTargetIfExists1)));
		System.out.println("Ceil of target '" + target1 + "' is : " + (Utilities.findCeil(elements, target1, returnTargetIfExists1)));
		System.out.println();
		
		int target2 = 7;
		boolean returnTargetIfExists2 = false;
		boolean returnTargetIfExists21 = true;
		System.out.println("Floor of target '" + target2 + "' is : " + (Utilities.findFloor(elements, target2, returnTargetIfExists2)));
		System.out.println("Ceil of target '" + target2 + "' is : " + (Utilities.findCeil(elements, target2, returnTargetIfExists2)));
		System.out.println();
		System.out.println("Floor of target '" + target2 + "' is : " + (Utilities.findFloor(elements, target2, returnTargetIfExists21)));
		System.out.println("Ceil of target '" + target2 + "' is : " + (Utilities.findCeil(elements, target2, returnTargetIfExists21)));
		System.out.println();
		
		int target3 = 0;
		boolean returnTargetIfExists3 = false;
		System.out.println("Floor of target '" + target3 + "' is : " + (Utilities.findFloor(elements, target3, returnTargetIfExists3)));
		System.out.println("Ceil of target '" + target3 + "' is : " + (Utilities.findCeil(elements, target3, returnTargetIfExists3)));
		System.out.println();
	}
	
	
	
	
	
}
