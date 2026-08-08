//Question - Leetcode(300 Medium)
class Solution {
    public int lengthOfLIS(int[] nums) {
       int[][] dp = new int[nums.length][nums.length+1];
       for(int [] arr : dp){
        Arrays.fill(arr,-1);
       }
       return ans(nums,0,-1,dp); 
    }

    public int ans(int [] nums, int index, int prev, int[][] dp){
        if(index == nums.length ) return 0;

        if(dp[index][prev+1] != -1) return dp[index][prev+1];

        int len = ans(nums,index+1,prev,dp);

        if(prev == -1 || nums[index]>nums[prev]){
            len = Math.max(len,1 + ans(nums,index+1,index,dp));
        }
    return dp[index][prev+1] = len;    
    }
}
