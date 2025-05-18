### 题目描述

https://leetcode.cn/problems/unique-paths/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

多维动态规划
dp[i][j] 表示到 i,j坐标的路径条数，只能向右和向下走，所以
dp[i][j] = dp[i-1][j] + dp[i][j-1]

```java
package n91.uniquePaths;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}

```