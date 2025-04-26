package n55.permute;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        int[] used = new int[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        backTrack(nums, used, path, result);
        return result;
    }

    public void backTrack(int[] nums,int[] used,List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }

            path.add(nums[i]);
            used[i] = 1;
            backTrack(nums,used,path,result);
            used[i] = 0;
            path.remove(path.size()-1);
        }
    }
}
