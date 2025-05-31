package n99.nextPermutation;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 5, 1};
        solution.nextPermutation(nums);
        System.out.println(nums);
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i] <= nums[i - 1]) {
            i--;
        }
        if (i > 0) {
            int j = nums.length - 1;
            while (j >= i && nums[j] <= nums[i - 1]) {
                j--;
            }
            swap(nums, i - 1, j);
        }

        revert(nums, i);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void revert(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
