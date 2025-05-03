### 题目描述

https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

正确的括号需要成对出现 （）使用栈来处理即可，左括号进栈，右括号出栈判断是否匹配

```java
package n69.isValid;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>() {
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');
            }
        };
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char c1 = stack.pop();
                if (!map.containsKey(c1) || map.get(c1) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

```