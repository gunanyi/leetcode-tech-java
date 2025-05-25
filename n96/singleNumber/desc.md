### 题目描述

https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

由于题目保证了只有一个只出现一次，其他都出现两次。
而^运算，相同位相同为0，不同为1，保证了2次出现的数计算后为0，所以遍历一遍^即可得到答案

```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }

        return res;
    }
}
```