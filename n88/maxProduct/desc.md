### 题目描述

https://leetcode.cn/problems/maximum-product-subarray/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

动态规划
因为每个元素的值有正和有负，不能简单的计算 max[i] = nums[i] * max[i-1]
而应该引入两个，max[i] min[i] max[i] = max[i] * min[i-1] || max[i] * max[i-1]

```java
package n88.maxProduct;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[]{-2, 3, -4}));
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0] = new int[]{nums[0], nums[0]};
        for (int i = 1; i < nums.length; i++) {
            int[] temp = new int[]{nums[i], nums[i]};
            int[] pre = dp[i - 1];
            for (int a : pre) {
                temp[0] = Math.min(temp[0], nums[i] * a);
                temp[1] = Math.max(temp[1], nums[i] * a);
            }
            dp[i] = temp;
            max = Math.max(max, dp[i][1]);
        }

        return max;
    }
}

```