public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> ret = new HashSet<>();
        Trie trie = new Trie();
        for(String wd : words) {
            trie.insert(wd);
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                bk(ret, board, "", i, j, trie);
            }
        }
        return new ArrayList<String>(ret);
        // return ret;
    }
    
    private void bk(Set<String> ret, char[][] b, String tmp, int i, int j, Trie trie) {
        if(i<0 || i>=b.length || j<0 || j>=b[0].length) {
            return;
        }
        if(b[i][j] == '*') return;
        
        String curr = tmp + b[i][j];
        if(!trie.startsWith(curr)) return;
        
        if(trie.search(curr)) {
            ret.add(curr);
        }
        
        char bij = b[i][j];
        b[i][j] = '*';
        bk(ret, b, curr, i-1, j, trie);
        bk(ret, b, curr, i+1, j, trie);
        bk(ret, b, curr, i, j-1, trie);
        bk(ret, b, curr, i, j+1, trie);
        b[i][j] = bij;
    }
}

class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public String item = "";
    
    // Initialize your data structure here.
    public TrieNode() {
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return node.item.equals(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");