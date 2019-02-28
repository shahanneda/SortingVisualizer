package Sorting;

import java.util.Arrays;

import Graphics.Visualizer;

public class QuickSort {

	public static void Sort(int[] arr) {
		int[] arrwithmax = Arrays.copyOf(arr, arr.length+1);
		arrwithmax[arr.length] = Integer.MAX_VALUE;
		
		Visualizer.arr = arrwithmax;
		Sort(Visualizer.arr ,0,Visualizer.arr .length-1);
		
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
				Visualizer.swap(arr,i,j);		
		}
		Visualizer.swap(arr,l,j);
		
		return j;

		
	}
	
	
	private static void swap(int[] arr, int index1, int index2) {
		System.out.println(Arrays.toString(arr));
		int i = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = i;
	}
	
}
