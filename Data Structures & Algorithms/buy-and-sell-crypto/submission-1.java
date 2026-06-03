class Solution {


    public int maxProfit(int[] prices) {
        

        int maxProfit=0;
        int buyIndex=0;
        for(int i=0;i< prices.length;i++){

            maxProfit= Math.max(maxProfit,prices[i]-prices[buyIndex]);

            buyIndex=prices[buyIndex]>prices[i]?i:buyIndex;
        }
    return maxProfit;

    }
}
