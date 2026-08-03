//Question - Leetcode(1137 Easy)
class Solution {
    public int tribonacci(int n) {
      if(n==0) return 0;  
      int third = 0;
      int second = 1;
      int first = 1;
      for(int i=3; i<=n; i++){
       int ans = third + first + second;
       third = second;
       second = first;
       first = ans;
      }
    return first;    
    }
}
