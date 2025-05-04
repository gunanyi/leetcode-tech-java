package n71.decodeString;

import java.util.Collections;
import java.util.LinkedList;

public class SolutionV2 {

    private int ptr;

    public static void main(String[] args) {
        SolutionV2 solution = new SolutionV2();
        System.out.println(solution.decodeString("3[a]2[bc]"));
    }

    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        while (this.ptr < s.length()) {
            Character c = s.charAt(this.ptr);
            if (Character.isDigit(c)) {
                String digit = this.getDigit(s);
                stack.addLast(digit);
            } else if (c == '[' || Character.isLetter(c)) {
                stack.addLast(String.valueOf(c));
                this.ptr++;
            } else {
                // 出栈
                LinkedList<String> stack2 = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    stack2.addLast(stack.removeLast());
                }

                Collections.reverse(stack2);
                // 左括号出栈
                stack.removeLast();
                // 次数
                int digit = Integer.parseInt(stack.removeLast());
                StringBuilder sb = new StringBuilder();
                String str2 = getString(stack2);
                for (int i = 0; i < digit; i++) {
                    sb.append(str2);
                }

                // 构造好的字符串入栈
                stack.addLast(sb.toString());
                this.ptr++;
            }
        }

        return getString(stack);
    }

    /**
     * 获取数字
     *
     * @param s string
     * @return string
     */
    public String getDigit(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(this.ptr))) {
            sb.append(s.charAt(this.ptr));
            this.ptr++;
        }

        return sb.toString();
    }


    public String getString(LinkedList<String> stack) {
        StringBuffer sb = new StringBuffer();
        for (String s : stack) {
            sb.append(s);
        }

        return sb.toString();
    }

}
