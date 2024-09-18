package algorithm.array;

/**
 * 208. 实现 Trie (前缀树)
 */
public class Trie {
    Trie[] tries;
    boolean isEnd;
    public Trie() {
        this.tries = new Trie[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie cur = this;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(cur.tries[index] == null){
                cur.tries[index] = new Trie();
            }
            cur = cur.tries[index];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Trie cur = this;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(cur.tries[index]==null){
                return false;
            }
            cur = cur.tries[index];
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie cur = this;
        for(int i=0;i<prefix.length();i++){
            int index = prefix.charAt(i)-'a';
            if(cur.tries[index]==null){
                return false;
            }
            cur = cur.tries[index];
        }
        return true;
    }
}
