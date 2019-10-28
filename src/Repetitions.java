import java.io.PrintWriter;
import java.util.Scanner;

/**
 * You are given a DNA sequence: a string consisting of characters A, C, G, and T.
 * Your task is to find the longest repetition in the sequence.
 * This is a maximum-length substring containing only one type of character.
 *
 * Input
 *
 * The only input line contains a string of n characters.
 *
 * Output
 *
 * Print one integer: the length of the longest repetition.
 * */
public class Repetitions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        char[] s = scanner.next().toCharArray();
        int maxSs = 1;
        int cnt = 0;

        char prevChar = s[0];
        for(char c : s) {
            if (c == prevChar) {
                cnt++;
            } else {
                maxSs = Math.max(maxSs, cnt);
                cnt = 1;
            }
            prevChar = c;
        }
        maxSs = Math.max(maxSs, cnt);

        printWriter.print(maxSs);
        printWriter.flush();
    }
}
