//Question - Leetcode(746 easy)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
     if(cost.length==1) return cost[0];
     int [] dp = new int[cost.length+1];
     Arrays.fill(dp,-1);
     return Math.min(solve(cost,dp,0),solve(cost,dp,1));
    }

    public int solve(int [] cost, int[] dp, int index){
        if(index == cost.length) return 0;
        if(dp[index]!=-1) return dp[index];

        int one = solve(cost,dp,index+1) + cost[index];
        int two = Integer.MAX_VALUE;
        if(index < cost.length-1) two = solve(cost,dp,index+2) + cost[index];

        return dp[index] = Math.min(one,two);
    }
}
