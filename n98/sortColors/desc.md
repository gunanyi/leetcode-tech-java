### 题目描述

https://leetcode.cn/problems/sort-colors/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

这个题目时典型的国旗问题。
方法一：
可以使用一个map，统计每个颜色的数量，然后根据数量构造数组。

方法二：
双指针
p0表示颜色为0的下一个位置，p1表示颜色为1的下一个位置，然后我们遍历数组，遇到1，交换 i和p1下标，并p1++
遇到0，交换i和p0下标，这时需要判断如果 p0<p1说明0后面有1，我们这次交换会把1交换到i，需要再交换i,p1 来保证正确性

```java
package n98.sortColors;

public class Solution {

    public void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            } else if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


```