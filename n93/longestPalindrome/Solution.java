package n93.longestPalindrome;

public class Solution {

    public String longestPalindrome(String s) {
        int maxLength = 1;
        int begin = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        for (int i = 2; i <= chars.length; i++) { // 子串长度
            for (int l = 0; l < chars.length; l++) {
                int r = l + i - 1;
                if (r >= chars.length) {
                    break;
                }

                if (chars[l] != chars[r]) {
                    dp[l][r] = false;
                } else {
                    if (r - l < 3) {
                        dp[l][r] = true;
                    } else {
                        dp[l][r] = dp[l + 1][r - 1];
                    }
                }

                if (dp[l][r] && r - l + 1 > maxLength) {
                    maxLength = r - l + 1;
                    begin = l;
                }
            }
        }

        return s.substring(begin, begin + maxLength);
    }
}
