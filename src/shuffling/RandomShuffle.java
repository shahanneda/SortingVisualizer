package shuffling;

import graphics.Visualizer;

public class RandomShuffle {
	public static void main(String[] args) {
		
	} 
	
	public static void Shuffle(int[] arr) {
		for(int i = 0 ; i<arr.length;i++) {
			Visualizer.swap(arr, i, (int)(Math.random()*arr.length));
		}
	}
}
