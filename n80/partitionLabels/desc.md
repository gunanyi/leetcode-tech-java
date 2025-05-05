### 题目链接

### 解题思路

核心思想：通过记录每个字符的最后出现位置，动态维护当前区间的最大结束位置，当遍历到该位置时分割区间。
为什么要记录最后位置，由于最后位置决定区间的大小。

步骤：
记录字符最后位置：遍历字符串，用数组或哈希表存储每个字符最后一次出现的索引。
双指针遍历：
初始化 start 和 end 表示当前区间的起始和结束位置。
遍历字符串，更新 end 为当前字符最后出现位置的最大值。

当遍历到 end 时，记录区间长度，并重置 start 为 end + 1。

```java
package n80.partitionLabels;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partitionLabels("ababc"));
    }

    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}

```
