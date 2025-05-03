### 题目描述

https://leetcode.cn/problems/search-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

有序数组，但是有翻转，所以判断时不能只判断 nums[mid] 和 target的大小，还需要考虑是否右翻转情况
1.nums[mid] < target
判断 nums[left] > nums[mid] 说明前面有翻转 target在左边
判断 nums[left] <= target 说明target在左边
target
2.nums[mid] > target
判断 nums[right] < nums[mid] 说明有翻转企 target在右边
判断 nums[right] >= target 说明target在右边

```java
package n66.search;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                if (nums[right] < nums[mid] || nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] > nums[mid] || nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}

```