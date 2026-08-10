//Question - Leetcode 322 (Medium)
class Solution {
    public int coinChange(int[] coins, int amount) {
       int dp[][] = new int[coins.length][amount+1];
       for(int [] row:dp){
        Arrays.fill(row,-1);
       } 
       int ans = solve(coins,0,amount,dp);
       return ans == Integer.MAX_VALUE ? -1 : ans ;
    }

    public static int solve(int [] coins, int index, int amount, int [][] dp){
        if(amount == 0) return 0;

        if(index==coins.length) return Integer.MAX_VALUE;

        if(dp[index][amount]!=-1) return dp[index][amount];
        
        int notTake = solve(coins,index+1,amount,dp);
        int take = Integer.MAX_VALUE;
        if(coins[index]<=amount){
            take = solve(coins,index,amount-coins[index],dp);
        }

        if(take != Integer.MAX_VALUE) take += 1;

        return dp[index][amount] = Math.min(take,notTake);
    }

}
