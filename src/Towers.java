import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 You are given n cubes in a certain order, and your task is to build towers using them.
 Whenever two cubes are one on top of the other, the upper cube must be smaller than the lower cube.

 You must process the cubes in the given order.
 You can always either place the cube on top of an existing tower, or begin a new tower.
 What is the minimum possible number of towers?

 Input

 The first input line contains an integer n: the number of cubes.
 The next line contains n integers k1,k2,…,kn: the sizes of the cubes.

 Output

 Print one integer: the minimum number of towers.

 * */
public class Towers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());

        List<Integer> ss = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int curr = Integer.parseInt(st.nextToken());
            int ub = upperBound(ss, curr);
            if (ub >= ss.size()) {
                ss.add(curr);
            } else {
                ss.set(ub, curr);
                //ss.sort(Integer::compareTo);
            }
        }


        System.out.println(ss.size());

    }

    public static <T> int upperBound(List<? extends Comparable<? super T>> list, T value) {
        final int size = list.size();
        int start = 0;
        int end = size-1;
        if (end < 0) return 0;
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
