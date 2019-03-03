package sorting;

import java.util.Arrays;

import graphics.Visualizer;

public class MergeSort {
	static int[] buf;
	public static void main(String[] args) {
		int[] arr = {5,6,4,5,5,888,43,44,55,34,345,6,3,5,6,8,9};
		// 0 -> 9
		// 9/2
		// 0 , 4   -> 5 , 9
		// 0 , 2   -> 3,4
		//0,1 ////  2,3
		//					3,4
//		int[] arr2 = {};
		Sort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(arr));
	}
	public static void Sort(int[] arr) {
		Sort(arr,0,arr.length-1);
	}
	public static void Sort(int[] arr, int l, int h) {
//		int mid = l + (h-1)/2;
//		int length = h-l;
//		int arrayOneLength = length/2;
//		int arrayTwoLength = length - length/2;
//		
//		if(length<= 1 ) {return;}
//		
		
		if(l < h) {
			Sort(arr,l,((l+h)/2));
			Sort(arr,((l+h)/2)+1,h);	
		}
//		Visualizer.vis.repaint();
		Merge(arr,l,((l+h)/2),((l+h)/2)+1,h);
		
		
	}
	
	public static int[] Merge(int[] arr, int l1, int h1, int l2, int h2) {
		buf = new int[h2-l1+1];
		int oldl = l1;
		int length =  h2-l1+1;
		for(int count = 0; count < length; count++ ) {
			if(l1 > h1) {
				buf[count] = arr[l2];
				l2++;
			}else if(l2 > h2) {
				buf[count] = arr[l1];
				l1++;
			}else if(arr[l1]<= arr[l2]) {
				buf[count] = arr[l1];
				l1++;
			}
			else if(arr[l2] <= arr[l1]) {
				buf[count] = arr[l2];
				l2++;
			}
			
			
		}
		for(int i = 0; i<buf.length;i++  ) {
			arr[oldl + i] = buf[i];
			Visualizer.swap(arr, oldl + i, oldl + i);
		}
		
		return buf;
	}
}
