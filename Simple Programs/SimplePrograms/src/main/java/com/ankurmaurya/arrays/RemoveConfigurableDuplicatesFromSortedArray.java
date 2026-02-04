package com.ankurmaurya.arrays;

public class RemoveConfigurableDuplicatesFromSortedArray {

	private static int repeatedMax = 2;
	private static int[] nums = { -6, -6, -3, -1, 0, 0, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 6, 7 };

	public static void main(String[] args) {
		System.out.println("Input : ");
		for (int k = 0; k < nums.length; k++) {
			System.out.print(nums[k]);
			System.out.print(", ");
		}
		System.out.println("");
		System.out.println("Can appear at most times : " + repeatedMax);
		System.out.println("");
		
		int i = 0;
		int j = i + 1;

		int dupcnt = 1;
		System.out.println("Repated Count Values : ");
		while (j < nums.length) {
			System.out.print(dupcnt + ", ");
			if (nums[i] == nums[j] && dupcnt < repeatedMax) {
				nums[i + 1] = nums[j];
				i++;
				dupcnt++;
			} else if (nums[i] != nums[j] && dupcnt < repeatedMax) {
				nums[i + 1] = nums[j];
				i++;
				dupcnt = 1;
			} else if (nums[i] != nums[j] && dupcnt == repeatedMax) {
				nums[i + 1] = nums[j];
				i++;
				dupcnt = 1;
			}
			j++;
		}
		System.out.println(dupcnt + ", ");
		System.out.println();

		System.out.println("Elements preserved : " + (i + 1));
		System.out.println("Output : ");
		for (int k = 0; k <= i; k++) {
			System.out.print(nums[k]);
			System.out.print(", ");
		}
		for (int k = i + 1; k < nums.length; k++) {
			System.out.print("_, ");
		}
		System.out.println("");

	}

}
