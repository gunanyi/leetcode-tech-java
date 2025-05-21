### 题目描述

https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

dp[i][j] 表示从i到j的子串是否为回文字符串。
如果时回文字符串 那么 dp[i+1][j-1] 也是回文字符串
所以 dp[i][j] = dp[i+1][j-1] && chars[i] == chars[j]
上面是子串长度大于2的情况。
还需要考虑 小于等于2情况。
长度为1时，一定为回文串
长度为2时，需要比较 chars[i] 和 chars[i-1] 相等，则为回文串

```java
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

```