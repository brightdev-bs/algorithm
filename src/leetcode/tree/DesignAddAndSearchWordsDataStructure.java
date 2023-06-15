package leetcode.tree;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordsDataStructure {
    class WordDictionary {

        class Node {
            Map<Character, Node> children;
            boolean isWord;

            Node() {
                children = new HashMap<>();
            }
        }

        private Node root;

        public WordDictionary() {
            this.root = new Node();
        }

        public void addWord(String word) {
            Node node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(!node.children.containsKey(c)) {
                    node.children.put(c, new Node());
                }
                node = node.children.get(c);
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            return searchHelper(root, word, 0);
        }

        private boolean searchHelper(Node node, String word, int idx) {
            if (idx == word.length()) return node.isWord;

            char c = word.charAt(idx);
            if(c == '.') {
                for(Node child : node.children.values()) {
                    if(searchHelper(child, word, idx + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                Node child = node.children.get(c);
                if (child == null) return false;
                return searchHelper(child, word, idx + 1);
            }

        }
    }

}
