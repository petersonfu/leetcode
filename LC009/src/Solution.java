public class Solution {
    public boolean isPalindrome(int x) {
        int div = 1;
        // 乘以10会越界
        while (div < x / 10.0) {
            div *= 10;
        }
        int y = x;
        while (y > 0 && y % 10 == y / div) {
            y = (y % div) / 10;
            div = div / 100;
        }
        return (y==0);
    }
}