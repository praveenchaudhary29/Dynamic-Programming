//Question - Leetcode(516 Medium)
class Solution {
    public int longestPalindromeSubseq(String s) {
       int m = s.length();
       int [][] dp = new int[m][m];
       for(int [] arr : dp){
        Arrays.fill(arr,-1);
       }
        StringBuilder s1 = new StringBuilder(s);
        s1 = s1.reverse();
        String rev = s1.toString();
        return solve(s,rev,m-1,m-1,dp);
       } 
    

    public int solve(String s1, String s2, int j, int k, int[][] dp){
        if(j<0 || k<0) return 0;

        if(dp[j][k] != -1) return dp[j][k];

        if(s1.charAt(j) == s2.charAt(k)) return dp[j][k] = 1 + solve(s1,s2,j-1,k-1,dp);

        return dp[j][k] = Math.max(solve(s1,s2,j-1,k,dp),solve(s1,s2,j,k-1,dp));
    }
}
