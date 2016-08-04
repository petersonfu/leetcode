public class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) {
            return s.length() == 0;
        }
        char pp = p.charAt(0);
        boolean oneCharMatch = s.length() > 0 && (pp == '.' || pp == s.charAt(0));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            if (oneCharMatch) {
                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
            } else {
                return isMatch(s, p.substring(2));
            }
        } else {
            return oneCharMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}