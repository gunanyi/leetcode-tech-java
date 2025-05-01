package n57.lettrCombinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations("234");
        System.out.println(result);
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        Map<Character, String> letterMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        this.backtrack(digits, 0, new StringBuilder(), letterMap, result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder pathStr, Map<Character, String> letterMap, List<String> result) {
        if (index == digits.length()) {
            result.add(pathStr.toString());
            return;
        }

        String letters = letterMap.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            pathStr.append(letters.charAt(i));
            backtrack(digits, index + 1, pathStr, letterMap, result);
            pathStr.deleteCharAt(pathStr.length() - 1);
        }
    }
}
