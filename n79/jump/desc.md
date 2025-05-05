### 题目链接

https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

和跳跃游戏不同的是，我们需要统计最小次数，怎么统计最小次数呢？我们需要知道在什么时候需要把次数+1，
次数+1的时机，就是当遍历到本次最大可达到的下标时。所以我们需要一个变量存储这个边界，并在到达时+1，并更新为maxStep

```java
package n79.jump;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{1, 1, 1, 1}));
    }

    public int jump(int[] nums) {
        int reach = 0; // 可到达最大距离
        int end = 0; // 边界
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            reach = Math.max(reach, i + nums[i]);
            if (i == end) {
                res++;
                end = reach;
            }
        }

        return res;
    }
}

```