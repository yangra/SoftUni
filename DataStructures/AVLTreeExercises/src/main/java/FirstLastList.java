import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FirstLastList<T extends Comparable<T>> implements IFirstLastList<T> {

    private ArrayList<T> elements;
    private AVL<T> avlTree;

    public FirstLastList() {
        this.elements = new ArrayList<>();
        this.avlTree = new AVL<>();
    }

    @Override
    public void add(T element) {
        this.elements.add(element);
        this.avlTree.insert(element);
    }

    @Override
    public int getCount() {
        return this.elements.size();
    }

    @Override
    public Iterable<T> first(int count) {
        if (this.elements.size() < count) {
            throw new IllegalArgumentException();
        }

        List<T> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(elements.get(i));
        }

        return result;
    }

    @Override
    public Iterable<T> last(int count) {
        if (this.elements.size() < count) {
            throw new IllegalArgumentException();
        }

        List<T> result = new ArrayList<>();
        for (int i = elements.size() - 1; i > elements.size() - count - 1; i--) {
            result.add(elements.get(i));
        }

        return result;
    }

    @Override
    public Iterable<T> min(int count) {
        if (this.elements.size() < count) {
            throw new IllegalArgumentException();
        }

//        List<T> ordered = new ArrayList<>(this.elements);
//        ordered.sort(Comparator.naturalOrder());
//
//        ordered = ordered.subList(0, count);
        List<T> ordered = new ArrayList<>();
        this.avlTree.eachInOrder(ordered::add);
        return ordered.subList(0, count);

    }

    @Override
    public Iterable<T> max(int count) {
        if (this.elements.size() < count) {
            throw new IllegalArgumentException();
        }

//        List<T> ordered = new ArrayList<>(this.elements);
//        ordered.sort(Comparator.reverseOrder());
//
//        ordered = ordered.subList(0,count);
        return this.avlTree.max(count);

    }

    @Override
    public void clear() {
        this.elements.clear();
        this.avlTree = new AVL<>();
    }

    @Override
    public int removeAll(T element) {

        int counter = 0;

        int index = this.elements.indexOf(element);
//        while(index>=0){
//            this.elements.remove(index);
//            counter++;
//            index = this.elements.indexOf(element);
//        }
        Iterator<T> iterator = this.elements.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().compareTo(element) == 0) {
                iterator.remove();
                counter++;
            }
        }

        if(this.avlTree.contains(element)){
            this.avlTree.delete(element);
        }
        return counter;
    }

}