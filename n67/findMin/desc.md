### 题目描述

https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

![](https://assets.leetcode-cn.com/solution-static/153/1.png)

看这个图
如果 mid < right 说明最小值在左边 舍弃右边部分
如果 mid > right 说明最小值在右边，舍弃左边部分

```java
package n67.findMin;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }
}
```