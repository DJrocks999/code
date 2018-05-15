package standard;

public class WildCardMatching {

    private static boolean isMatch(String str1, String str2) {
        if (str1.length() == 0 && str2.length() == 0) {
            return true;
        }

        if (str1.equalsIgnoreCase("*") && str2.length() == 0) {
            return true;
        }

        if (str1.length() >= 2 && str1.charAt(0) == '*' && str2.length() == 0) {
            return false;
        }

        if (str1.length() != 0 && str2.length() != 0 && (str1.charAt(0) == '?' || str1.charAt(0) == str2.charAt(0))) {
            return isMatch(str1.substring(1), str2.substring(1));
        }

        if (str1.length() != 0 && str2.length() != 0 && str1.charAt(0) == '*') {
            return isMatch(str1, str2.substring(1)) || isMatch(str1.substring(1), str2);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("a*b", "abkhsakb"));
        System.out.println(isMatch("a?b", "a0b"));
        System.out.println(isMatch("*", ""));
        System.out.println(isMatch("a?b*", "acb"));
    }
}
