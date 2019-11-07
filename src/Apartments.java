import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * There are n applicants and m free apartments.
 * Your task is to distribute the apartments so that as many applicants as possible will get an apartment.
 *
 * Each applicant has a desired apartment size,
 * and they will accept any apartment whose size is close enough to the desired size.
 *
 * Input
 *
 * The first input line has three integers n, m, and k: the number of applicants,
 * the number of apartments, and the maximum allowed difference.
 *
 * The next line contains n integers a1,a2,…,an: the desired apartment size of each applicant.
 * If the desired size of an applicant is x, he or she will accept any apartment whose size is between x−k and x+k.
 *
 * The last line contains m integers b1,b2,…,bm: the size of each apartment.
 *
 * Output
 *
 * Print one integer: the number of applicants who will get an apartment.
 * */
public class Apartments {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextInt();

        long[] a = new long[n];
        long[] b = new long[m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int cnt = 0;

//        for (long x : a) {
//            long lb = x - k;
//            long ub = x + k;
//            int idx = getLowerBoundIdx(b, lb);
//            if (idx != -1 && b[idx] <= ub) {
//                cnt++;
//                // delete element from array
//                int[] b2 = new int[b.length-1];
//                for (int j = 0; j < idx; j++) {
//                    b2[j] = b[j];
//                }
//                for (int j = idx+1; j < b.length; j++) {
//                    b2[j-1] = b[j];
//                }
//                b = b2;
//            }
//        }
        int lastIdx = 0;
        for (int i = 0; i < a.length; i++) {
            long lb = a[i] - k;
            long ub = a[i] + k;
            for (int j = lastIdx; j < b.length; j++) {
                long sq = b[j];
                if (sq >= lb && sq <= ub) {
                    cnt++;
                    lastIdx = j + 1;
                    break;
                } else if (sq > ub) {
                    break;
                } else {
                    lastIdx = j + 1;
                }
            }
            if (lastIdx > b.length - 1) {
                break;
            }
        }

        pw.println(cnt);
        pw.flush();

    }

    // use binary search modification
    static int getLowerBoundIdx(long[] b, long key) {
        int start = 0;
        int end = b.length - 1;
        while (true) {
            int mid = start + (end - start) / 2;
            if (b[mid] >= key) {
                end = mid - 1;
                if (start > end) {
                    return mid;
                }
            } else {
                start = mid + 1;
                if(start > end){
                    return mid < b.length-1 ? mid+1 : -1;
                }
            }
        }
    }

}
