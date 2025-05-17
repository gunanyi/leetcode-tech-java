package n88.maxProduct;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(new int[]{-2, 3, -4}));
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0] = new int[]{nums[0], nums[0]};
        for (int i = 1; i < nums.length; i++) {
            int[] temp = new int[]{nums[i], nums[i]};
            int[] pre = dp[i - 1];
            for (int a : pre) {
                temp[0] = Math.min(temp[0], nums[i] * a);
                temp[1] = Math.max(temp[1], nums[i] * a);
            }
            dp[i] = temp;
            max = Math.max(max, dp[i][1]);
        }

        return max;
    }
}
