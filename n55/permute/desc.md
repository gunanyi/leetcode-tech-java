### 题目描述
https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路
使用回溯遍历所有可能情况，回溯返回时恢复到上一个状态。
初始化结果数组 res = []
递归函数中：
如果当前路径满足终止条件（例如：长度和 nums 一样），将其加入 res
否则，遍历所有可能的选
如果当前数字没有用过
做出选择
递归调用
撤销选择（回溯）


使用一个 used 数组标记数字是否被使用。
每次递归选择一个未使用的数字。

                []
         /       |       \
      [1]      [2]      [3]
     /   \      / \      / \
[1,2][1,3] [2,1][2,3][3,1][3,2]
|     |    |    |    |    |
[1,2,3][1,3,2][2,1,3][2,3,1][3,1,2][3,2,1]

代码：
```java
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

```