//Question - Leetcode(583 Medium)
class Solution {
    public int minDistance(String word1, String word2) {
      int m = word1.length();
      int n = word2.length();
      int [][] dp = new int[m][n];
      for(int [] arr : dp  ){
        Arrays.fill(arr,-1);
      }
      int sol =  ans(word1,word2,m-1,n-1,dp);
      return m + n  - 2*sol; 
        
    }

       public int ans(String first, String second, int i, int j, int[][] dp){
        if(i <0 || j<0) return 0;
        if(dp[i][j] !=-1 ) return dp[i][j];

        if(first.charAt(i)==second.charAt(j)){
            return dp[i][j] = 1 + ans(first,second,i-1,j-1,dp);
        }

        return dp[i][j] = Math.max(ans(first,second,i-1,j,dp),ans(first,second,i,j-1,dp));
    }
}
