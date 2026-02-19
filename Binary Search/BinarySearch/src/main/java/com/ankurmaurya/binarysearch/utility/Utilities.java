package com.ankurmaurya.binarysearch.utility;





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
	
	
	public static int findMax(int num1, int num2) {
		if(num1>num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	
	public static int findMin(int num1, int num2) {
		if(num1<num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	
	public static int findCeilIndex(int[] elements, int target, boolean returnTargetIndexIfExists) {
		int ceilIndexIfTargetExists = -1;
		int ceilOfTargetIndex = -1;
		if(elements.length==0) {
			return ceilOfTargetIndex;
		}
		
		int start = 0;
		int end = elements.length -1;
		
		while(start<=end) {
			int mid = start + (end - start)/2;
			
			if(elements[mid]==target) {
				ceilIndexIfTargetExists = mid;
				start = mid+1;
			}
			else if(elements[mid]>target) {
				end = mid-1;
				ceilOfTargetIndex = mid;
			}
			else {
				start = mid+1;
			}
		}
		
		if(returnTargetIndexIfExists) {
			return ceilIndexIfTargetExists;
		} else {
			return ceilOfTargetIndex;
		}
	}

	
	public static int findCeil(int[] elements, int target, boolean returnTargetIfExists) {
		int ceilOfTarget = -1;
		if(elements.length==0) {
			return ceilOfTarget;
		}
		
		int start = 0;
		int end = elements.length -1;
		
		while(start<=end) {
			int mid = start + (end - start)/2;
			
			if(elements[mid]==target) {
				if(returnTargetIfExists) {
					return elements[mid];
				} else {
					start = mid+1;
				}
			}
			else if(elements[mid]>target) {
				end = mid-1;
				ceilOfTarget = elements[mid];
			}
			else {
				start = mid+1;
			}
		}
		return ceilOfTarget;
	}
	
	
	public static int findFloorIndex(int[] elements, int target, boolean targetIndexCanBeFloor) {
		int floorOfTargetIndex = -1;
		if(elements.length==0) {
			return floorOfTargetIndex;
		}
		
		int start = 0;
		int end = elements.length -1;
		
		while(start<=end) {
			int mid = start + (end - start)/2;
			
			if(elements[mid]==target && targetIndexCanBeFloor) {
				floorOfTargetIndex = mid;
				end = mid-1;
			}
			else if(elements[mid]<target) {
				start = mid+1;
				floorOfTargetIndex = mid;
			}
			else {
				end = mid-1;
			}
		}
		return floorOfTargetIndex;
	}
	
	public static int findFloorIndex(int[] elements, int start, int end, int target, boolean targetIndexCanBeFloor) {
		int floorOfTargetIndex = -1;
		if(elements.length==0) {
			return floorOfTargetIndex;
		}
		
		int low = start;
		int high = end;
		while(low <= high) {
			int mid = low + (high - low)/2;
			
			if(elements[mid]==target && targetIndexCanBeFloor) {
				floorOfTargetIndex = mid;
				high = mid-1;
			}
			else if(elements[mid]<target) {
				low = mid+1;
				floorOfTargetIndex = mid;
			}
			else {
				high = mid-1;
			}
		}
		return floorOfTargetIndex;
	}
	
	
	public static int findFloor(int[] elements, int target, boolean returnTargetIfExists) {
    	int floorOfTarget = -1;
		if(elements.length==0) {
			return floorOfTarget;
		}
		
		int start = 0;
		int end = elements.length -1;
		
		while(start<=end) {
			int mid = start + (end - start)/2;
			
			if(elements[mid]==target) {
				if(returnTargetIfExists) {
					return elements[mid];
				} else {
					end = mid-1;
				}
			}
			else if(elements[mid]<target) {
				start = mid+1;
				floorOfTarget = elements[mid];
			}
			else {
				end = mid-1;
			}
		}
		return floorOfTarget;
	}
	
	
	public static int getMinimumNumber(int[] nums, boolean returnIndex) {
		int minIndex = -1;
		int minNumber = Integer.MAX_VALUE;
		
		int start = 0;
		int end = nums.length-1;
		while(start<=end) {
			int mid = start + (end - start)/2;
			
			if(nums[mid] == minNumber) {
				end = mid - 1;
				minNumber = nums[mid];
				minIndex = mid;
			}
			else if(nums[mid] < minNumber) {
			   end = mid - 1;
			   minNumber = nums[mid];
			   minIndex = mid;
			} 
			else {
				start = mid + 1;
			}
			//System.out.println("Number -> " + minNumber + " : Index -> " + minIndex);
		}
		
		if(returnIndex) {
			return minIndex;
		} else {
			return minNumber;
		}
	}
	
	
	public static int getMaximumNumber(int[] nums, boolean returnIndex) {
		int maxIndex = -1;
		int maxNumber = Integer.MIN_VALUE;
		
		int start = 0;
		int end = nums.length-1;
		while(start<=end) {
			int mid = start + (end - start)/2;
			
			if(nums[mid] == maxNumber) {
				start = mid + 1;
				maxNumber = nums[mid];
				maxIndex = mid;
			}
			else if(nums[mid] > maxNumber) {
			   start = mid + 1;
			   maxNumber = nums[mid];
			   maxIndex = mid;
			} 
			else {
				end = mid - 1;
			}
			//System.out.println("Number -> " + maxNumber + " : Index -> " + maxIndex);
		}
		
		if(returnIndex) {
			return maxIndex;
		} else {
			return maxNumber;
		}
	}
	
	
	
	
	
}


