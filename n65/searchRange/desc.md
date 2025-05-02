### 题目描述

https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

二分查找找到，然后向前先后遍历找到两个边界值返回

```java
package n65.searchRange;

import java.util.Arrays;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] res = new int[2];
        Arrays.fill(res, -1);
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                int start1 = mid;
                int end1 = mid;
                // 左边界
                for (; nums[start1] == target; start1--) {
                    if (start1 == 0) {
                        break;
                    }
                }

                // 右边界
                for (; nums[end1] == target; end1++) {
                    if (end1 == nums.length - 1) {
                        break;
                    }
                }

                // for循环后左边界可能不等于
                if (nums[start1] != target) {
                    start1++;
                }

                if (nums[end1] != target) {
                    end1--;
                }

                res[0] = start1;
                res[1] = end1;
                break;
            }

            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }
}

```