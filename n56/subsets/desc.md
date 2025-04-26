### 题目描述
https://leetcode.cn/problems/subsets/?envType=study-plan-v2&envId=top-100-liked

### 解题思路
子集的本质是组合，每个元素可以选或不选。
不需要 used 数组来记录元素是否使用（和全排列不同）。
每个递归节点代表一个子集，我们直接收集它。

```java
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

```
递归树
```less
                []
         /        |        \
      [1]        [2]       [3]
     /   \        |
 [1,2]  [1,3]   [2,3]
   |
[1,2,3]

```

