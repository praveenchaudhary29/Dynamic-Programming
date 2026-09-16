//Question-Leetcode(309 Medium)
class Solution {
    public int maxProfit(int[] prices) {
         int n = prices.length;

       int [][] dp = new int[n][2];
       for(int [] arr : dp){
        Arrays.fill(arr,-1);
       }

       return ans(0,1,prices,dp); 
        
    }
    public int ans(int index, int buy, int [] prices, int [][] dp){
        if(index >= prices.length) return 0;

        if(dp[index][buy]!=-1) return dp[index][buy];

        int profit ;

        if(buy==1){
           int take = -prices[index] + ans(index+1,0,prices,dp);
           int notTake = ans(index+1,1,prices,dp);
           profit = Math.max(take,notTake);
        }else{
           int take = prices[index] + ans(index+2,1,prices,dp);
           int notTake = ans(index+1,0,prices,dp);
           profit = Math.max(take,notTake);
        }
        return dp[index][buy] = profit;

    }
}
