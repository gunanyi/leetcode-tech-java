### 题目描述

https://leetcode.cn/problems/perfect-squares/description/?envType=study-plan-v2&envId=top-100-liked
使用动态规划处理LeetCode的完全平方数问题（LeetCode 279）的核心在于将问题建模为**完全背包问题**，并通过状态转移方程逐步求解最优解。以下是具体分析：

---

### 1. **问题理解与建模**

题目要求：给定正整数 ( n )，找到**最少数量的完全平方数**（如1, 4, 9等），使得它们的和等于 ( n )。  
例如，( n=12 ) 的最优解是 ( 4+4+4 )（3个平方数）。

动态规划的建模思路：

- **状态定义**：设( dp[i] ) 表示组成整数 ( i ) 所需的最少完全平方数的数量。
- **目标**：求 ( dp[n] )。

---

### 2. **状态转移方程**

对于每个 ( i )，考虑所有可能的完全平方数 ( j^2 leq i )，通过以下方式更新状态：  
[
dp[i] = min (dp[i], dp[i - j^2] + 1)
]  
**解释**：

- ( dp[i - j^2] ) 表示用 ( j^2 ) 之后剩余部分 ( i - j^2 ) 的最优解。
- 加1是因为当前选择的 ( j^2 ) 占用了1个平方数。

---

### 3. **初始化与边界条件**

- **初始值**：
    - ( dp[0] = 0 )，因为0不需要任何平方数。
    - 其他位置初始化为正无穷（或 ( n+1 )），表示尚未计算的无效状态。
- **遍历顺序**：
    - 外层循环遍历 ( i=1 ) 到 ( n )；
    - 内层循环遍历 ( j=1 ) 到 \( sqrt{i} )，枚举所有可能的平方数。

---

### 4. **示例推导**

以 ( n=5 ) 为例：

- \( dp[1] = dp[1-1^2] + 1 = dp[0] + 1 = 1 \)
- \( dp[2] = dp[2-1^2] + 1 = dp[1] + 1 = 2 \)
- \( dp[5] = \min(dp[5-1^2]+1, dp[5-2^2]+1) = \min(5, 2) = 2 \)（即 \( 1^2 + 2^2 \)）。

---

```java
package n84.numSquares;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(10));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minn = Math.min(minn, dp[i - j * j]);
            }

            dp[i] = minn + 1;
        }

        return dp[n];
    }
}

```