//Question - (LEETCODE 213 MEDIUM )
class Solution {
    public int rob(int[] nums) {
       if(nums.length == 1) return nums[0];
       return Math.max(robber(nums,0,nums.length-1), robber(nums,1,nums.length)); 
    }
    public int robber(int [] nums, int s, int e){
      int prev = nums[s];
      int prev2 = 0;
      for(int i = s+1 ; i<e; i++){
        int take = nums[i];
        if(i>s) take += prev2;
        int notTake  = prev;
        int curr = Math.max(take,notTake);
        prev2 = prev;
        prev = curr;
      }  
    return prev;  
    }
}
