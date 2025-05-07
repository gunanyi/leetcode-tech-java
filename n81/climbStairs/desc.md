### 题目描述

https://leetcode.cn/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-100-liked

因为一次只能爬1或者2 res[n] = res[n-1] + res[n-2]

### 解题思路

```java
package n81.climbStairs;

public class Solution {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int pre0 = 1, pre1 = 2;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = pre0 + pre1;
            pre0 = pre1;
            pre1 = res;
        }

        return res;
    }
}

```