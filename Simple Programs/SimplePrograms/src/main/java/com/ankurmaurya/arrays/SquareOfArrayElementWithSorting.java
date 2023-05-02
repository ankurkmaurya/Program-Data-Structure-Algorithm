
package com.ankurmaurya.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Ankur Maurya
 * 
 */
public class SquareOfArrayElementWithSorting {

    
    public static void main(String[] args) {
        System.out.println("Square Array Elements and Sort");
        int[] dataValues = {3, 6, 5, -1, -3, 2, 7, 1, 0};

        String dispData = IntStream.of(dataValues).mapToObj(Integer::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Data : " + dispData);

        System.out.println("Approach : 1 (No Duplicates, Tree Set, Descending)");
        Set<Integer> dataSet = new TreeSet<>((e1, e2) -> e2.compareTo(e1));
        for (int i = 0; i < dataValues.length; i++) {
            dataSet.add(dataValues[i] * dataValues[i]);
        }
        System.out.println(dataSet);

        System.out.println("Approach : 2 (With Duplicates, Array List)");
        List<Integer> dataList = new ArrayList<>();
        List<Integer> dataList1;
        for (int i = 0; i < dataValues.length; i++) {
            dataList.add(dataValues[i] * dataValues[i]);
        }
        System.out.println("Squared : " + dataList);
        dataList1 = dataList.stream().collect(Collectors.toList());

        Collections.sort(dataList);
        Collections.sort(dataList1, (e1, e2) -> e2.compareTo(e1));
        System.out.println("Sorted Ascending  : " + dataList);
        System.out.println("Sorted Descending : " + dataList1);


    }

}
