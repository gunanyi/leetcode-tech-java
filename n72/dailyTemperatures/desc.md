### 题目描述

https://leetcode.cn/problems/daily-temperatures/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

暴力解法：暴力解法时间复杂度较高，需要对于每一个元素遍历它后面的元素。

为什么要使用单调栈？
因为数组中存在部分有序的情况，可以使用单调栈来减少遍历。
单调栈的作用：

记录未确定答案的索引：栈中保存的是尚未找到更高温度的日期索引。
维护单调性：栈内温度从栈底到栈顶保持递减，确保新元素若比栈顶温度高，即可直接触发答案计算。

算法步骤：
如果栈不为，并且当前温度大于栈顶指针对应的问题，则
res[top] = i-top
否则，则入栈,栈保证温度从栈顶到栈底是递增的。

```java
package n72.dailyTemperatures;

import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.removeFirst();
                result[index] = i - index;
            }

            stack.addFirst(i);
        }

        return result;
    }
}

```