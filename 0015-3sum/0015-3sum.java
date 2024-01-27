import java.util.AbstractList;

class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> threeSum(int[] nums) {
        return new AbstractList<List<Integer>>() {

            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }

            public int size() {
                init();
                return res.size();
            }

            private void init() {
                if (res != null) return;
                Arrays.sort(nums);
                ArrayList<List<Integer>> ans = new ArrayList<>();

                for (int i = 0; i < nums.length; i++) {
                    if (i != 0 && nums[i] == nums[i - 1]) continue; // Avoid repetition
                    twoSum(i, ans);
                }
                res = ans;
            }

            private void twoSum(int i, ArrayList<List<Integer>> ans) {
                int target = -nums[i], left = i + 1, right = nums.length - 1;

                while (left < right) {
                    //Skip repeating second number
                    if (i + 1 < left && nums[left - 1] == nums[left]) {
                        left++;
                        continue;
                    }
                    if (nums[left] + nums[right] > target) right--;
                    else if (nums[left] + nums[right] < target) left++;
                    else {
                        ArrayList<Integer> l = new ArrayList<>(3); // 3 is the size of list
                        l.add(nums[i]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        ans.add(l);
                        left++; // move to next pair
                    }
                }
            }
        };
    }
}