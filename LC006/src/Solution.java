public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;  // VERY TRICKY...
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            int idx = r;
            boolean neg = true;
            while (idx < s.length()) {
                sb.append(s.charAt(idx));
                if (r == 0 || r == numRows - 1) idx += 2 * (numRows - 1);
                else {
                    if (neg) {
                        idx += 2 * (numRows - 1);
                        idx = idx - 2 * r;
                    } else {
                        idx = idx + 2 * r;
                    }
                    neg = !neg;
                }
            }
        }
        return sb.toString();
    }
}