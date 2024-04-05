class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        dp[n][0]=dp[n][1]=0;// no stocks left to buy or sell

        int profit=0;

        for(int index=n-1; index>=0;index--){
            for(int buy=0; buy<=1;buy++){
                if(buy==1){  //can buy stock
                    profit=Math.max(- prices[index] + dp[index+1][0] , 0+ dp[index+1][1]);
                    // buy stock [index+1][0(can't buy')] , not buy [index+1][1(can buy next)]
                }
                if(buy==0){ //can sell, can't buy
                    profit=Math.max(prices[index]+dp[index+1][1], 0+dp[index+1][0]);
                    // sell stock [index+1][1(can buy next)], [index+1][0(can't buy next)]
                }
                dp[index][buy]=profit;
            }
        }
        return dp[0][1];
    }
}
