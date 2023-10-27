package array;

import java.util.Arrays;
import java.util.Random;

public class Ex08 {
	
	static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length -1; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Random ran = new Random();
		int[] arr = new int[1000000];	// 100만개의 정렬
		for(int i = 0; i < arr.length; i++) {
			arr[i] = ran.nextInt(arr.length);
		}
		System.out.println(Arrays.toString(arr));
		
		long start = System.currentTimeMillis();	// 정렬 전 현재 시간
		selectionSort(arr);
		long end = System.currentTimeMillis();		// 정렬 후 현재 시간
		
		System.out.println(Arrays.toString(arr));
		System.out.printf("%.2f sec\n", (end - start) / 1000.0);	// 걸린 시간
	}
	
		
	
}
