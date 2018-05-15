package standard;

public class WordBreak {

    private static final String[] dict = {"I", "have", "pen"};

    private static boolean inDist(String s) {
        for (String aDict : dict) {
            if (aDict.equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isStringFromDict(String str) {
        int n = str.length();
        if (n == 0) {
            return true;
        }

        for (int i = 1; i <= n; i++) {
            if (inDist(str.substring(0, i)) && isStringFromDict(str.substring(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean dpSolution(String str) {
        int n = str.length();
        if (n == 0) {
            return true;
        }
        boolean[] dp = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!dp[i] && inDist(str.substring(0, i))) {
                dp[i] = true;
            }

            if (dp[i]) {
                if (i == n) {
                    return true;
                }
                for (int j = i + 1; j <= n; j++) {
                    if (inDist(str.substring(i, j))) {
                        dp[j] = true;
                    }
                    if (dp[j] && j == n) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isStringFromDict("pen"));
        System.out.println(dpSolution("Ihavepen"));
    }
}
