import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OrderedSet<T extends Comparable<T>> implements Iterable<T> {

    private HashTable<T, T> elements;
    private BinarySearchTree<T> order;

    public OrderedSet() {
        this.elements = new HashTable<>();
        this.order = new BinarySearchTree<>();
    }

    public void add(T element){
        elements.add(element,element);
        order.insert(element);
    }

    public boolean contains(T element){
        return this.elements.containsKey(element);
    }

    public void remove(T element){
        this.elements.remove(element);
        this.order.delete(element);
    }

    public int count(){
        return this.elements.size();
    }

    @Override
    public Iterator<T> iterator() {
        List<T> values = new ArrayList<>();
        order.eachInOrder(values::add);
        return values.iterator();
    }
}
