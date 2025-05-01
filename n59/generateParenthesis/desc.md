### 题目描述

https://leetcode.cn/problems/generate-parentheses/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

我们递归地构建字符串，每一步可以选择添加一个 ( 或 )，但必须遵守以下规则：
左括号不能大于 n
右括号不能大于左括号

```java
package n59.generateParenthesis;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), n, 0, 0);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder path, int n, int left, int right) {
        if (path.length() == n * 2) {
            res.add(path.toString());
            return;
        }

        if (left < n) {
            path.append("(");
            backtrack(res, path, n, left + 1, right);
            path.deleteCharAt(path.length() - 1);
        }
        if (right < left) {
            path.append(")");
            backtrack(res, path, n, left, right + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

```