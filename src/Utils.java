import java.util.Arrays;
import java.util.List;

public class Utils {

    public static void main(String[] args) {
        // test methods

        List<Integer> list1 = Arrays.asList(1,7,3,10,6,5,5,3,4,8);
        list1.sort(Integer::compareTo);

        // upperBounds
        assertEquals(list1.size(), upperBound(list1, 12));
        assertEquals(0, upperBound(list1, 0));
        assertEquals(1, upperBound(list1, 1));
        assertEquals(1, upperBound(list1, 2));
        assertEquals(6, upperBound(list1, 5));
        assertEquals(9, upperBound(list1, 8));

        // lowerBounds
        assertEquals(list1.size(), lowerBound(list1, 12));
        assertEquals(0, lowerBound(list1, 0));
        assertEquals(0, lowerBound(list1, 1));
        assertEquals(1, lowerBound(list1, 2));
        assertEquals(4, lowerBound(list1, 5));
    }

    private static void assertEquals(int expected, int actual) {
        if (expected != actual) throw new Error(String.format("Expected %d, but actual - %d", expected, actual));
    }

    /** Works like C++ upper_bound
     * Get index of element more than value */
    public static <T> int upperBound(List<? extends Comparable<? super T>> list, T value) {
        final int size = list.size();
        int start = 0;
        int end = size-1;
        int mid = (start + end) / 2;
        while (true) {
            int cmp = list.get(mid).compareTo(value);
            if (cmp == 0 || cmp < 0) {
                start = mid + 1;
                if (end < start)
                    return mid < size - 1 ? mid + 1 : size;
            } else {
                end = mid - 1;
                if (end < start)
                    return mid;
            }
            mid = (start + end) / 2;
        }
    }

    /** Works like C++ lower_bound
     * Get index of element equal or more than value */
    public static <T> int lowerBound(List<? extends Comparable<? super T>> list, T value) {
        final int size = list.size();
        int start = 0;
        int end = size-1;
        int mid = (start + end) / 2;
        while (true) {
            int cmp = list.get(mid).compareTo(value);
            if (cmp == 0 || cmp > 0) {
                end = mid - 1;
                if (end < start)
                    return mid;
            } else {
                start = mid + 1;
                if (end < start)
                    return mid < size - 1 ? mid + 1 : size;
            }
            mid = (start + end) / 2;
        }
    }
}
