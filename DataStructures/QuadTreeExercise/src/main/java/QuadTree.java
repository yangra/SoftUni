

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class QuadTree<T extends Boundable> {

    public static final int DEFAULT_MAX_DEPTH = 5;

    private int maxDepth;

    private Node<T> root;

    private Rectangle bounds;

    private int count;

    public QuadTree(int width, int height) {
        this(width, height, DEFAULT_MAX_DEPTH);
    }

    public QuadTree(int width, int height, int maxDepth) {
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
        if (!item.getBounds().isInside(this.getBounds())) {
            return false;
        }
        int depth = 1;
        Node<T> currentNode = this.root;
        while (currentNode.getChildren() != null) {
            int quadrant = getQuadrant(currentNode, item.getBounds());
            if (quadrant != -1 && depth < this.maxDepth) {
                currentNode = currentNode.getChildren()[quadrant - 1];
                depth++;
            } else {
                break;
            }
        }

        currentNode.getItems().add(item);
        this.split(currentNode, depth);
        this.count++;

        return true;
    }

    private void split(Node<T> node, int nodeDepth) {
        if (!(node.shouldSplit() && nodeDepth < maxDepth)) {
            return;
        }

        int leftWidth = node.getBounds().getWidth() / 2;
        int rightWidth = node.getBounds().getWidth() - leftWidth;
        int topHeight = node.getBounds().getHeight() / 2;
        int bottomHeight = node.getBounds().getHeight() - topHeight;

        node.setChildren((Node<T>[]) Array.newInstance(Node.class, 4));
        Node<T> quadrant1 = new Node<T>(node.getBounds().getMidX(),
                node.getBounds().getY1(), rightWidth, topHeight);
        Node<T> quadrant2 = new Node<T>(node.getBounds().getX1(),
                node.getBounds().getY1(), leftWidth, topHeight);
        Node<T> quadrant3 = new Node<T>(node.getBounds().getX1(),
                node.getBounds().getMidY(), leftWidth, bottomHeight);
        Node<T> quadrant4 = new Node<T>(node.getBounds().getMidX(),
                node.getBounds().getMidY(), rightWidth, bottomHeight);

        node.getChildren()[0] = quadrant1;
        node.getChildren()[1] = quadrant2;
        node.getChildren()[2] = quadrant3;
        node.getChildren()[3] = quadrant4;

        for (int i = 0; i < node.getItems().size(); i++) {
            T item = node.getItems().get(i);
            int quadrant = this.getQuadrant(node, item.getBounds());
            if (quadrant != -1) {
                node.getChildren()[quadrant - 1].getItems().add(item);
                node.getItems().remove(i);
                i--;
            }
        }

        for (Node<T> child : node.getChildren()) {
            this.split(child, nodeDepth + 1);
        }
    }

    private int getQuadrant(Node<T> node, Rectangle bounds) {
        int horizontalMidpoint = node.getBounds().getMidX();
        int verticalMidpoint = node.getBounds().getMidY();

        boolean inUpperPart = node.getBounds().getY1() <= bounds.getY1() && bounds.getY2() <= verticalMidpoint;
        boolean inLowerPart = verticalMidpoint <= bounds.getY1() && bounds.getY2() <= node.getBounds().getY2();
        boolean inLeftPart = node.getBounds().getX1() <= bounds.getX1() && bounds.getX2() <= horizontalMidpoint;
        boolean inRightPart = horizontalMidpoint <= bounds.getX1() && bounds.getX2() <= node.getBounds().getX2();

        if (inRightPart) {
            if (inUpperPart) {
                return 1;
            } else if (inLowerPart) {
                return 4;
            }
        } else if (inLeftPart) {
            if (inUpperPart) {
                return 2;
            } else if (inLowerPart) {
                return 3;
            }
        }

        return -1;
    }

    public List<T> report(Rectangle bounds) {
        List<T> collisionCandidates = new ArrayList<>();
        this.getCollisionCandidates(this.root, bounds, collisionCandidates);
        return collisionCandidates;
    }

    private void getCollisionCandidates(Node<T> node, Rectangle bounds, List<T> results) {
        int quadrant = getQuadrant(node, bounds);
        if (quadrant == -1) {
            getSubtreeContents(node, bounds, results);
        } else {
            if (node.getChildren() != null) {
                this.getCollisionCandidates(node.getChildren()[quadrant - 1], bounds, results);
            }
            results.addAll(node.getItems());
        }
    }

    private void getSubtreeContents(Node<T> node, Rectangle bounds, List<T> results) {
        if (node.getChildren() != null) {
            for (Node<T> child : node.getChildren()) {
                if (child.getBounds().intersects(bounds)) {
                    getSubtreeContents(child, bounds, results);
                }
            }
        }

        results.addAll(node.getItems());
    }
}
