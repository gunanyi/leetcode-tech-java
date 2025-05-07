package n83.rob;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{2, 1, 1, 2}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        temp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            temp[i] = Math.max(temp[i - 2] + nums[i], temp[i - 1]);
        }

        return temp[nums.length - 1];
    }
}
