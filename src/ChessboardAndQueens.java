import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Your task is to place eight queens on a chessboard so that no two queens are attacking each other.
 * As an additional challenge, each square is either free or reserved, and you can only place queens on the free squares.
 * However, the reserved squares do not prevent queens from attacking each other.
 *
 * How many possible ways are there to place the queens?
 *
 * Input
 *
 * The input has eight lines, and each of them has eight characters. Each square is either free (.) or reserved (*).
 *
 * Output
 *
 * Print one integer: the number of ways you can place the queens.
 * */
public class ChessboardAndQueens {

    private static final int BOARD_SIZE = 8;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        boolean[] reserved = new boolean[BOARD_SIZE * BOARD_SIZE];
        boolean[] col = new boolean[BOARD_SIZE];
        boolean[] diag1 = new boolean[BOARD_SIZE * BOARD_SIZE];
        boolean[] diag2 = new boolean[BOARD_SIZE * BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            char[] s = sc.nextLine().toCharArray();
            for (int j = 0; j < s.length; j++) {
                if (s[j] == '*') reserved[i * BOARD_SIZE + j] = true;
            }
        }

        int[] cnt = new int[1];
        search(0, cnt, reserved, col, diag1, diag2);

        pw.println(cnt[0]);
        pw.flush();

    }

    private static int search(int y, int[] cnt, boolean[] reserved, boolean[] col, boolean[] diag1, boolean[] diag2) {
        if (y == BOARD_SIZE) {
            cnt[0]++;
            return cnt[0];
        }
        for (int x = 0; x < BOARD_SIZE; x++) {
            if (col[x] || diag1[x+y] || diag2[x-y+BOARD_SIZE-1] || reserved[x + y * BOARD_SIZE]) continue;
            col[x] = diag1[x+y] = diag2[x-y+BOARD_SIZE-1] = true;
            search(y+1, cnt, reserved, col, diag1, diag2);
            col[x] = diag1[x+y] = diag2[x-y+BOARD_SIZE-1] = false;
        }
        return cnt[0];
    }
}
