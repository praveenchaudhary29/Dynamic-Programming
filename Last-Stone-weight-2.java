//Question- Leetcode(1049 Medium)
class Solution {
    public int lastStoneWeightII(int[] stones) {
      int sum = 0;
      for(int num : stones){
        sum += num;
      }
      int target = sum/2;
      int [][] dp = new int[stones.length][target+1];
      for(int [] row : dp){
        Arrays.fill(row,-1);
      }
      int best = solve(stones,0,dp,target);
      return sum - 2*best;
    }

    public int solve(int [] stones, int index, int [][] dp, int target){
        if(index == stones.length) return 0;
        
        if(dp[index][target]!=-1)return dp[index][target];

        int notTake = solve(stones,index+1,dp,target);
        int Take = 0;
        if(stones[index]<=target){
            Take = stones[index] + solve(stones,index+1,dp,target-stones[index]); 
        }

        return dp[index][target] = Math.max(Take,notTake);
    }
}
