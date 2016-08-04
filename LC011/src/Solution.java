public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0;
        while (left <  right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
}

/* even quicker

public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, max = 0, lastHeight = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > lastHeight) {
                    max = Math.max(max, (right - left) * height[left]);
                    lastHeight = height[left];
                }
                left++;
            }
            else {
                if (height[right] > lastHeight) {
                    max = Math.max(max, (right - left) * height[right]);
                    lastHeight = height[right];
                }
                right--;
            }
        }
        return max;
    }
}

 */