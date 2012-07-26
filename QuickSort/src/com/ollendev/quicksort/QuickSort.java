package com.ollendev.quicksort;

import java.util.Random;

public class QuickSort {
	public static void sort(int[] array, int start, int end) {
		if (start < end) {
			// Get the pivot
			int pivot = pivot(start - end);
			int i = start, j = end-1;

			// Swap the pivot with what's at the end of the list
			swap(array, pivot, end);

			// Find the next values to swap
			while (i <= j) {
				//Increment i until we find a value greater then the pivot
				while (array[i] < array[end]) {
					i++;
				}
				//Decrement j until we find a value less then the pivot
				while (array[j] > array[end] && j > start) {
					j--;
				}
				
				//Only swap if i and j haven't passed each other
				if (i <= j) {
					swap(array, i, j);
				}
			}
			
			//Swap the pivot back to it's position
			swap(array, i, end);
			
			//Recurse on the left side of i
			sort(array, start, i-1);
			sort(array, i+1, end);
		}
	}

	private static void swap(int[] array, int x, int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}

	private static int pivot(int size) {
		Random rand = new Random();
		return Math.abs(rand.nextInt() % size);
	}
}
