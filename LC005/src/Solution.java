public class Solution {
    private String expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left+1, right);
    }
    public String longestPalindrome(String s) {
        if (s == null) return null;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = expand(s, i, i);
            String s2 = expand(s, i, i+1);
            if (s1.length() > result.length()) result = s1;
            if (s2.length() > result.length()) result = s2;
        }
        return result;
    }
}