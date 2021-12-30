package advance.week6;

public class App {

	public static void main(String args[]) {
		int array[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		String pattern = "ababcad";
		String text = "aababcadaaababcadaads";
		
		KadaneAlgorithm kadaneAlgorithm = new KadaneAlgorithm();
		System.out.println("Maximum continuous sub array value = " + kadaneAlgorithm.maxSubArray(array));
		
		RabinKarp rabinKarp = new RabinKarp();
		rabinKarp.search(pattern,text);
		
		KMPAlgorithm kmpAlgorithm =new KMPAlgorithm();
		kmpAlgorithm.kmp(pattern, text);
		
	}

}
