### 题目描述

https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

如果 dp[i] > dp[i-1] 那么dp[i] = dp[i-1] + 1
我们需要两次for循环来查找最大值

```java
package n87.lengthOfLIS;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }

        return res;
    }
}

```