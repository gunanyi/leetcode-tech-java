### 题目描述
https://leetcode.cn/problems/course-schedule/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路
使用3色状态来判断是否有环
当我们访问node时，设置状态为1
然后遍历node的边
当我们访问遇到1时，说明有环
访问完成时，设置node为2

```java
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] prerequisites = new int[][]{{0,1},{1,0}};
        System.out.println(solution.canFinish(2, prerequisites));
    }

    // 使用DFC判断是否有环
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 存储边
        List<List<Integer>> edges = new ArrayList<>(numCourses);
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            edges.get(prerequisite[0]).add(prerequisite[1]);
        }

        // 判断是否有环
        for(int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && hasCycle(i, edges,visited)) {
                return false;
            }
        }


        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> edges, int[] visited) {
        visited[node] = 1;
        List<Integer> edge = edges.get(node);
        for (Integer i : edge) {
            if (visited[i] == 1) {
                return true;
            }
            if (visited[i] == 0 && hasCycle(i,edges,visited)) {
                return true;
            }
        }

        visited[node] = 2;
        return false;
    }
}

```