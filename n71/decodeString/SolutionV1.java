package n71.decodeString;

import java.util.Stack;

public class SolutionV1 {
    public static void main(String[] args) {
        SolutionV1 solution = new SolutionV1();
        System.out.println(solution.decodeString("100[leetcode]"));
    }

    // 自己实现，代码比较复杂
    public String decodeString(String s) {
        Stack<Character> stack1 = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ']') { // 出栈
                String str = getString(stack1);
                // 获取数字
                int num = getNums(stack1);
                StringBuilder stringBuilder = new StringBuilder(str);
                for (int j = 1; j < num; j++) {
                    stringBuilder.append(str);
                }
                str = stringBuilder.toString();
                if (a > 1) {
                    for (int j = 0; j < str.length(); j++) {
                        stack1.push(str.charAt(j));
                    }
                } else {
                    // 注意这里，如果还有字符串，顺序时 sb + str1 + str
                    String str1 = getString(stack1);
                    sb.append(str1);
                    sb.append(str);
                }
                a--;
            } else {
                // 入栈
                if (c == '[') {
                    a++;
                }
                stack1.push(c);
            }
        }

        String str = getString(stack1);
        if (str != null && !str.isEmpty()) {
            sb.append(str);
        }

        return sb.toString();
    }

    public String getString(Stack<Character> stack1) {
        Stack<Character> stack2 = new Stack<>();
        while (!stack1.isEmpty()) {
            Character c1 = stack1.pop();
            if (c1 == '[') {
                break;
            }
            stack2.push(c1);
        }
        // 获取字符串
        StringBuilder strBuilder = new StringBuilder();
        while (!stack2.isEmpty()) {
            strBuilder.append(stack2.pop());
        }

        return strBuilder.toString();
    }

    public int getNums(Stack<Character> stack1) {
        StringBuilder strBuilder = new StringBuilder();
        Stack<Character> stack2 = new Stack<>();
        Character c2 = stack1.pop();
        while (c2 - '0' >= 0 && c2 - '0' <= 9) {
            stack2.push(c2);
            if (stack1.isEmpty()) {
                break;
            }
            c2 = stack1.pop();
        }
        if (!stack1.isEmpty()) {
            stack1.push(c2);
        }
        while (!stack2.isEmpty()) {
            strBuilder.append(stack2.pop());
        }

        return Integer.parseInt(strBuilder.toString());
    }
}
