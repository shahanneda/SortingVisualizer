package Sorting;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] arr = {10,16,8,5,6,7,38,856,454,34,746,25,6969,342,456944,305,12,15,6,9,9,7,3,5,3};
		Sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void Sort(int[] arr) {
		int[] arrwithmax = Arrays.copyOf(arr, arr.length+1);
		arrwithmax[arr.length] = Integer.MAX_VALUE;
		Sort(arrwithmax,0,arrwithmax.length-1);
		for(int i =0; i<arr.length;i++) 
			arr[i] = arrwithmax[i];
 	}
	private static void Sort(int[] arr, int l, int h) {
		if(l<h) {
			int j = placePivot(arr,l,h);
			Sort(arr,l,j);
			Sort(arr,j+1,h);
		}			
	}
	
	private static int placePivot(int[] arr, int l, int h) {
		int pivot = arr[l];
		int i = l;
		int j = h;
		
		while(i<j) {
			do {
				i++;
			}while(arr[i] <= pivot);
			
			do {
				j--;
			}while(arr[j] > pivot);
			if(i<j)
				swap(arr,i,j);		
		}
		swap(arr,l,j);
		
		return j;

		
	}
	private static void swap(int[] arr, int index1, int index2) {
		int i = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = i;
	}
	
}
