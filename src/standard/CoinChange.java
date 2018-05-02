package standard;

public class CoinChange {


    static int CChange(int[] coins, int n, int cn) {
        if (n < 0 && cn >= 1) {
            return 0;
        }
        if (cn == 0) {
            return 1;
        }
        if (cn < 0) {
            return 0;
        }
        return CChange(coins, n - 1, cn) + CChange(coins, n, cn - coins[n]);
    }

    static int CChangeDP(int[] coins, int cn) {
        int[] dp = new int[cn + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= cn; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[cn];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        System.out.println(CChange(coins, 2, 4));
        System.out.println(CChangeDP(coins, 4));
    }
}
