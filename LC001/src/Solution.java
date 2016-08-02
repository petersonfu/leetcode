import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null && idx != i) {
                return new int[]{i, idx};
            }
        }
        return null;
    }
}