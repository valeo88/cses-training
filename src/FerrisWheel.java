import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * There are n children who want to go to a Ferris wheel, and your task is to find a gondola for each child.
 *
 * Each gondola may have one or two children in it, and in addition, the total weight in a gondola may not exceed x.
 * You know the weight of every child.
 *
 * What is the minimum number of gondolas needed for the children?
 *
 * Input
 *
 * The first input line contains two integers n and x: the number of children and the maximum allowed weight.
 *
 * The next line contains n integers p1,p2,…,pn: the weight of each child.
 *
 * Output
 *
 * Print one integer: the minimum number of gondolas.
 * */
public class FerrisWheel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int x = Integer.parseInt(st.nextToken());
        final int x_2 = x / 2;

        boolean allLessHalf = true;
        boolean allMoreHalf = true;
        List<Integer> w = new ArrayList<>(n);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            w.add(p);
            if (p > x_2) {
                allLessHalf = false;
            } else {
                allMoreHalf = false;
            }
        }

        // two special cases
        if (allLessHalf) {
            System.out.println(n / 2);
            return;
        }
        if (allMoreHalf) {
            System.out.println(n);
            return;
        }

        // sort for binary search
        w.sort(Integer::compareTo);

        // use binary search to find minimal number of gondolas
        int p = -1;
        for (int b = n; b >= 1; b /= 2) {
            while (!ok(w, x, p+b)) p += b;
        }
        int k = p+1;

        System.out.println(k);
    }

    static boolean ok(final List<Integer> list, final int x, final int baskets) {
        int ans = 0;
        List<Integer> w = new ArrayList<>(list);
        while (w.size() > 0) {
            int large = w.get(w.size()-1);
            w.remove(w.size()-1);
            if (w.size()>0) {
                int ubIdx = upperBound(w, x - large);
                if (ubIdx != 0) {
                    w.remove(ubIdx - 1);
                }
            }
            ans++;
            if (ans > baskets) {
                return false;
            }
        }
        return true;
    }

    /** Works like C++ upper_bound
     * Get index of element more than value */
    private static <T> int upperBound(List<? extends Comparable<? super T>> list, T value) {
        final int size = list.size();
        int start = 0;
        int end = size-1;
        int mid = (start + end) >>> 1;
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
            mid = (start + end) >>> 1;
        }
    }



}
