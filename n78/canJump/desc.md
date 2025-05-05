### 题目链接

https://leetcode.cn/problems/jump-game/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

使用reach表示当前可以跳到的位置，然后循环数组，更新reach为最大可以跳到的位置，如果到了数组末尾返回true，如果最后到不了返回false

```java
package n78.canJump;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= reach) {
                reach = Math.max(reach, i + nums[i]);
                if (reach >= nums.length - 1) {
                    return true;
                }
            }
        }

        return false;
    }
}

```