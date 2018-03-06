import java.util.Iterator;

public class Dictionary<TKey extends Comparable<TKey>, TValue> implements Iterable <KeyValue<TKey,TValue>>{

    private HashTable<TKey, TValue> info;

    public Dictionary() {
        this.info = new HashTable<>();
    }

    @Override
    public Iterator<KeyValue<TKey, TValue>> iterator() {
        return this.info.iterator();
    }

    public boolean containsKey(TKey key) {
        return this.info.containsKey(key);
    }

    public void add(TKey key, TValue value) {
        this.info.add(key, value);
    }

    public void addOrReplace(TKey key, TValue value){
        this.info.addOrReplace(key, value);
    }

    public TValue get(TKey key) {
        return this.info.get(key);
    }

    public Iterable<KeyValue<TKey, TValue>> sortByKey() {
        return this.info.sortByKey();
    }

    public KeyValue<TKey, TValue> find(TKey key) {
       return this.info.find(key);
    }
}
