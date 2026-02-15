package com.ankurmaurya.utils;

public class Utilities {

	public static void printElements(int[] elements) {
		System.out.print("[");
		for(int i=0; i<elements.length; i++) {
			if(i==elements.length-1){
				System.out.print(elements[i]);
			} else {
				System.out.print(elements[i] + ", ");
			}
		}
		System.out.println("]");
	}
	
	
	
}
