//Question - Leetcode(123 Hard)
class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;

       int [][][] dp = new int[n][2][3];
       for(int [][] arr : dp){
         for(int [] a : arr){
           Arrays.fill(a,-1);
         }
        
       }

       return ans(0,1,prices,dp,2); 
        
    }

      public int ans(int index, int buy, int [] prices, int [][][] dp,int cap){
        if(index == prices.length) return 0;

        if(cap==0) return 0;

        if(dp[index][buy][cap]!=-1) return dp[index][buy][cap];

        int profit ;

        if(buy==1){
           int take = -prices[index] + ans(index+1,0,prices,dp,cap);
           int notTake = ans(index+1,1,prices,dp,cap);
           profit = Math.max(take,notTake);
        }else{
           int take = prices[index] + ans(index+1,1,prices,dp,cap-1);
           int notTake = ans(index+1,0,prices,dp,cap);
           profit = Math.max(take,notTake);
        }
        return dp[index][buy][cap] = profit;
    }
}
