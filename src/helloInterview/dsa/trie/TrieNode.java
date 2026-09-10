package helloInterview.dsa.trie;

import helloInterview.dsa.dfs.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isEndOfWord;
    public TrieNode(){
        this.children = new HashMap<>();
        this.isEndOfWord = false;
    }
    public TrieNode(Map<Character, TrieNode> children, boolean eow) {
        this.children = children;
        this.isEndOfWord = eow;
    }
}
