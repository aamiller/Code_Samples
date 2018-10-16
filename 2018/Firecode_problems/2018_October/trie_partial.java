// Implement functions in trie and constructor

import java.util.*;
import java.util.streams.*;

class TrieNode {
    Character c;
    Boolean isLeaf = false;
    HashMap<Character, TrieNode> children = new HashMap<>();
    public TrieNode() {}
    public TrieNode(Character c) {
        this.c = c;
    }
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insertWord(String word) {
        // Error cases
        if (word == null || word.length() == 0) { return; }
    
        char c;
        TrieNode temp = root;
        
        // Check each letter in the word
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);

            // If key is contained, traverse to next
            if (temp.children.containsKey(c)) {
                temp = temp.children.get(c);
            } else {
                // Add the letter and point temp to it
                TrieNode newNode = new TrieNode();
                temp.children.put(c, newNode);
                temp = newNode;
            }
        }
        
        // If no children, at a leaf
        if (temp.children.size() == 0) {
            temp.isLeaf = true;
        }
    }
    
    public Boolean searchWord(String word) {
        char c;
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            // If next letter of word is in the trie
            if (temp.children.containsKey(c)) {
                temp = temp.children.get(c);
            } else {
                return false;
            }
        }
        
        // Input is only a word if a leaf
        return temp.isLeaf;
    }
    
    public Boolean searchPrefix(String word) {
        char c;
        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            
            // If next letter of word is in the trie
            if (temp.children.containsKey(c)) {
                temp = temp.children.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}