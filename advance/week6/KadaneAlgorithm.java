package advance.week6;

public class KadaneAlgorithm {
	int globalMax = Integer.MIN_VALUE;

	public int maxSubArray(int[] array) {
		int length = array.length;
		int localMax = array[0];
		for (int i=1; i<length; i++) {
			localMax = Math.max(array[i], array[i] + localMax);
			if(localMax > globalMax)
				globalMax = localMax; 
		}
		return globalMax;
	}
}
