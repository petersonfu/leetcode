import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null) return 0;
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        int closestSum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) return target;
                else if (sum < target) {
                    if (target - sum < result) {
                        result = target - sum;
                        closestSum = sum;
                    }
                    left++;
                    while (left < right && nums[left] == nums[left-1]) left++;
                } else {
                    if (sum - target < result) {
                        result = sum - target;
                        closestSum = sum;
                    }
                    right--;
                    while (left < right && nums[right] == nums[right+1]) right--;
                }
            }
        }
        return closestSum;
    }
}