//TC - O(N*N)*N = N3    SC-O(N*N)+O(N)
public int mcm(int [] arr){
 int[][] dp = new int[arr.length][arr.length];
  for(int [] arr1 : dp){
    Arrays.fill(arr1,-1);
  }
  return solve(1,arr.length-1,arr,dp);
}

public int solve(int i, int j,int [] arr, int[][] dp){    // This function returns the minimum no. of operations required to multiply matrix i -> j int the given arr
  if(i == j) return 0;
  if(dp[i][j] ! -1) return dp[i][j];
  inr mini = Integer.MAX_VALUE;
  for(int k=i;k<j;k++){
    int steps = arr[i-1] * arr[k] * arr[j] + f(i,k,arr,dp) + f(k+1,j,arr,dp);
    mini = Math.min(steps,mini);
  }
  return dp[i][j] = mini;
}
