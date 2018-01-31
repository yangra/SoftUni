import java.util.ArrayList;
import java.util.List;

public class BinaryHeap<T extends Comparable<T>> {

    private List<T> heap;
    private int size;

    public BinaryHeap() {
        this.heap = new ArrayList<>();
    }

    public int size() {
        return this.size;
    }

    public void insert(T element) {
        this.heap.add(element);
        this.size++;
        this.heapifyUp(this.heap.size() - 1);
    }

    private void heapifyUp(int index) {
        if (index == 0) {
            return;
        }

        int parentIndex = (index - 1) / 2;

        int compare = this.heap.get(index).compareTo(this.heap.get(parentIndex));

        if (compare > 0) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    private void swap(int index, int parentIndex) {
        T element = this.heap.get(parentIndex);
        this.heap.set(parentIndex, this.heap.get(index));
        this.heap.set(index, element);
    }

    public T peek() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }
        return this.heap.get(0);
    }

    public T pull() {
        if (this.size == 0) {
            throw new IllegalArgumentException();
        }

        T element = this.heap.get(0);
        swap(0, this.size - 1);
        this.heap.remove(this.size - 1);
        this.size--;
        this.heapifyDown(0);
        return element;
    }

    private void heapifyDown(int index) {

        int childIndex = (2 * index) + 1;

        if (childIndex >= this.size) {
            return;
        }

        if (childIndex + 1 < this.size && this.heap.get(childIndex).compareTo(this.heap.get(childIndex + 1)) < 0) {
            childIndex = childIndex + 1;
        }

        int compare = this.heap.get(index).compareTo(this.heap.get(childIndex));

        if (compare < 0) {
            swap(index, childIndex);
            heapifyDown(childIndex);
        }
    }
}
