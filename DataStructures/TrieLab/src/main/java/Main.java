public class Main {

    public static void main(String[] args) {
        Trie<Integer> trie = new Trie<>();
        trie.insert("there", 5);
        trie.insert("the", 3);
        trie.insert("they", 4);
        System.out.println();
    }
}
