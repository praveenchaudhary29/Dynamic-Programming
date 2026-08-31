//Question - Not on Leetcode
class Solution {

    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s1, s2, 0, 0, dp);
    }

    static int solve(String s1, String s2, int i, int j, int[][] dp) {

        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int match = 0;

        // Characters match -> substring continues
        if (s1.charAt(i) == s2.charAt(j)) {
            match = 1 + solve(s1, s2, i + 1, j + 1, dp);
        }

        // We need the maximum over all possible starting positions
        int skipS1 = solve(s1, s2, i + 1, j, dp);
        int skipS2 = solve(s1, s2, i, j + 1, dp);

        return dp[i][j] = Math.max(match, Math.max(skipS1, skipS2));
    }
}
