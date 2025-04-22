package solution_52;

import java.util.ArrayList;

public class Solution {
    // orangesRotting 统计全部腐烂所需时间
    public int orangesRotting(int[][] grid) {
        ArrayList<int[]> nodeList = new ArrayList<int[]>();
        int res = 0, normalOranges = 0;
        int row = grid.length,col = grid[0].length;
        // 查找当前所有腐烂橘子;
        for (int i = 0; i < row; i++) {
            for (int j =0; j < col; j++) {
                if (grid[i][j] == 1) {
                    normalOranges++;
                }else if (grid[i][j] == 2) {
                    nodeList.add(new int[]{i, j});
                }
            }
        }

        // 进行遍历，每次把挨着腐烂的橘子变为腐烂
        while (!nodeList.isEmpty()) {
            ArrayList<int[]> nodeListNew = new ArrayList<>();
            for (int[] node : nodeList) {
                if (node[0]-1 >= 0 && grid[node[0]-1][node[1]] == 1) {
                    grid[node[0]-1][node[1]] = 2;
                    nodeListNew.add(new int[]{node[0]-1, node[1]});
                    normalOranges--;
                }

                if (node[0]+1 < row && grid[node[0]+1][node[1]] == 1) {
                    grid[node[0]+1][node[1]] = 2;
                    nodeListNew.add(new int[]{node[0]+1, node[1]});
                    normalOranges--;
                }

                if (node[1]-1 >= 0 && grid[node[0]][node[1]-1] == 1) {
                    grid[node[0]][node[1]-1] = 2;
                    nodeListNew.add(new int[]{node[0],node[1]-1});
                    normalOranges--;
                }

                if (node[1]+1 < col && grid[node[0]][node[1]+1] == 1) {
                    grid[node[0]][node[1]+1] = 2;
                    nodeListNew.add(new int[]{node[0],node[1]+1});
                    normalOranges--;
                }
            }
            nodeList = nodeListNew;
            if (!nodeList.isEmpty()) {
                res++;
            }
        }

        // 是否有正常橘子
        if (normalOranges > 0) {
            return -1;
        }

        return res;
    }
}
