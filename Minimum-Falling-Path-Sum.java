//Question - LEETCODE (931 MEDIUM)
//TC - O(M*N) SC-O(M*N) + O(N)

class Solution {
    public int minFallingPathSum(int[][] matrix) {
      int m = matrix.length;
      int [][] dp = new int[m][m];
      for(int [] arr : dp){
        Arrays.fill(arr,Integer.MIN_VALUE);
      }
      int min = Integer.MAX_VALUE;
      for(int j = 0; j<m; j++){
        int ans = solve(m-1,j,matrix,dp);
        min = Math.min(min,ans);
      }
    return min;    
    }

    public int solve(int i, int j, int[][] matrix, int[][] dp){
        if(j<0 || j>=matrix.length) return Integer.MAX_VALUE;
        if(i==0) return matrix[i][j];

        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        
        int up = solve(i-1,j,matrix,dp);
        int ld = solve(i-1,j-1,matrix,dp);
        int rd = solve(i-1,j+1,matrix,dp);

        int ans = Math.min(up, Math.min(ld,rd));

        if(ans == Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return dp[i][j] = matrix[i][j] + ans;

    }
}
