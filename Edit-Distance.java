//Question - Leetcode(72 medium)
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int [][] dp = new int[m][n];
        for(int [] arr : dp){
            Arrays.fill(arr,-1);
        }

        return solve(m-1,n-1,word1,word2,dp);
    }

    public int solve(int i, int j, String word1, String word2, int[][] dp){

       if(i<0) return j+1;
       if(j<0) return i+1;

       if(dp[i][j] != -1) return dp[i][j];

       if(word1.charAt(i) == word2.charAt(j)) return dp[i][j] = solve(i-1,j-1,word1,word2,dp);

       return dp[i][j] = 1 + Math.min(solve(i-1,j,word1,word2,dp),Math.min(solve(i-1,j-1,word1,word2,dp),solve(i,j-1,word1,word2,dp)));
    }
}
