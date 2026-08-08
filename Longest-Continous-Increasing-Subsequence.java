//Question - Leetcode(674 Easy)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
     int len = 1;
     int maxlen = 1;
     int l = 0;
     int r = 1;
     while(r<nums.length){
        if(nums[l]<nums[r]){
            len++;
            maxlen = Math.max(len,maxlen);
        }else{
            len=1;
        }
        l++;
        r++;
     }
    return maxlen; 
    }
}
