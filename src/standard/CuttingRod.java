package standard;

public class CuttingRod {

    // To get max profit, indices are size of the rod.
    static int cutRod(int[] prices, int n) {
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(prices[i] + cutRod(prices, n - i - 1), max);
        }
        return max;
    }

    static int cutRodDP(int[] prices, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, prices[j] + dp[i - j - 1]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(cutRod(prices, prices.length));
        System.out.println(cutRodDP(prices, prices.length));
    }
}
