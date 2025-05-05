package n79.jump;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.jump(new int[]{1, 1, 1, 1}));
    }

    public int jump(int[] nums) {
        int reach = 0; // 可到达最大距离
        int end = 0; // 边界
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            reach = Math.max(reach, i + nums[i]);
            if (i == end) {
                res++;
                end = reach;
            }
        }

        return res;
    }
}
