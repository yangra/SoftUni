package _09LinkedListTraversal;

import java.util.Iterator;

public class MyLinkedListImpl<T> implements MyLinkedList<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int count;


    @Override
    public void add(T data) {
        if (this.count == 0) {
            Node<T> node = new Node(data);
            this.firstNode = node;
            this.lastNode = node;
            this.count++;
            return;
        }
        Node<T> node = new Node(data);
        this.lastNode.setNext(node);
        node.setPrevious(this.lastNode);
        this.lastNode = node;
        this.count++;
    }

    @Override
    public boolean remove(T data) {
        if (count <= 0) {
            return false;
        }
        Node<T> node = firstNode;
        for (int i = 0; i < count; i++) {
            if (node.getData().equals(data)) {
                if (node.getPrevious() != null && node.getNext() != null) {
                    node.getPrevious().setNext(node.getNext());
                    node.getNext().setPrevious(node.getPrevious());
                }else if(node.getPrevious() == null){
                    this.firstNode = node.getNext();
                    if(this.firstNode!=null){
                        this.firstNode.setPrevious(null);
                    }else {
                        this.lastNode = null;
                    }
                }else {
                    this.lastNode = node.getPrevious();
                    if(this.lastNode!=null){
                        this.lastNode.setNext(null);
                    }else{
                        this.firstNode = null;
                    }
                }
                count--;
                return true;
            }
            node = node.getNext();
        }

        return false;
    }

    @Override
    public int getSize() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private final class ListIterator implements Iterator<T> {

        private Node<T> currentNode;

        public ListIterator() {
            currentNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return this.currentNode != null;
        }

        @Override
        public T next() {
            T data = this.currentNode.getData();
            currentNode = this.currentNode.getNext();
            return data;
        }
    }
}
