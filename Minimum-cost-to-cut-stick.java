//Question - Leetcode(1547 Hard)
class Solution {
    public int minCost(int n, int[] cuts) {
       int m = cuts.length;

       int [] arr = new int[m+2];

       //Add Boundaries

       arr[0] = 0;
       arr[m+1] = n;

       for(int i = 0; i<m; i++){
        arr[i+1] = cuts[i];
       }

       Arrays.sort(arr);
       

       int [][] dp = new int[m+2][m+2];

       for(int [] arr1 : dp){
        Arrays.fill(arr1,-1);
       }

       return solve(0,m+1,dp,arr);
    }

    public int solve(int i, int j, int [][] dp, int[] arr ){

        if(j-i<=1) return 0; // No partition left in between boundaries

        if(dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;

        for(int k=i+1; k<j; k++){
            int cost = arr[j] - arr[i] + solve(i,k,dp,arr) + solve(k,j,dp,arr);
            min = Math.min(min,cost);
        }
    return dp[i][j] = min;
    }
}
