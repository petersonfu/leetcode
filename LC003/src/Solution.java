import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer p = map.get(c);
            if (p != null && p >= start) {
                start = p + 1;
            }
            map.put(c, i);
            max = Math.max(i - start + 1, max);
        }
        return max;
    }
}