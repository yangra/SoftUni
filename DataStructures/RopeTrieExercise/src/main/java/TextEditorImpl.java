import java.util.*;

public class TextEditorImpl implements TextEditor {

    private Trie<StringBuilder> users;
    private Map<String, Deque<StringBuilder>> cache;

    public TextEditorImpl() {
        this.users = new Trie<>();
        this.cache = new HashMap<>();
    }

    @Override
    public void login(String username) {
        this.users.insert(username, new StringBuilder());
        this.cache.put(username, new ArrayDeque<>());
    }

    @Override
    public void logout(String username) {
        this.users.delete(username);
        this.cache.remove(username);
    }

    @Override
    public void prepend(String username, String string) {
        if (!string.isEmpty()) {
            this.cacheString(username);
            this.users.getValue(username).insert(0, string);
        }

    }

    @Override
    public void insert(String username, int index, String string) {
        if (!string.isEmpty()&&index >= 0 && index <= users.getValue(username).length()) {
            this.cacheString(username);
            this.users.getValue(username).insert(index, string);
        }
    }

    @Override
    public void substring(String username, int startIndex, int length) {
        int stringLength = users.getValue(username).length();
        if (startIndex >= 0 && length > 0 && startIndex < stringLength && startIndex + length <= stringLength) {
            this.cacheString(username);
            String substring = this.users.getValue(username).substring(startIndex, startIndex + length);
            this.users.setValue(username, new StringBuilder(substring));
        }
    }

    @Override
    public void delete(String username, int startIndex, int length) {
        int stringLength = users.getValue(username).length();
        if (startIndex >= 0 && length > 0 && startIndex < stringLength && startIndex + length <= stringLength) {
            this.cacheString(username);
            this.users.getValue(username).delete(startIndex, startIndex + length);
        }
    }

    @Override
    public void clear(String username) {
        if (users.getValue(username).length() != 0) {
            this.cacheString(username);
            this.users.setValue(username, new StringBuilder());
        }
    }

    @Override
    public int length(String username) {
        return this.users.getValue(username).toString().length();
    }

    @Override
    public String print(String username) {
        return this.users.getValue(username).toString();
    }

    @Override
    public void undo(String username) {
        if (this.cache.get(username).size() == 0) {
            return;
        }

        this.users.setValue(username, this.cache.get(username).pop());
    }

    @Override
    public Iterable<String> users(String prefix) {
        return this.users.getByPrefix(prefix);
    }

    private void cacheString(String username) {
        StringBuilder builder = new StringBuilder(this.users.getValue(username).toString());
        this.cache.get(username).push(builder);
    }
}
