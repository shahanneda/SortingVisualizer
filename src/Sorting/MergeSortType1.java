package sorting;
import java.util.Arrays;

public class MergeSortType1 {
	public static void main(String[] args) {
		int[] nums = {0,1,2,3,4,5,6,76,88,99,100,11,12,13,14,15,16};
		Merge(nums,1,3,4,6);
		Sort(nums);
		System.out.println(Arrays.toString(nums));
		
//		 nums = new int[] {3,2};
//		Merge(nums,0,0,1,1);
////		Sort(nums);
//		System.out.println(Arrays.toString(nums));
		
	}
	public static void Sort(int[] arr) {
		
		int mid = arr.length/2;
		int start1 = 0;
		int end1 = mid-1;
		
		int start2 = mid;
		int end2=arr.length-1;
		
		Sort(arr,start1,end1,start2,end2);
		
		
//		Merge(arr,start1,end1,start2,end2);
	}
	
	public static void Sort(int[] arr, int start1, int end1, int start2, int end2) {
//		if(start1 == end1 ) {
//			
//		}
		if(start1>start2 || start2>end2) {
			return;
		}
		int mid1 = (end1+start1)/2;
		int ArrayOneStart = start1;
		int ArrayOneEnd = mid1;
		
		int ArrayTwoStart = mid1+1;
		int ArrayTwoEnd = end1;
		
		System.out.printf("Mid1: %s, ArrayOneStart: %s, ArrayOneEnd %s, ArrayTwoStart: %s ArrayWoEnd %s \n", mid1,ArrayOneStart,ArrayOneEnd,ArrayTwoStart,ArrayTwoEnd);

		int mid2 = (end2+start2)/2;
		int ArrayThreeStart = start2;
		int ArrayThreeEnd = mid2;
		
		int ArrayFourStart = mid2+1;
		int ArrayFourEnd = end2;
		
		Sort(arr,ArrayOneStart,ArrayOneEnd,ArrayTwoStart,ArrayTwoEnd);
		Sort(arr,ArrayThreeStart,ArrayThreeEnd,ArrayFourStart,ArrayFourEnd);

		Merge(arr, ArrayOneStart, ArrayOneEnd,ArrayTwoStart,ArrayTwoEnd);
		Merge(arr, ArrayThreeStart, ArrayThreeEnd,ArrayFourStart,ArrayFourEnd);
		System.out.printf("Mid1: %s, ArrayOneStart: %s, ArrayOneEnd %s, ArrayTwoStart: %s ArrayWoEnd %s \n", mid2,ArrayThreeStart,ArrayThreeEnd,ArrayFourStart,ArrayFourEnd);

		
		
	}
	
	public static void Merge(int[] arr, int start1, int end1, int start2, int end2) {
		int[] buf = new int[arr.length];
		int oldStart1 = start1;
		int length = end2-start1+1;//end2 - start1
		System.out.println(start2);
//		if(length==2) {
//			int firstarrElm = arr[start1];
//			int secondarrElm = arr[start2];
//			
//		}else {
			for(int i=0; i<length;i++) {
				
				if(length ==2 ) 
				{	
					int firstarrElm = arr[start1];
					int secondarrElm = arr[start2];
					int placeholder = firstarrElm;
					if(firstarrElm >= secondarrElm) {
						buf[0] = arr[start2];
						buf[1] = arr[start1];
					}
					break;
				}
				int firstarrElm = arr[start1];
				int secondarrElm = arr[start2];
				
//				System.out.printf("the elemnet in the first array is %s, the element in the second array is %s\n", firstarrElm,secondarrElm);
				if(start1>end1)      				{buf[i] = secondarrElm ;start2++;}
				else if(start2>end2) 				{buf[i] = firstarrElm  ;start1++;}

				else if(firstarrElm <= secondarrElm) {buf[i] = firstarrElm ;start1++;}
				else if(firstarrElm >= secondarrElm) {buf[i] = secondarrElm;start2++;}
				
//				System.out.println(Arrays.toString(buf));
			}
//		}
System.out.println(Arrays.toString(buf));
//          i 7
//oldStart1 7 7
// lenth    8 8
//we want   0 1
		for(int i=0; i<length;i++) {
			arr[oldStart1+i] = buf[i];
		}
		
	}
}
