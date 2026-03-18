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
	
	
	public static void printElements(int[][] elements) {
		System.out.print("[");
		for(int i=0; i<elements.length; i++) {
			System.out.print("[");
			for(int j=0; j<elements[i].length; j++) {
				if(j==elements[i].length-1){
					System.out.print(elements[i][j]);
				} else {
					System.out.print(elements[i][j] + ",");
				}
			}
			if(i==elements.length-1){
				System.out.print("]");
			} else {
				System.out.print("], ");
			}
			
		}
		System.out.println("]");
	}
	
	
}
