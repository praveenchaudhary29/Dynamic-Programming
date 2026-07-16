//Question - LEETCODE(63 MEDIUM)

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       if(obstacleGrid[0][0]==1) return 0;
       int [][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
      for(int [] arr : dp){
        Arrays.fill(arr,-1);
      }
      return pathss(obstacleGrid.length-1,obstacleGrid[0].length-1,dp,obstacleGrid);
    }

    public int pathss(int m, int n, int [][] dp, int[][] grid){
        if( m==0 && n==0) return 1;
        if(m<0 || n<0 || grid[m][n]==1) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        int up = pathss(m-1,n,dp,grid);
        int left = pathss(m,n-1,dp,grid);
        return dp[m][n] = up + left;
    }
}
