class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;//buy
        int profit=0;

        int sell=0;

        for(int i=0;i<prices.length;i++){
           if(prices[i] < min ){
            min=prices[i];
           }

           sell=prices[i]- min;
           if(profit < sell){
            profit=sell;
           }
        }

        return profit;

    }
}
