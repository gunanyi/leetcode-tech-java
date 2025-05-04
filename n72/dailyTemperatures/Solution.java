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
