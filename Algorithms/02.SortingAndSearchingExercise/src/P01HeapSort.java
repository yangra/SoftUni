import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P01HeapSort {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int[] arr = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        heapSort(arr);

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            output.append(arr[i] + " ");
        }
        System.out.println(output);

    }

    private static void heapSort(int[] arr) {
        int heapSize = arr.length;

        buildHeap(arr);

        for (int i = heapSize - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapSize -= 1;
            maxHeapify(arr, heapSize, 0);
        }

    }

    private static void buildHeap(int[] arr) {
        int heapSize = arr.length;
        for (int i = heapSize / 2; i > -1; i--) {
            maxHeapify(arr, heapSize, i);
        }
    }

    private static void maxHeapify(int[] arr, int heapSize, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < heapSize && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, largest, i);
            maxHeapify(arr, heapSize, largest);
        }

    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
