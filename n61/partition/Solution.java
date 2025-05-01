package n61.partition;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.partition("aab"));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        this.backTrack(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void backTrack(String s, int index, List<String> partition, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(partition));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String subStr = s.substring(index, i + 1);
            if (this.isPartition(subStr)) {
                partition.add(subStr);
                backTrack(s, i + 1, partition, res);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPartition(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
