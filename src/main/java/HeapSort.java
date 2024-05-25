import java.util.stream.IntStream;

@SuppressWarnings({"unchecked", "rawtypes"})
public class HeapSort {

    public static void sort(Comparable[] primaryQueue) {
        int size = primaryQueue.length;
        IntStream.iterate(size / 2, k -> k >= 1, k -> k - 1)
                 .forEach(k -> sink(primaryQueue, k, size));
        int index = size;
        while (index > 1) {
            exchange(primaryQueue, 1, index--);
            sink(primaryQueue, 1, index);
        }
    }

    private static void exchange(Comparable[] binaryHeap, int i, int j) {
        Comparable comparable = binaryHeap[i - 1];
        binaryHeap[i -1] = binaryHeap[j - 1];
        binaryHeap[j - 1] = comparable;
    }

    private static boolean less(Comparable[] binaryHeap, int valueOne, int valueTwo) {
        return binaryHeap[valueOne - 1].compareTo(binaryHeap[valueTwo - 1]) < 0;
    }

    private static void sink(Comparable[] binaryHeap, int index, int N) {
        while(2 * index <= N) {
            int j = index * 2;
            if (j < N && less(binaryHeap, j, j + 1)) j++;
            if (!less(binaryHeap, index, j)) break;
            exchange(binaryHeap, index, j);
            index = j;
        }
    }
}
