import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<T>> {

    private T value;
    private BinaryTree<T> left;
    private BinaryTree<T> right;

    public BinaryTree(T value) {
        this.value = value;
    }

    public BinaryTree(T value, BinaryTree<T> child) {
        this.value = value;
        if(child.value.compareTo(this.value)>0){
            this.right = child;
        }else {
            this.left = child;
        }

    }

    public BinaryTree(T value, BinaryTree<T> leftChild, BinaryTree<T> rightChild) {
        this.value = value;
        this.left = leftChild;
        this.right = rightChild;
    }

    // append output to builder
    public String printIndentedPreOrder(int indent, StringBuilder builder) {
        printIndentedPreOrder(this,indent, builder );
        return builder.toString();
    }

    private void printIndentedPreOrder(BinaryTree<T> node, int indent, StringBuilder builder ){
        if(node == null){
            return;
        }

        builder.append(new String(new char[indent*2]).replace("\0"," ")).append(node.value).append("\n");
        printIndentedPreOrder(node.left,indent+1, builder);
        printIndentedPreOrder(node.right,indent+1, builder);
    }

    public void eachInOrder(Consumer<T> consumer) {
        eachInOrder(this, consumer);
    }

    private void eachInOrder(BinaryTree<T> node, Consumer<T> consumer){
        if(node == null){
            return;
        }

        eachInOrder(node.left, consumer);
        consumer.accept(node.value);
        eachInOrder(node.right, consumer);
    }

    public void eachPostOrder(Consumer<T> consumer) {
        eachPostOrder(this, consumer);
    }

    private void eachPostOrder(BinaryTree<T> node, Consumer<T> consumer){
        if(node == null){
            return;
        }

        eachPostOrder(node.left, consumer);
        eachPostOrder(node.right, consumer);
        consumer.accept(node.value);
    }
}
