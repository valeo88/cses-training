import java.io.PrintWriter;
import java.util.*;

/**
 * Given a string, your task is to reorder its letters in such a way that
 * it becomes a palindrome (i.e., it reads the same forwards and backwards).
 *
 * Input
 *
 * The only input line has a string of length n consisting of characters A–Z.
 *
 * Output
 *
 * Print a palindrome consisting of the characters of the original string.
 * You may print any valid solution. If there are no solutions, print "NO SOLUTION".
 * */
public class PalindromeReorder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        String s = sc.nextLine();
        Map<Character, Integer> cm = new HashMap<>();
        for (char c : s.toCharArray()) {
            cm.putIfAbsent(c, 0);
            cm.put(c, cm.get(c)+1);
        }
        Set<Character> odd = oddChars(cm);
        if (s.length() % 2 == 0 && odd.size() > 0 || s.length() % 2 != 0 && odd.size() > 1) {
            pw.println("NO SOLUTION");
        } else {
            char[] v = new char[s.length()];
            int l = v.length;
            int lastIdx = 0;
            for (char c : cm.keySet()) {
                if (!odd.contains(c)) {
                    int cc = cm.get(c);
                    for (int i = lastIdx; i < (lastIdx + cc / 2); i++) {
                        v[i] = c;
                        v[l - i - 1] = c;
                    }
                    lastIdx += cc / 2;
                }
            }
            if (odd.size() > 0) {
                char oc = odd.iterator().next();
                int cc = cm.get(oc);
                for (int i = lastIdx; i < lastIdx + cc; i++) {
                    v[i] = oc;
                }
            }
            pw.println(new String(v));
        }
        pw.flush();
    }

    static Set<Character> oddChars(Map<Character, Integer> cm) {
        Set<Character> result = new HashSet<>();
        for(char c : cm.keySet()) {
            if (cm.get(c) % 2 != 0) result.add(c);
        }
        return result;
    }
}
