package standard;

public class EditDistance {

    private static int findDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return findDistance(str1.substring(0, m - 1), str2.substring(0, n - 1));
        }

        return 1 + Math.min(findDistance(str1.substring(0, m - 1), str2.substring(0, n)),
                Math.min(findDistance(str1.substring(0, m - 1), str2.substring(0, n - 1)),
                        findDistance(str1.substring(0, m), str2.substring(0, n - 1))));
    }

    private static int findDistanceDP(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(findDistance("abc", "abc"));
        System.out.println(findDistance("abcd", "abc"));
        System.out.println(findDistance("acb", "abc"));
        System.out.println(findDistanceDP("abc", "abc"));
        System.out.println(findDistanceDP("abcd", "abc"));
        System.out.println(findDistanceDP("acb", "abc"));
    }
}
