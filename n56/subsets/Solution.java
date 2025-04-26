package n56.subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(0, nums, path, res);
        return res;
    }

    public void backtrack(int start,int[] nums,List<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i= start;i<nums.length;i++) {
            path.add(nums[i]);
            backtrack(i+1,nums,path,res);
            path.remove(path.size()-1);
        }
    }
}
