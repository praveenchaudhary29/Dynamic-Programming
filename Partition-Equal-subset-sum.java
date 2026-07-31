//Question - Leetcode(416 Medium)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
       if(sum%2!=0) return false;
       int [][] dp = new int[nums.length][sum/2 + 1];
       for(int [] arr : dp){
        Arrays.fill(arr,-1);
       }
       return solve(nums,nums.length-1,sum/2,dp); 
    }

    public boolean solve(int [] nums, int index, int target, int [][] dp){
        if(target == 0) return true;
        if(index == 0) return nums[index] == target;
        if(dp[index][target] != -1) return dp[index][target] == 1?true:false;

        boolean notTake = solve(nums,index-1,target,dp);
        boolean take = false;
        if(target>=nums[index]) take = solve(nums,index-1,target-nums[index],dp);
        boolean ans = take || notTake ;
        dp[index][target] = ans ? 1 : 0;
        return ans;
    }
}
