package Trie;

public class TrieNode {
	TrieNode[] children;
    boolean isEOW;

    TrieNode()
    {
        children = new TrieNode[26];
        isEOW = false;
    }
}
