import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QuadTreeRecursive<T extends Boundable> {

    public static final int DEFAULT_MAX_DEPTH = 5;

    private int maxDepth;

    private Node<T> root;

    private Rectangle bounds;

    private int count;

    public QuadTreeRecursive(int width, int height) {
        this(width, height, DEFAULT_MAX_DEPTH);
    }

    public QuadTreeRecursive(int width, int height, int maxDepth) {
        this.root = new Node<T>(0, 0, width, height);
        this.bounds = this.root.getBounds();
        this.maxDepth = maxDepth;
    }

    public Rectangle getBounds() {
        return this.bounds;
    }

    private void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public int getCount() {
        return this.count;
    }

    private void setCount(int count) {
        this.count = count;
    }

    public boolean insert(T item) {
        if (!item.getBounds().isInside(this.root.getBounds())) {
            return false;
        }
        insert(this.root, item, 0);
        return true;
    }

    private void insert(Node<T> node, T item, int depth) {
        if (depth == this.maxDepth) {
            node.getItems().add(item);
            this.count++;
            return;
        }

        if (node.getChildren() != null) {
            for (Node<T> child : node.getChildren()) {
                if (item.getBounds().isInside(child.getBounds())) {
                    insert(child, item, depth + 1);
                }
            }

            node.getItems().add(item);
            this.count++;
        } else {
            node.getItems().add(item);
            this.count++;
            if (node.shouldSplit()) {
                this.splitNode(node);
            }
        }
    }

    private void splitNode(Node<T> node) {
        node.setChildren((Node<T>[]) Array.newInstance(Node.class, 4));
        int newWidth = node.getBounds().getWidth() / 2;
        int newHeight = node.getBounds().getHeight() / 2;
        Node<T> quadrant1 = new Node<T>(node.getBounds().getMidX(),
                node.getBounds().getY1(), newWidth, newHeight);
        Node<T> quadrant2 = new Node<T>(node.getBounds().getX1(),
                node.getBounds().getY1(), newWidth, newHeight);
        Node<T> quadrant3 = new Node<T>(node.getBounds().getX1(),
                node.getBounds().getMidY(), newWidth, newHeight);
        Node<T> quadrant4 = new Node<T>(node.getBounds().getMidX(),
                node.getBounds().getMidY(), newWidth, newHeight);

        node.getChildren()[0] = quadrant1;
        node.getChildren()[1] = quadrant2;
        node.getChildren()[2] = quadrant3;
        node.getChildren()[3] = quadrant4;

        Iterator<T> iterator = node.getItems().iterator();
        while (iterator.hasNext()) {
            T item = iterator.next();
            for (Node<T> child : node.getChildren()) {
                if (item.getBounds().isInside(child.getBounds())) {
                    iterator.remove();
                    child.getItems().add(item);
                }
            }
        }
    }

    public List<T> report(Rectangle bounds) {
        if(bounds.isInside(this.root.getBounds())) {
            List<T> result = new ArrayList<>();
            this.report(this.root, bounds, result);
            return result;
        }
        return null;
    }

    private void report(Node<T> node, Rectangle bounds, List<T> result) {
        if (bounds.isInside(node.getBounds())) {
            if (node.getChildren() != null) {
                for (Node<T> child : node.getChildren()) {
                    this.report(child, bounds, result);
                }
            } else {
                result.addAll(node.getItems());
            }
        }
    }

    private void getAllSubtree(Node<T> node, Rectangle bounds, List<T> result) {
        if (node.getChildren() != null) {
            for (Node<T> child : node.getChildren()) {
                if (child.getBounds().intersects(bounds)) {
                    this.getAllSubtree(child, bounds, result);
                }
            }
        }
        result.addAll(node.getItems());
    }
}
