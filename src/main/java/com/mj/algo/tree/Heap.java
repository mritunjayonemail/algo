package com.mj.algo.tree;

public class Heap {
	
	
	public void insert(int[] heap, int item) {
		
		// insert in heap.
		
		int n = heap.length;
		if(n==0) {
			heap[0]= item;
			return;
		}
		int index = n;
		heap[index]= item;
		while(index>=0) {
			int pIndex = index/2;
			if(heap[pIndex]<heap[index]) {
				int temp = heap[pIndex];
				heap[pIndex]= heap[index];
				heap[index] = heap[pIndex];
				index = pIndex;
			}
		}
		
	}
	
	public int  delete(int[] heap) {

		int n = heap.length;
		if(n==0){
			return -1;
		}
		
		int item = heap[0];
		int last = heap[n-1];
		heap[0] = heap[n-1];
		int ptr = 0;
		int left = 1;
		int right = 2;
		while(right<n) {
			if(heap[ptr]>=heap[left] && heap[ptr]>=heap[right]) {
				return item;
			}
			if(heap[left]> heap[right]) {
				heap[ptr] = heap[left];
				ptr= left;
			}
			else if(heap[right]> heap[left]) {
				heap[ptr] = heap[right];
				ptr= right;
			}
			left = ptr*2; right = left+1;
		}
		heap[ptr] = last;
		return item;
			
	}

}
