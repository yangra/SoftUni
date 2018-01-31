public class Heap {

    public static <E extends Comparable<E>> void sort(E[] array) {
        constructHeap(array);
        sortHeap(array);
        String debug = "";
    }

    private static <E extends Comparable<E>> void sortHeap(E[] array) {
        for (int i = array.length - 1; i >= 1; i--) {
            swap(array, 0, i);
            heapifyDown(array, 0, i);
        }
    }

    private static <E extends Comparable<E>> void constructHeap(E[] array) {
        for (int i = array.length / 2; i >= 0; i--) {
            heapifyDown(array, i, array.length);
        }
    }

    private static <E extends Comparable<E>> void heapifyDown(E[] array, int index, int limit) {

        while (index < array.length / 2) {
            int childIndex = (2 * index) + 1;

            if(childIndex >= limit){
                break;
            }

            if (childIndex + 1 < limit && array[childIndex].compareTo(array[childIndex + 1]) < 0) {
                childIndex += 1;
            }

            int compare = array[index].compareTo(array[childIndex]);

            if (compare > 0) {
                break;
            }

            swap(array, index, childIndex);
            index = childIndex;
        }
    }

    private static <E extends Comparable<E>> void swap(E[] array, int index, int childIndex) {
        E element = array[index];
        array[index] = array[childIndex];
        array[childIndex] = element;
    }
}
