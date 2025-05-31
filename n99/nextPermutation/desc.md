### 题目描述

https://leetcode.cn/problems/next-permutation/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

1.首先从后向前找，找到第一个非降序的数
比如 5 4 7 2 1
找到 i 这时nums[i] > nums[i-1]  i-nums.length是降序
然后寻找 i-nums.length之间大于nums[i-1]的最小数和i-1交换
交换后 i-nums.length 降序
这时翻转i-nums.length 就是结果

```java
package n99.nextPermutation;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 5, 1};
        solution.nextPermutation(nums);
        System.out.println(nums);
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i > 0) {
            int j = nums.length - 1;
            while (j >= i && nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(nums, i - 1, j);
        }

        revert(nums, i);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void revert(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

```