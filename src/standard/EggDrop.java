package standard;

public class EggDrop {
    // n->eggs, k->floors, x->current floor
    static int eggDrop1(int n, int k) {
        if (n == 1) {
            return k;
        }
        if (k == 0 || k == 1) {
            return k;
        }

        int ans = 10000;
        for (int x = 1; x <= k; x++) {
            int max = 1 + Math.max(eggDrop1(n, k - x), eggDrop1(n - 1, x - 1));
            if (max < ans) {
                ans = max;
            }
        }
        return ans;
    }


    static int eggDropDp(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int i = 0; i < k + 1; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 2; j < k + 1; j++) {
                dp[i][j] = 10000;
                int res;
                for (int x = 1; x <= j; x++) {
                    res = 1 + Math.max(dp[i][j - x], dp[i - 1][x - 1]);
                    if (res < dp[i][j]) {
                        dp[i][j] = res;
                    }
                }
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        //System.out.println(eggDrop1(2, 100));
        System.out.println(eggDropDp(2, 100));
    }
}
