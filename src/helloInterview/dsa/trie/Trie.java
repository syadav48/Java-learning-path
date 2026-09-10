package helloInterview.dsa.trie;

public class Trie {
    private TrieNode root;
    public void createTrie(String[] words){
        root = new TrieNode();
        for(String word: words){
            insert(word);
        }
    }
    public void insert(String word){
        TrieNode node = root;
        for(char ch: word.toCharArray()){
            if(!node.children.containsKey(ch)){
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.isEndOfWord = true;
    }
    public boolean search(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                return false;
            }
            node = node.children.get(c);
        }

        return node.isEndOfWord;
    }
    public void delete(String word) {
        // Deletes the given word from the Trie.
        deleteHelper(this.root, word, 0);
    }

    private boolean deleteHelper(TrieNode node, String word, int index) {
        // base case: We have reached the end of the word
        if (index == word.length()) {
            // Mark the node as not being the end of a word
            node.isEndOfWord = false;
            // Return true if the node should be deleted
            return node.children.isEmpty();
        }

        char c = word.charAt(index);
        TrieNode child = node.children.get(c);

        if (child == null) {
            return false;  // Word not found
        }

        boolean shouldDeleteChild = deleteHelper(child, word, index + 1);

        if (shouldDeleteChild) {
            node.children.remove(c);
        }

        // Return true if current node should be deleted
        return !node.isEndOfWord && node.children.isEmpty();
    }
    public static void main(String[] args) {

    }
}
