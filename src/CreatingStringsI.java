import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Given a string, your task is to generate all different strings that can be created using its characters.
 *
 * Input
 *
 * The only input line has a string of length n (1..8). Each character is between a–z.
 *
 * Output
 *
 * First print an integer k: the number of strings.
 * Then print k lines: the strings in alphabetical order.
 * */
public class CreatingStringsI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        char[] s = sc.nextLine().toCharArray();
        Set<String> distinct = new TreeSet<>();
        gen(s, new char[s.length], distinct, 0);

        pw.println(distinct.size());
        for (String ss : distinct) {
            pw.println(ss);
        }
        pw.flush();
    }

    private static void gen(char[] source, char[] target, Set<String> distinct, int idx) {
        if (target.length == idx) {
            distinct.add(new String(target));
            return;
        }
        for (int i = 0; i < source.length; i++) {
            target[idx] = source[i];
            char[] newSource = new char[source.length-1];
            for (int k = 0; k < i; k++) {
                newSource[k] = source[k];
            }
            for (int k = i+1; k < source.length; k++) {
                newSource[k-1] = source[k];
            }
            gen(newSource, target, distinct, idx + 1);
        }
    }
}
