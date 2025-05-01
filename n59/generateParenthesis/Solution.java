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
