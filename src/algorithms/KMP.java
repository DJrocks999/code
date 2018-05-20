package algorithms;

public class KMP {

    // Longest Proper Prefix which is also suffix.
    private static int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    private static void isPatternMatched(String str, String pat) {
        int[] lps = computeLPS(pat);
        int n = str.length();
        int m = pat.length();
        int i = 0;
        int j = 0;
        boolean flag = true;
        while (i < n) {
            if (str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                flag = false;
                System.out.println("match found at char: " + ((i - j) + 1));
                j = lps[j - 1];
            } else if (i < n && str.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        if (flag) {
            System.out.println("No match found!!!");
        }
    }

    public static void main(String[] args) {
        isPatternMatched("Hi I am Dhaval", "hello");
        isPatternMatched("abcdbcdbcddd", "bcd");
    }
}