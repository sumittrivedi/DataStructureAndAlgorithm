package basic.week6;
public class App {

	public static void main(String[] args) {
		int arr[] = {9,7,8,3,4,5,6,1,2,3};
		Heap obj = new Heap();
		System.out.println(obj.checkMaxHeap(arr));
		
		int[] heapA = {9,8,7,3,4,5,6,2,1};
		int[] heapB = {14,12,13,9,10,11};
		int[] mergedHeap = obj.mergeMaxHeaps(heapA, heapB);
		for(int i = 0; i<mergedHeap.length; i++)
			System.out.println(mergedHeap[i]);
		
	}
}
