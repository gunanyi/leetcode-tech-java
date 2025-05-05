### 题目描述

https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

我们记录一个买入价的最小值，然后遍历数组，找到最大的利润即可

```java
package n77.maxProfit;

public class Solution {

    public int maxProfit(int[] prices) {
        int minVal = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minVal) {
                minVal = prices[i];
            } else if (prices[i] - minVal > maxProfit) {
                maxProfit = prices[i] - minVal;
            }
        }

        return maxProfit;
    }
}

```