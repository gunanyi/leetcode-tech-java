package n77.maxProfit;

public class Solution {

    public int maxProfit(int[] prices) {
        int minVal = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minVal) {
                minVal = prices[i];
            } else if (prices[i] - minVal > maxProfit) {
                maxProfit = prices[i] - minVal;
            }
        }

        return maxProfit;
    }
}
