### 题目描述

https://leetcode.cn/problems/search-insert-position/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

使用二分查找即可

```java
package n63.searchInsert;

public class Solution {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}

```