### 题目描述

https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-100-liked

### 解题思路

使用回溯思路，来查找字符串即可，但是需要使用额外空间来记录是否访问过

```java
package n60.exist;

public class Solution {

    public boolean exist(char[][] board, String word) {
        int[][] read = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    read[i][j] = 1;
                    if (check(board, word, i, j, 1, read)) {
                        return true;
                    }
                    read[i][j] = 0;
                }
            }
        }

        return false;
    }

    private boolean check(char[][] board, String word, int row, int col, int curIndex, int[][] read) {
        if (curIndex == word.length()) {
            return true;
        }

        if (row + 1 < board.length && read[row + 1][col] == 0 && board[row + 1][col] == word.charAt(curIndex)) {
            read[row + 1][col] = 1;
            if (check(board, word, row + 1, col, curIndex + 1, read)) {
                return true;
            }
            read[row + 1][col] = 0;
        }

        if (row > 0 && read[row - 1][col] == 0 && board[row - 1][col] == word.charAt(curIndex)) {
            read[row - 1][col] = 1;
            if (check(board, word, row - 1, col, curIndex + 1, read)) {
                return true;
            }
            read[row - 1][col] = 0;
        }

        if (col + 1 < board[0].length && read[row][col + 1] == 0 && board[row][col + 1] == word.charAt(curIndex)) {
            read[row][col + 1] = 1;
            if (check(board, word, row, col + 1, curIndex + 1, read)) {
                return true;
            }
            read[row][col + 1] = 0;
        }

        if (col > 0 && read[row][col - 1] == 0 && board[row][col - 1] == word.charAt(curIndex)) {
            read[row][col - 1] = 1;
            if (check(board, word, row, col - 1, curIndex + 1, read)) {
                return true;
            }
            read[row][col - 1] = 0;
        }

        return false;
    }
}

```