package standard;

/**
 * Determine min number of cut to make given string palindrome.
 * Ex. aba|b|bbabb|ababa   min cut = 3.
 */
public class PalindromePartition {

    private static boolean isPalindrome(String str) {
        int n = str.length();
        if (n == 0 || n == 1) {
            return true;
        }

        for (int i = 0; i < n / 2; i++) {
            if (str.charAt(i) != str.charAt(n - 1)) {
                return false;
            }
        }
        return true;
    }

    private static int minCutRecursion(String str) {
        int n = str.length();
        if (isPalindrome(str)) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int sum = minCutRecursion(str.substring(0, i)) + 1 + minCutRecursion((str.substring(i + 1, n)));
            ans = Math.min(ans, sum);
        }
        return ans;
    }

    private static int minCutDP(String str) {
        int n = str.length();
        if (isPalindrome(str)) {
            return 0;
        }

        int[][] dp = new int[n][n];
        boolean[][] pd = new boolean[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int k = i + gap;
                dp[i][k] = Integer.MAX_VALUE;
                if (i == k) {
                    pd[i][k] = true;
                } else if (i + 1 == k) {
                    pd[i][k] = str.charAt(i) == str.charAt(k);
                } else {
                    pd[i][k] = str.charAt(i) == str.charAt(k) && pd[i + 1][k - 1];
                }

                if (pd[i][k]) {
                    dp[i][k] = 0;
                } else {
                    for (int j = i; j < k; j++) {
                        int sum = dp[i][j] + 1 + dp[j + 1][k];
                        dp[i][k] = Math.min(dp[i][k], sum);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minCutRecursion("ababbbabbababa"));
        System.out.println(minCutRecursion("aaaab"));
        System.out.println(minCutDP("ababbbabbababa"));
    }
}
