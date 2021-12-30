package advance.week7;

public class App {

	public static void main(String[] args) {
		int[] hist = { 5,7,5,7,6,2,4,3,1,6};
		Histogram histogram = new Histogram();
		System.out.println("Maximum Histogram Area = "+histogram.maxArea(hist));
	}

}
