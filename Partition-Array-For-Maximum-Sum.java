//Question - Leetcode(1043 Medium)
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
       int [] dp = new int[arr.length];
       Arrays.fill(dp,-1);
       return solve(0,arr,k,dp); 
    }

    public int solve(int i, int [] arr, int k, int [] dp){
        if(i == arr.length) return 0;
        if(dp[i] != -1) return dp[i];

        int max =  Integer.MIN_VALUE;
        int maximum = Integer.MIN_VALUE;

        int ind = i+k-1;

        if(ind >= arr.length) ind = arr.length-1; 

        for(int j = i; j<= ind ; j++){
           maximum = Math.max(maximum,arr[j]);
           int cost = maximum*(j-i+1) + solve(j+1,arr,k,dp);
           max = Math.max(cost,max);
        }
        return dp[i] = max;
    }
}
