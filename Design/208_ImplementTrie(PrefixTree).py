class TrieNode(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.children = [None]*26
        self.isword = False
        self.char = None

class Trie(object):

    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        wd = self.root
        for c in word:
            if wd.children[ord(c)-ord("a")] is None:
                wd.children[ord(c)-ord("a")] = TrieNode()
                wd.children[ord(c)-ord("a")].char = c
            wd = wd.children[ord(c)-ord("a")]
        wd.isword = True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        wd = self.root
        for c in word:
            cld = wd.children[ord(c)-ord("a")]
            if cld is None:
                return False
            wd = cld
        return wd.isword

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie
        that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        wd = self.root
        for c in prefix:
            cld = wd.children[ord(c)-ord("a")]
            if cld is None:
                return False
            wd = cld
        return True

# Your Trie object will be instantiated and called as such:
# trie = Trie()
# trie.insert("somestring")
# trie.search("key")