package algorithms;

public class LongestCommonSequence {

    private static int LCS(String s1, String s2, int m, int n) {
        if (m == -1 || n == -1) {
            return 0;
        } else if (s1.charAt(m) == s2.charAt(n)) {
            return 1 + LCS(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(LCS(s1, s2, m - 1, n), LCS(s1, s2, m, n - 1));
        }
    }

    private static int dpLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(LCS("abcde", "bdce", 4, 3));
        System.out.println(dpLCS("abcde", "bdce"));
    }
}
