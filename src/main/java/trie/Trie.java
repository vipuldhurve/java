package trie;

public class Trie {

    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    public static void main(String[] args) {
        int n = 5;
        int type[] = {1, 1, 2, 3, 2};
        String value[] = {"hello", "help", "help", "hel", "hel"};
        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            if (type[i] == 1) {
                trie.addWord(value[i]);
            }
            else if (type[i] == 2) {
                if (trie.searchWord(value[i])) {
                    System.out.println( "true" );
                }
                else {
                    System.out.println("false");
                }
            }
            else {
                if (trie.startsWith(value[i])) {
                    System.out.println("true" );
                }
                else {
                    System.out.println("false");
                }
            }
        }
    }

    public void addWord(String word){
        TrieNode currNode = root;
        for (char c: word.toCharArray()){
            if(currNode.nodes[c - 'a'] == null){
                currNode.nodes[c - 'a'] = new TrieNode();
            }
            currNode = currNode.nodes[c-'a'];
        }
        currNode.isEnd = true;
    }

    public boolean searchWord(String word){
        TrieNode currNode = root;
        for (char c: word.toCharArray()){
            if(currNode.nodes[c-'a'] == null) return false;
            else {
                currNode = currNode.nodes[c-'a'];
            }
        }
        return currNode.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode currNode = root;
        for (char c : prefix.toCharArray()){
            if(currNode.nodes[c-'a'] == null) return false;
            else {
                currNode = currNode.nodes[c-'a'];
            }
        }
        return true;
    }

    private class TrieNode{
        boolean isEnd;
        TrieNode[] nodes;

        TrieNode(){
            isEnd = false;
            nodes = new TrieNode[26];
        }
    }

}




