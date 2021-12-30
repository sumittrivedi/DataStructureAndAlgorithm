package advance.week5;

import java.util.HashMap;

class Trie {
	HashMap<Character, Trie> children;
	boolean isCompleteWord;

	public Trie() {
		children = new HashMap<Character, Trie>();
		isCompleteWord = false;
	}
}

public class TrieImpl {
	Trie root = new Trie();

	public void insert(String word) {
		Trie currentNode = root;
		for (char i : word.toCharArray())
			currentNode = currentNode.children.computeIfAbsent(i, x -> new Trie());
		currentNode.isCompleteWord = true;
	}

	public boolean search(String word) {
		Trie currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			Trie tempNode = currentNode.children.get(word.charAt(i));
			if (tempNode == null)
				return false;
			currentNode = tempNode;
		}
		return currentNode.isCompleteWord;
	}
}
