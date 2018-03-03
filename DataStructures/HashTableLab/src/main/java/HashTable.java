import java.util.*;

public class HashTable<TKey, TValue> implements Iterable<KeyValue<TKey, TValue>> {


    private static final int INITIAL_CAPACITY = 16 ;
    private LinkedList<KeyValue<TKey, TValue>>[] elements;

    private int size;

    private int capacity;

    public HashTable() {
        this.elements = new LinkedList[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public HashTable(int capacity) {
        this.elements = new LinkedList[capacity];
        this.capacity = capacity;
    }

    public void add(TKey key, TValue value) {
        if ((this.size +1)/ this.capacity >= 0.7) {
            this.grow();
        }
        int index = this.getIndex(key);
        if(this.elements[index] == null){
            this.elements[index] = new LinkedList<>();
        }

        for (KeyValue<TKey, TValue> element : elements[index]) {
            if(element.getKey().equals(key)){
                throw new IllegalArgumentException();
            }
        }

        KeyValue<TKey, TValue> kvp = new KeyValue<>(key, value);
        this.elements[index].addLast(kvp);
        this.size++;
    }

    public int size() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int capacity() {
        return this.capacity;
    }

    public boolean addOrReplace(TKey key, TValue value) {
        // add -> true
        // replace -> false
        int index = this.getIndex(key);

        if (this.elements[index] != null) {
            for (KeyValue<TKey, TValue> kvp : this.elements[index]) {
                if (kvp.getKey().equals(key)) {
                    kvp.setValue(value);
                    return false;
                }
            }
        }

        this.add(key, value);
        return true;
    }

    public TValue get(TKey key) {
        int index = this.getIndex(key);

        if (this.elements[index] != null) {
            for (KeyValue<TKey, TValue> kvp : this.elements[index]) {
                if (kvp.getKey().equals(key)) {
                    return kvp.getValue();
                }
            }
        }

        throw new IllegalArgumentException("Key is not presented in the hashtable");
    }

    public boolean tryGetValue(TKey key, TValue value) {
        throw new UnsupportedOperationException();
    }

    public KeyValue<TKey, TValue> find(TKey key) {
        int index = this.getIndex(key);

        if (this.elements[index] != null) {
            for (KeyValue<TKey, TValue> kvp : this.elements[index]) {
                if (kvp.getKey().equals(key)) {
                    return kvp;
                }
            }
        }

        return null;
    }

    public boolean containsKey(TKey key) {
        int index = this.getIndex(key);

        if (this.elements[index] != null) {
            LinkedList<KeyValue<TKey, TValue>> linkedList = this.elements[index];
            for (KeyValue<TKey, TValue> kvp : linkedList) {
                if (kvp.getKey().equals(key)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean remove(TKey key) {
        int index = this.getIndex(key);

        LinkedList<KeyValue<TKey,TValue>> linkedList = this.elements[index];
        if(linkedList!=null){
            for(KeyValue<TKey,TValue> kvp: linkedList){
                if(kvp.getKey().equals(key)){
                    linkedList.remove(kvp);
                    this.setSize(this.size() - 1);
                    return true;
                }
            }
        }

        return false;
    }

    public void clear() {
        this.setSize(0);
        this.capacity = INITIAL_CAPACITY;
        this.elements = new LinkedList[capacity];
    }

    public Iterable<TKey> keys() {
        List<TKey> keys = new ArrayList<>();
        for (LinkedList<KeyValue<TKey,TValue>> element : this.elements) {
            for (KeyValue<TKey, TValue> keyValue : element) {
                keys.add(keyValue.getKey());
            }
        }

        return keys;
    }

    public Iterable<TValue> values() {
        List<TValue> values = new ArrayList<>();
        for (LinkedList<KeyValue<TKey,TValue>> element : this.elements) {
            for (KeyValue<TKey, TValue> keyValue : element) {
                values.add(keyValue.getValue());
            }
        }

        return values;
    }

    @Override
    public Iterator<KeyValue<TKey, TValue>> iterator() {
        LinkedList<KeyValue<TKey, TValue>> hashTableIterator = new LinkedList<>();

        for (LinkedList<KeyValue<TKey, TValue>> element : this.elements) {
            if (element != null) {
                for (KeyValue<TKey, TValue> kvp : element) {
                    hashTableIterator.add(kvp);
                }
            }
        }

        return hashTableIterator.iterator();
    }

    private int getIndex(TKey key) {
        return Math.abs(key.hashCode()) % this.capacity;
    }

    private void grow() {
        HashTable<TKey,TValue> newTable = new HashTable<>(this.capacity*2);

        for (KeyValue<TKey, TValue> kvp : this) {
            newTable.add(kvp.getKey(), kvp.getValue());
        }

        this.elements = newTable.elements;
        this.capacity = newTable.capacity;
    }
}
