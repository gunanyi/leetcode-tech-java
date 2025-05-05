package n78.canJump;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public boolean canJump(int[] nums) {
        int reach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= reach) {
                reach = Math.max(reach, i + nums[i]);
                if (reach >= nums.length - 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
