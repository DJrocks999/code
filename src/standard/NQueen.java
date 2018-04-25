package standard;

public class NQueen {

    static boolean isValid(int[][] board, int x, int y, int n) {
        for (int i = 0; i < y; i++) {
            if (board[x][i] == 1) {
                return false;
            }
        }
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        for (int i = x, j = y; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    static boolean isNQueen(int[][] board, int col, int n) {
        if (col >= n) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(board, i, col, n)) {
                board[i][col] = 1;
                if (isNQueen(board, col + 1, n)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board1 = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] board2 = new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        System.out.println(isNQueen(board1, 0, board1.length));
        System.out.println(isNQueen(board2, 0, board2.length));
    }
}
