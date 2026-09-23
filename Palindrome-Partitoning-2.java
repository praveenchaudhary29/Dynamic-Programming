//Question - Leetcode(132 Hard)
class Solution {
    public int minCut(String s) {
        int n = s.length();
        int [] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,n,dp,s)-1;
        
    }

    public int solve(int i, int n, int [] dp, String str){
        if(i == n) return 0;
        if(dp[i] != -1) return dp[i];

        int min = Integer.MAX_VALUE;

        for(int j=i; j<n;j++){
            if(isPalin(i,j,str)){
                int cost = 1 + solve(j+1,n,dp,str);
                min = Math.min(min,cost);
            }
        }
     return dp[i] = min;   
    }

    public boolean isPalin(int i, int j, String str){
        while(i<j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
     return true;   
    }
}
