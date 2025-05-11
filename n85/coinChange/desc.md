### 题目描述

https://leetcode.cn/problems/coin-change/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

动态规划，dp[n] = j个硬币 dp[n-k] = dp[n] - 1;
dp[n] = dp[n-k] + 1;
k的取值可能有多个，因为 k是一个数组，最少需要多少个我们赋值需要使用最小的那个数。
考虑到还有找不开情况，所以我们需要给dp默认都复制为最大值，当最后的值是最大值时找不开

```java
package n85.coinChange;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{2}, 3));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }

            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}

```