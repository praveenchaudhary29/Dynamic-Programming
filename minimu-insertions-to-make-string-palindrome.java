//Question - Leetcode(1312 Hard)
class Solution {
    public int minInsertions(String s) {

        if(checkPalindrome(s)) return 0;

        int m = s.length();
        int [][] dp = new int[m][m];
        for(int [] arr : dp){
        Arrays.fill(arr,-1);
        }
        StringBuilder s1 = new StringBuilder(s);
        s1 = s1.reverse();
        String rev = s1.toString();
        int ans = solve(s,rev,m-1,m-1,dp);
        return m-ans;
        
    }

      public int solve(String s1, String s2, int j, int k, int[][] dp){
        if(j<0 || k<0) return 0;

        if(dp[j][k] != -1) return dp[j][k];

        if(s1.charAt(j) == s2.charAt(k)) return dp[j][k] = 1 + solve(s1,s2,j-1,k-1,dp);

        return dp[j][k] = Math.max(solve(s1,s2,j-1,k,dp),solve(s1,s2,j,k-1,dp));
    }

    public boolean checkPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
    return true;    
    }
}
