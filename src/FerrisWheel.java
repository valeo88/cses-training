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

        int i = 0;
        int j = w.size()-1;
        int cnt = 0;
        while (i <= j) {
            if (w.get(i) + w.get(j) <= x) {
                i++;
                j--;
            } else {
                j--;
            }
            cnt++;
        }
        System.out.println(cnt);

    }

}
