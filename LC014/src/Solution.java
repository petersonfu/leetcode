public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int pos = 0;
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            minLen = Math.min(minLen, s.length());
        }
        while (pos < minLen) {
            char c = strs[0].charAt(pos);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(pos) != c) {
                    return strs[0].substring(0, pos);
                }
            }
            pos++;
        }
        return strs[0].substring(0, pos);
    }
}