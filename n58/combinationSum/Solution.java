package n58.combinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[]{2}, 1));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findAll(candidates, target, 0, path, res);
        return res;
    }

    private void findAll(int[] candidates, int target, int index, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }

            path.add(candidates[i]);
            target -= candidates[i];
            findAll(candidates, target, i, path, res);
            path.remove(path.size() - 1);
            target = target + candidates[i];
        }
    }
}
