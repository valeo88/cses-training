import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * In a movie festival n movies will be shown.
 * You know the starting and ending time of each movie.
 * What is the maximum number of movies you can watch entirely?
 *
 * Input
 *
 * The first input line has an integer n: the number of movies.
 *
 * After this, there are n lines that describe the movies.
 * Each line has two integers a and b: the starting and ending times of a movie.
 *
 * Output
 *
 * Print one integer: the maximum number of movies.
 * */
public class MovieFestival {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());

        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            movies.add(new Movie(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        movies.sort(Movie::compareTo);

        int cnt= 0;
        int currentEnd = 0;
        for (Movie m : movies) {
            if (m.start >= currentEnd) {
                cnt++;
                currentEnd = m.end;
            }
        }

        System.out.println(cnt);
    }

    private static class Movie implements Comparable<Movie> {
        private int start;
        private int end;

        public Movie(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Movie o) {
            // for sorting by end time
            return this.end - o.end;
        }
    }
}
