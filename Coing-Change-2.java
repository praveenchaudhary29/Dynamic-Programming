//Question - Leetcode(518 Medium)
class Solution {
    public int change(int amount, int[] coins) {
       int [][] dp = new int[coins.length][amount+1];
       for(int [] arr : dp){
        Arrays.fill(arr,-1);
       } 
       return solve(coins,0,amount,dp);
    }

    public int solve(int[] coins, int index, int amount,int [][] dp){
        if(amount == 0) return 1;
        if(index == coins.length) return 0;

        if(dp[index][amount]!=-1) return dp[index][amount];

        int notTake = solve(coins,index+1,amount,dp);
        int take = 0;
        if(amount >= coins[index]){
          take = solve(coins,index,amount-coins[index],dp);
        }
        

        return dp[index][amount] = take + notTake;
    }
}
