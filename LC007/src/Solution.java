public class Solution {
    public int reverse(int x) {
        boolean neg = (x < 0);
        if (neg) x = -x;
        int result = 0;
        while (x > 0) {
            int digit = x % 10;
            if (result > (Integer.MAX_VALUE - digit) / 10.0) return 0;
            result = result * 10 + digit;
            x = x / 10;
        }
        if (neg) return -result;
        else return result;
    }
}