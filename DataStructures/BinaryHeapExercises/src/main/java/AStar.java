import java.util.*;

public class AStar {

    private PriorityQueue<Node> open;
    private Map<Node, Node> parent;
    private Map<Node, Integer> cost;
    private List<Node> result;
    private char[][] map;

    public AStar(char[][] map) {
        this.map = map;
        this.parent = new HashMap<>();
        this.cost = new HashMap<>();
        this.open = new PriorityQueue<>();
        this.result = new ArrayList<>();
    }


    public static int getH(Node current, Node goal) {

        int deltaX = Math.abs(current.getCol() - goal.getCol());
        int deltaY = Math.abs(current.getRow() - goal.getRow());

        return deltaX + deltaY;
    }

    public Iterable<Node> getPath(Node start, Node goal) {
        this.open.enqueue(start);
        this.cost.put(start, 0);
        this.parent.put(start, null);
        while (this.open.size() > 0) {
            Node current = this.open.dequeue();
            if (current.equals(goal)) {
                break;
            }
            if (current.getRow() + 1 < this.map.length && this.map[current.getRow() + 1][current.getCol()] != 'W') {
                Node neighbour = new Node(current.getRow() + 1, current.getCol());
                visitNeighbour(current, neighbour, goal);
            }
            if (current.getRow() - 1 >= 0 && this.map[current.getRow() - 1][current.getCol()] != 'W') {
                Node neighbour = new Node(current.getRow() - 1, current.getCol());
                visitNeighbour(current, neighbour, goal);
            }
            if (current.getCol() + 1 < this.map[0].length && this.map[current.getRow()][current.getCol() + 1] != 'W') {
                Node neighbour = new Node(current.getRow(), current.getCol() + 1);
                visitNeighbour(current, neighbour, goal);
            }
            if (current.getCol() - 1 >= 0 && this.map[current.getRow()][current.getCol() - 1] != 'W') {
                Node neighbour = new Node(current.getRow(), current.getCol() - 1);
                visitNeighbour(current, neighbour, goal);
            }
        }

        if(!this.parent.containsKey(goal)){
            this.result.add(null);
            return this.result;
        }

        reconstructPath(goal);
        return Collections.unmodifiableList(this.result);
    }

    private void reconstructPath(Node node) {
        if(this.parent.get(node) == null){
            this.result.add(node);
            return;
        }
        reconstructPath(this.parent.get(node));
        this.result.add(node);
    }

    private void visitNeighbour(Node current, Node neighbour, Node goal) {
        int newCost = this.cost.get(current) + 1;
        if (!this.cost.containsKey(neighbour) || this.cost.get(neighbour) > newCost) {
            this.cost.put(neighbour, newCost);
            neighbour.setF(newCost + getH(neighbour, goal));
            this.open.enqueue(neighbour);
            this.parent.put(neighbour, current);
        }
    }
}
