class TrieNode {
    // Initialize your data structure here.
	boolean isWord;
	TrieNode[] children;
    public TrieNode() {
        this.children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = this.root;
		for(char c : word.toCharArray()) {
			TrieNode tn = curr.children[c-'a'];
			if(tn == null)
				tn = new TrieNode();
			curr = tn;
		}
		curr.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = this.root;
		for(char c : word.toCharArray()) {
			TrieNode tn = curr.children[c-'a'];
			if(tn == null)
				return false;
			curr = tn;
		class TrieNode {
    // Initialize your data structure here.
	boolean isWord;
	TrieNode[] children;
    public TrieNode() {
        this.children = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = this.root;
		for(char c : word.toCharArray()) {
			if(curr.children[c-'a'] == null)
				curr.children[c-'a'] = new TrieNode();
			curr = curr.children[c-'a'];
		}
		curr.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = this.root;
		for(char c : word.toCharArray()) {
			TrieNode tn = curr.children[c-'a'];
			if(tn == null)
				return false;
			curr = tn;
		}
		return curr.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
		for(char c : prefix.toCharArray()) {
			TrieNode tn = curr.children[c-'a'];
			if(tn == null)
				return false;
			curr = tn;
		}
		return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
		return curr.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
		for(char c : word.toCharArray()) {
			TrieNode tn = curr.children[c-'a'];
			if(tn == null)
				return false;
			curr = tn;
		}
		return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");