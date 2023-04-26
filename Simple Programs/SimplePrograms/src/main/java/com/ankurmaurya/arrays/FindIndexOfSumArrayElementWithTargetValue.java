
package com.ankurmaurya.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ankur Maurya
 * 
 */
public class FindIndexOfSumArrayElementWithTargetValue {

    public static void main(String[] args) {
        System.out.println("Find Index Of Array Element having Sum with Target Value");
        int targetValue = 7;
        int[] dataValues = {3, 6, 5, 8, 2, 9, 7, 1, 0};
        
        Map<Integer, Integer> dataWithPositions = new HashMap<>();
        //mark the available data set with positions
        for (int i = 0; i < dataValues.length; i++) {
            dataWithPositions.put(dataValues[i], i);
        }
        
        for (int j = 0; j < dataValues.length; j++) {
            int valA = dataValues[j];
            int valB = targetValue - valA;
            
            if(dataWithPositions.containsKey(valB)){
              System.out.println(valA + " + " + valB +" = " + targetValue + ", Index (" + j + "," + dataWithPositions.get(valB) + ")"); 
              //dataWithPositions.remove(valA);
            }
        }
    }
}
