import java.util.function.Consumer;

public class KdTree {

    public static final int DIMENSIONS = 2;

    public class Node {

        private Point2D point2D;
        private Node left;
        private Node right;

        public Node(Point2D point) {
            this.setPoint2D(point);
        }

        public Point2D getPoint2D() {
            return this.point2D;
        }

        public void setPoint2D(Point2D point2D) {
            this.point2D = point2D;
        }

        public Node getLeft() {
            return this.left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return this.right;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public boolean contains(Point2D point) {
        return this.search(this.root, point, 0) != null;
    }

    public Node get(Point2D point) {
        return search(this.root, point, 0);
    }

    private Node search(Node node, Point2D point, int depth) {
        if (node == null) {
            return null;
        }

        int cmp = compare(node.point2D, point, depth);
        if (cmp > 0) {
            return this.search(node.left, point, depth + 1);
        } else if (cmp < 0) {
            return this.search(node.right, point, depth + 1);
        } else {
            return node;
        }
    }

    public void insert(Point2D point) {
        this.root = insert(this.root, point, 0);
    }

    private Node insert(Node node, Point2D point, int depth) {
        if (node == null) {
            return new Node(point);
        }

        int compare = this.compare(node.point2D, point, depth);

        if (compare > 0) {
            node.left = insert(node.left, point, depth + 1);
        } else {
            node.right = insert(node.right, point, depth + 1);
        }

        return node;
    }

    public void eachInOrder(Consumer<Point2D> consumer) {
        this.eachInOrder(this.root, consumer);
    }

    private void eachInOrder(Node node, Consumer<Point2D> consumer) {
        if (node == null) {
            return;
        }

        this.eachInOrder(node.getLeft(), consumer);
        consumer.accept(node.getPoint2D());
        this.eachInOrder(node.getRight(), consumer);
    }

    public int searchRange(Area area, int galaxySize) {
        Area universe = new Area(new Point2D(0, 0), galaxySize, galaxySize);
        return searchRange(this.root, universe, area, 0, 0);
    }

    private int searchRange(Node node, Area parentArea, Area area, int depth, int count) {
        if (node == null) {
            return 0;
        }

        if (area.intersects(parentArea)) {
            Area nodeAreaLeft = null;
            Area nodeAreaRight = null;
            if (depth % DIMENSIONS == 0) {
                nodeAreaLeft = new Area(new Point2D(parentArea.getUpLeftCorner().getX(), parentArea.getUpLeftCorner().getY()),
                        node.point2D.getX() - parentArea.getUpLeftCorner().getX(), parentArea.getHeight());
                nodeAreaRight = new Area(new Point2D(node.point2D.getX(), parentArea.getUpLeftCorner().getY()),
                        parentArea.getUpLeftCorner().getX() + parentArea.getWidth() - node.point2D.getX(), parentArea.getHeight());
            } else {
                nodeAreaLeft = new Area(new Point2D(parentArea.getUpLeftCorner().getX(), parentArea.getUpLeftCorner().getY()),
                         parentArea.getWidth(),node.point2D.getY() - parentArea.getUpLeftCorner().getY());
                nodeAreaRight = new Area(new Point2D(parentArea.getUpLeftCorner().getX(), node.point2D.getY()),
                          parentArea.getWidth(),parentArea.getUpLeftCorner().getY() + parentArea.getHeight() - node.point2D.getY());
            }

            count = searchRange(node.left, nodeAreaLeft, area, depth + 1, count);
            count = searchRange(node.right, nodeAreaRight, area, depth + 1, count);

            if (area.hasInside(node.point2D)) {
                count++;
            }
        }

        return count;
    }

    private int compare(Point2D a, Point2D b, int depth) {

        if (depth % DIMENSIONS == 0) {
            int cmp = Double.compare(a.getX(), b.getX());
            if (cmp == 0) {
                cmp = Double.compare(a.getY(), b.getY());
            }
            return cmp;
        } else {
            int cmp = Double.compare(a.getY(), b.getY());
            if (cmp == 0) {
                cmp = Double.compare(a.getX(), b.getX());
            }
            return cmp;
        }
    }
}
