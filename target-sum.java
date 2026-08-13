//Question - Leetcode(494 Medium)
class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int total = 0;

        for(int num : nums){
            total += num;
        }

        if(target > total) return 0;
        int [][] dp =  new int[nums.length][2*total+1];

        for(int [] arr : dp){
            Arrays.fill(arr,-1);
        }
        return solve(nums,0,target,0,dp,total);
    }

    public int solve(int [] nums, int index,int target,int sum, int[][] dp,int offset){
        if(index==nums.length && sum == target) return 1;
        if(index==nums.length) return 0;

        int col = sum + offset;

        if(dp[index][col]!=-1) return dp[index][col];

        int pos = solve(nums,index+1,target,sum+nums[index],dp,offset);
        int neg = solve(nums,index+1,target,sum-nums[index],dp,offset);

        return dp[index][col] = pos + neg;
    }
}
