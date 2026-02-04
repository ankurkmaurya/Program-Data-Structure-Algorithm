package com.ankurmaurya.strings;

import java.util.ArrayList;
import java.util.List;

public class RepeatedCharactersAlphabeticallyGrouping {

	private static String dataSequence = "aabbdddeeffgggggggghhhiiiiiiijj";
	//private static String dataSequence = "xyyyyyyyyyyyzzzz";

	
	 public static void main(String[] args) {
		List<String> dataSets = new ArrayList<>();
		
		char previouschar = ' ';
		int indexPosition = 0;
		for(int i=0; i< dataSequence.length(); i++) {       
			char currentChar = dataSequence.charAt(i); 
			if(currentChar!=previouschar) {
				indexPosition = 0;		
				previouschar = currentChar;
			} else {
				indexPosition++;
			}
			
			if((indexPosition+1)<=dataSets.size()) {
				dataSets.set(indexPosition, dataSets.get(indexPosition) + "" + currentChar);
			} else {
				dataSets.add(indexPosition, "" + currentChar);
			}
		}
		for(String dataSet : dataSets) {
			System.out.println(dataSet);
		}	  
	 }
	
}





