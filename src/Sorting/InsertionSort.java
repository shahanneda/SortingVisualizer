package sorting;
import java.util.Arrays;

import graphics.Visualizer;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10,3,4,5,6,35,6};
		
		
		Sort(nums);
//		swap(nums,0,1);
		System.out.println(Arrays.toString(nums));

	}
	
	public static void Sort(int[] arr) {
		for (int i = 0; i< arr.length;i++) {
			for(int j=i; j>0; j--) {
//				Visualizer.current1 = j-1;
//				Visualizer.current2 = j;
				if(arr[j-1] > arr[j]) {
					Visualizer.swap(arr,j-1,j); 
				}else {
					break;
				}
					
			}
		}			
	}
	
	static void swap(int[] arr, int index1, int index2) {
		System.out.printf("Swaped %s with %s\n\n", arr[index1],arr[index2]);
		int i = arr[index1]; 
		arr[index1] = arr[index2];
		arr[index2] = i;
		System.out.println(Arrays.toString(arr));
	}

}
