package advance.week5;

public class App {

	public static void main(String[] args) {
		TrieImpl obj = new TrieImpl();
		obj.insert("Hare");
		obj.insert("Krishna");
		System.out.println(obj.search("Hare"));
		System.out.println(obj.search("Hari"));
		System.out.println(obj.search("Kri"));
		System.out.println(obj.search("Krishna"));
		System.out.println(obj.search("Krishnaa"));

	}

}
