class Solution {
    public int missingNumber(int[] nums){
        int i = 0;
        while(i < nums.length){
            int correct = nums[i];
            if(nums[i] < nums.length && nums[correct] != nums[i]) swap(nums,i,correct);
            else i++;
        }
        for (int index = 0; index < nums.length; index++) {
            if(nums[index] != index) return index;
        }
        return nums.length;
    }
    void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}