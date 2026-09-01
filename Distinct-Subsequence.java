//Question - Leetcode(115 Hard)
class Solution {
    public int numDistinct(String s, String t) {
      int m = s.length();
      int n =  t.length();
      int [][] dp = new int[m][n];
      for(int [] arr : dp  ){
        Arrays.fill(arr,-1);
      }
      return ans(s,t,m-1,n-1,dp);
        
    }
     public int ans(String first, String second, int i, int j, int[][] dp){
        
        if(j<0) return 1;

        if(i<0) return 0;

        if(dp[i][j] !=-1 ) return dp[i][j];

        if(first.charAt(i)==second.charAt(j)){
            int take =  ans(first,second,i-1,j-1,dp);
            int skip =  ans(first,second,i-1,j,dp);
            return dp[i][j] = take + skip;
        }

        return dp[i][j] =  ans(first,second,i-1,j,dp);
    }
}
