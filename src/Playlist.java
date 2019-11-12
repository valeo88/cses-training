import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * You are given a playlist of a radio station since its establishment. The playlist has a total of n songs.
 *
 * What is the longest sequence of successive songs where each song is unique?
 *
 * Input
 *
 * The first input line contains an integer n: the number of songs.
 *
 * The next line has n integers k1,k2,…,kn: the id number of each song.
 *
 * Output
 *
 * Print the length of the longest sequence of unique songs.
 * */
public class Playlist {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startIdx = 0;
        int maxLen = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int current = arr[i];
            if (set.contains(current)) {
                while (true) {
                    if (arr[startIdx] == current) {
                        startIdx++;
                        break;
                    }
                    set.remove(arr[startIdx]);
                    startIdx++;
                }
            } else {
                set.add(current);
            }
            maxLen = Math.max(maxLen, set.size());
        }

        System.out.println(maxLen);

    }
}
