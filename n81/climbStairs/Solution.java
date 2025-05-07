package n81.climbStairs;

public class Solution {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int pre0 = 1, pre1 = 2;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = pre0 + pre1;
            pre0 = pre1;
            pre1 = res;
        }

        return res;
    }
}
