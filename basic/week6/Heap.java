package basic.week6;

public class Heap {
	public boolean checkMaxHeap(int[] arr) {
		boolean flag = true;
		int endIndex = arr.length -1;
		int n = endIndex % 2 == 0 ? (endIndex-2)/2 : (endIndex-1)/2;
		for(int i =0; i<n; i++) {
			if(arr[i]  < arr[2*i +1] || arr[i] < arr[2*i +2]) 
				return false;
		}
		if(arr[n]  < arr[2*n +1]) 
			return false;
		if(endIndex % 2 == 0 && arr[n]  < arr[2*n +2]) 
			return false;			
		return flag;
	}
	
	public int[] mergeMaxHeaps(int[] heapA, int[] heapB) {
		int heapAsize = heapA.length;
		int heapBsize = heapB.length;
		int mergedHeapSize = heapAsize + heapBsize;
		int[] mergedHeap = new int[mergedHeapSize];
		int i = 0, j = 0, k = 0;
		while(i < heapAsize && j < heapBsize) {
			if(heapA[i] >= heapB[j])
				mergedHeap[k++] = heapA[i++];
			else
				mergedHeap[k++] = heapB[j++];
		}
		if(i == heapAsize) {
			while(j < heapBsize)
				mergedHeap[k++] = heapB[j++];
		}
		if(j == heapBsize) {
			while(i < heapAsize)
				mergedHeap[k++] = heapA[i++];
		}
		return mergedHeap;
	}
}
