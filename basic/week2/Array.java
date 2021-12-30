package basic.week2;
import java.util.Iterator;
import java.util.TreeSet;

public class Array {

	int[] reverseArray(int[] array) {
		int n = array.length;
		int reverseArray[] = new int[array.length];
		for(int i = 0; i < n; i++) {
			reverseArray[i] = array[n-1-i];
		}
		return reverseArray;
	}
	
	int maxByRecursion(int[] array, int start, int end) {
		if(end > start) {
			if(array[start] >= array[end]) 
				return maxByRecursion(array, start, end-1);
			else 
				return maxByRecursion(array, start + 1, end);
		}
		return array[start];
	}
	
	private int nthMinElement(int[] array, int rank) {
		TreeSet<Integer> elements = new TreeSet<Integer>();
		for(int i = 0; i < array.length; i++) 
			elements.add(array[i]);
		Iterator<Integer> itr = elements.iterator();
		int count = 0;
		while(count < rank-1) {
			count++;
			itr.next();
		}
		return itr.next();
	}
	
	
	public static void main(String ergs[]) {
		int[] array = {5,6,8,4,2,9};
		Array object = new Array();
		int[] reverseArray = object.reverseArray(array);
		for(int i =0; i<array.length; i++) 
			System.out.println(reverseArray[i]);
		
		System.out.println("maximum element :" + object.maxByRecursion(array, 0, array.length - 1));
		System.out.println("n th minimum element :" + object.nthMinElement(array, 5));
	}
}
