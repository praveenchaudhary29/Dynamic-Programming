//Question - Leetcode (120 - Medium)
//TC - O(N2) SC- O(N2)
//MEMOIZATION APPROACH (TOP DOWN)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();
       int[][] dp = new int[n][n];
       for(int [] arr : dp){
        Arrays.fill(arr,Integer.MIN_VALUE);
       } 
       return solve(0,0,triangle,dp);
    }

    public int solve(int i, int j,List<List<Integer>> triangle, int[][] dp ){
      if( i == triangle.size()-1) return triangle.get(i).get(j);

      if(dp[i][j] != Integer.MIN_VALUE){
        return dp[i][j];
      }

      int down = solve(i+1,j,triangle,dp);
      int diag = solve(i+1,j+1,triangle,dp);
     
      return dp[i][j] = triangle.get(i).get(j) + Math.min(down,diag);

    }
}
