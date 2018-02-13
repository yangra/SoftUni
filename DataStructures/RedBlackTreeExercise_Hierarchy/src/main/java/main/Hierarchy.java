package main;

import java.util.*;

public class Hierarchy<T> implements IHierarchy<T> {

    private Node root;
    //private int size;
    private Map<T, Node> nodesByValue;

    public Hierarchy(T element) {
        this.root = new Node(element, null);
//        this.size = 1;
        this.nodesByValue = new LinkedHashMap<>();
        this.nodesByValue.put(element, this.root);
    }

    public void add(T parent, T child) {

//        List<Node> result = new ArrayList<>();
//        search(this.root, parent, result);
//        if ( result.isEmpty()) {
//            throw new IllegalArgumentException();
//        }
//        Node parentNode = result.remove(0);
//        search(this.root, child, result);
//        if(!result.isEmpty()){
//            throw new IllegalArgumentException();
//        }
//
//        Node childNode = new Node(child, parentNode);
//        parentNode.children.add(childNode);
//        this.size++;
        if(!this.nodesByValue.containsKey(parent)){
            throw new IllegalArgumentException("The node you are trying to add child to does not exist!");
        }

        if(this.nodesByValue.containsKey(child)){
            throw new IllegalArgumentException("There is already a node with this value in the hierarchy!");
        }

        Node parentNode = this.nodesByValue.get(parent);
        Node childNode = new Node(child,parentNode);
        parentNode.children.add(childNode);
        this.nodesByValue.put(child,childNode);

    }

    private void search(Node node, T value, List<Node> result) {

        if (node.value.equals(value)) {
            result.add(node);
        }

        for (Node child : node.children) {
           search(child, value, result);
        }

    }

    public int getCount() {
//        return this.size;
        return this.nodesByValue.size();
    }

    public void remove(T element) {
        if (!this.nodesByValue.containsKey(element)) {
            throw new IllegalArgumentException();
        }
        Node elementNode = this.nodesByValue.get(element);
        if (elementNode == this.root) {
            throw new IllegalStateException();
        }
        if (!elementNode.children.isEmpty()) {
            for (Node child : elementNode.children) {
                elementNode.parent.children.add(child);
                child.parent = elementNode.parent;
            }
        }
        elementNode.parent.children.remove(elementNode);
        this.nodesByValue.remove(element);
    }

    public boolean contains(T element) {
//        return  contains(this.root, element);
        return nodesByValue.containsKey(element);
    }

    private boolean contains(Node node, T value) {

        if(node.value.equals(value)){
            return true;
        }

        for (Node child : node.children) {
            return contains(child,value);
        }

        return false;
    }

    public T getParent(T element) {
        if (!nodesByValue.containsKey(element)) {
            throw new IllegalArgumentException("");
        }

        Node elementNode = this.nodesByValue.get(element);

        if (elementNode.parent == null) {
            return null;
        }
        return elementNode.parent.value;
    }

    public Iterable<T> getChildren(T element) {
        if (!this.nodesByValue.containsKey(element)) {
            throw new IllegalArgumentException();
        }

        Node elementNode = this.nodesByValue.get(element);
        List<T> children = new ArrayList<>();
        for (Node child : elementNode.children) {
            children.add(child.value);
        }
        return children;
    }

    public Iterable<T> getCommonElements(IHierarchy<T> other) {
        List<T> result = new ArrayList<>();
        for (T element : nodesByValue.keySet()) {
            if (other.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new HierarchyIterator();
    }

    private class Node {
        private T value;
        private Node parent;
        private List<Node> children;

        public Node(T value, Node parent) {
            this.value = value;
            this.parent = parent;
            this.children = new ArrayList<>();
        }
    }

    private class HierarchyIterator implements Iterator<T> {

        private OrderBFS order;

        public HierarchyIterator() {
            this.order = new OrderBFS(root);
        }

        @Override
        public boolean hasNext() {
            return order.hasNext();
        }

        @Override
        public T next() {
            return order.next().value;
        }
    }

    public class OrderBFS {
        private List<Node> orderedNodes;
        private Iterator<Node> iterator;


        public OrderBFS(Node element) {
            initOrderedNodes(element);
            this.iterator = orderedNodes.iterator();
        }

        private void initOrderedNodes(Node element) {
            this.orderedNodes = new ArrayList<>();
            Deque<Node> queue = new ArrayDeque<>();
            queue.offer(element);
            while (queue.size() > 0) {
                Node current = queue.poll();
                for (Node child : current.children) {
                    queue.offer(child);
                }
                this.orderedNodes.add(current);
            }
        }

        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        public Node next() {
            return this.iterator.next();
        }

    }
}
