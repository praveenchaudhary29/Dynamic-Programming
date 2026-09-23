//Question - Leetcode(312 Hard)
class Solution {
    public int maxCoins(int[] nums) {
      int n = nums.length;
      int [] arr = new int[n+2];
      arr[0] = 1;
      arr[n+1] = 1; 
      for(int i=0; i<n; i++){
        arr[i+1] = nums[i];
      }
      int [][] dp = new int[n+2][n+2];
      for(int [] arr1 : dp){
        Arrays.fill(arr1,-1);
      }
      return solve(0,n+1,arr,dp);   
    }

    public int solve(int i, int j, int[] arr, int [][] dp){
        if(j-i <= 1) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int maxi = Integer.MIN_VALUE;

        for(int k = i+1;k<j;k++){
          int cost = arr[k]*arr[i]*arr[j] + solve(i,k,arr,dp) + solve(k,j,arr,dp);

          maxi = Math.max(maxi,cost);
        }
    return dp[i][j] = maxi;    
    }
}
