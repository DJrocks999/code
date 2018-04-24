package algorithms;

public class LongestIncreasingSequence {

    private static int findLIC(String s) {
        int m = s.length();
        if (m < 2) {
            return m;
        }

        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(j) < s.charAt(i) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(findLIC("321"));
        System.out.println(findLIC("123"));
        System.out.println(findLIC(""));
    }
}
