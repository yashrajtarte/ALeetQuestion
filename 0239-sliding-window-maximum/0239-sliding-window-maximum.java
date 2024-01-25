class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
  
        Deque<Integer> q=new ArrayDeque<>();
        int j=0;
        int ans[]=new int[nums.length-k+1];
        int i=0;
        for(i=0;i<k;i++){
            while(!q.isEmpty()&&nums[i]>=nums[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }
        for(int index=i;index<nums.length;index++){
            ans[j++]=nums[q.peek()];
            while(!q.isEmpty() && q.peek() <= index-k){
                q.removeFirst();
            }
            while(!q.isEmpty() && nums[index] >= nums[q.peekLast()]){
                q.removeLast();
            }
            q.addLast(index);
        }
        ans[j] = nums[q.peek()];
        return ans;
    
    }
}