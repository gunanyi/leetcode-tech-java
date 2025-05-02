### 题目描述

https://leetcode.cn/problems/search-a-2d-matrix/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

使用二分查找即可，不过需要转化成行和列
/cols mod cols

```java
package n64.seatchMatrix;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int end = rows * cols - 1;
        int start = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int i = mid / cols;
            int j = mid % cols;
            if (matrix[i][j] == target) {
                return true;
            }

            if (matrix[i][j] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
}

```