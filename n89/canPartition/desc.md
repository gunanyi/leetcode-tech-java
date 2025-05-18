### 题目描述

https://leetcode.cn/problems/partition-equal-subset-sum/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

这个问题要求看你是否有两个元素和相等的子集
也就是元素总和 / 2 有子集可以组成
当元素总和为奇数时，直接返回false，因为只有正整数

可以化为 0，1背包为题，也就是求有一个容量为 和/2的背包，是否可以装满

这时动态规划来求解就是：
dp[i][j] 表示第i个元素，j为背包容量是否可以装满。
当考虑j装入时
dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]  
不装入时
dp[i][j] = dp[i-1][j]

所以可以用动态规划来处理。由于我们每一行的赋值都和上一行有关，所以可以简化为使用一味数组来处理，此时需要从target>0开始遍历

```java
package n89.canPartition;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartition2(new int[]{1, 5, 10, 6}));
    }

    // canPartition 穷举法
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        List<Set<Integer>> dp = new ArrayList<>(nums.length);
        if (nums[0] == target) {
            return true;
        }
        Set<Integer> list0 = new HashSet<>();
        list0.add(nums[0]);
        dp.add(list0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > target) {
                dp.add(dp.get(i - 1));
                continue;
            }

            Set<Integer> pre = dp.get(i - 1);
            if (nums[i] == target) {
                return true;
            }
            Set<Integer> cur = new HashSet<>(pre);
            cur.add(nums[i]);
            for (int a : pre) {
                if (a + nums[i] == target) {
                    return true;
                } else if (a + nums[i] < target) {
                    cur.add(a + nums[i]);
                }
            }
            dp.add(cur);
        }

        return false;
    }

    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target];
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }

                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            if (dp[i][target]) {
                return true;
            }
        }

        return dp[nums.length - 1][target];
    }

    public boolean canPartition2(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = target; j >= 0; j--) {
                if (nums[i] <= j) {
                    dp[j] = dp[j - nums[i]] || dp[j];
                }
            }
            if (dp[target]) {
                return true;
            }
        }

        return dp[target];
    }
}

```