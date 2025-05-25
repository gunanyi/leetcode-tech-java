### 题目描述

https://leetcode.cn/problems/edit-distance/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

可以进行三种操作
1.插入一个字符
2.删除一个字符
3.替换一个字符
求最小的编辑距离，那么我们需要找到三种操作的最小值

假设a = horse b = ros
那么我们可以比较最后以一位
如果最后一位相等
dp[l1][l2] = dp[l1-1] + dp[l2-1] 编辑距离为0
如果最后一位不想等
可以有三种操作
插入
dp[l1][l2] = 1 + dp[l1][l2-1]
删除
dp[l1][l2] = 1 + dp[l1-1][l2]
替换
dp[l1][l2] = 1 + dp[l1-1][l2-1]
dp[l1][l2] = 1 + min(dp[l1][l2-1],dp[l1-1][l2],dp[l1-1][l2-1])

初始化时
dp[i][0] = i dp[0][j] = j

```java
package n95.minDistance;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }
}

```