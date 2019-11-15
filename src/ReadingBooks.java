import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * There are n books, and Kotivalo and Justiina are going to read them all. For each book, you know the time it takes to read it.
 *
 * They both read each book from beginning to end, and they cannot read a book at the same time. What is the minimum total time required?
 *
 * Input
 *
 * The first input line has an integer n: the number of books.
 *
 * The second line has n integers t1,t2,…,tn: the time required to read each book.
 *
 * Output
 *
 * Print one integer: the minimum total time.
 *
 * */
public class ReadingBooks {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());

        long m = 0;
        long s = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(st.nextToken());
            m = Math.max(m, t);
            s += t;
        }

        if (m > s - m) {
            // max elements more than sum of all other elements
            // time can not be less than 2m
            System.out.println(2 * m);
        } else {
            // each reader must read all books (simple sum)
            System.out.println(s);
        }


    }
}
