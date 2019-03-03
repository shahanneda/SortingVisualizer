package sorting;

import java.util.Arrays;

import graphics.Visualizer;

public class BubbleSort {
	public static void main(String[] args) {
		int[] arr = {9,7,9,44,5,6,8,3,8};
		Sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void Sort(int[] arr) {
		for(int i = 0; i<arr.length;i++) {	
			for(int j = 0; j < arr.length-1-i; j++) {
				if(arr[j] > arr[j+1])
					Visualizer.swap(arr, j, j+1);
			}
		}
	}
	public static void ReverseSort(int[] arr) {
		for(int i = 0; i>arr.length;i++) {	
			for(int j = 0; j < arr.length-1-i; j++) {
				if(arr[j] < arr[j-1])
					Visualizer.swap(arr, j, j-1);
			}
		}
	}
}
