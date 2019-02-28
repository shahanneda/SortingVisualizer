package Sorting;

import java.util.Arrays;

public class MergeSort {
	static int[] buf;
	public static void main(String[] args) {
		int[] arr = {3,5,6,7,9};
		int[] arr2 = {4,6,8,44};
		System.out.println(Arrays.toString(Merge(arr,arr2)));
		
	}
	
	public static int[] Merge(int[] one, int[] two) {
		buf = new int[one.length+two.length];
		int onePoint =0;
		int twoPoint =0; 
		
		for(int i = 0; i< (one.length+two.length);i++) {
			if(one.length < onePoint) {buf[i] = two[twoPoint]; twoPoint++;}
			else if(two.length < twoPoint) {buf[i] = one[onePoint]; onePoint++;}
			else if(one[onePoint] > two[twoPoint]) {buf[i] = two[twoPoint]; twoPoint++;}
			else if(two[twoPoint] > one[onePoint]) {buf[i] = one[onePoint]; onePoint++;}

		}
		return buf;
		
	}
}
