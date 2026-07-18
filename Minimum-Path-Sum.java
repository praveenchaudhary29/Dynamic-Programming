//Question - LEETCODE(64 Medium)
class Solution {
    public int minPathSum(int[][] grid) {
      int [][] dp =  new int[grid.length][grid[0].length];
      for(int [] arr : dp){
        Arrays.fill(arr,-1);
      }
      return pathss(grid.length-1,grid[0].length-1,grid,dp); 
    }

      public int pathss(int m, int n, int[][]grid, int[][] dp){
      if( m==0 && n==0) return dp[m][n] = grid[m][n];
      if(m<0 || n<0 ) return Integer.MAX_VALUE;

       if(dp[m][n]!=-1) return dp[m][n];

       int up =  pathss(m-1,n,grid,dp);
       int left =  pathss(m,n-1,grid,dp);
       
       int ans = Math.min(up,left);

       

       return dp[m][n] = grid[m][n] + ans;
    }

}
