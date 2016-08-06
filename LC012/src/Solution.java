public class Solution {
    public String intToRoman(int num) {
       StringBuilder sb = new StringBuilder();
       
        // 1000 - M
        for (int i = 0; i < num / 1000; i++) {
            sb.append('M');
        }
        
        // 500 - D, 100 - C
        int d = (num % 1000) / 100;
        if (d == 9) {
            sb.append("CM");
        } else if (d == 4) {
            sb.append("CD");
        } else {
            if (d >= 5) {
                sb.append('D');
                d -= 5;
            }
            for (int i = 0; i < d; i++) {
                sb.append('C');
            }
        }

        // 50 - L, 10 - X
        d = (num % 100) / 10;
        if (d == 9) {
            sb.append("XC");
        } else if (d == 4) {
            sb.append("XL");
        } else {
            if (d >= 5) {
                sb.append('L');
                d -= 5;
            }
            for (int i = 0; i < d; i++) {
                sb.append('X');
            }
        }

        // 5 - V, 1 - I
        d = num % 10;
        if (d == 9) {
            sb.append("IX");
        } else if (d == 4) {
            sb.append("IV");
        } else {
            if (d >= 5) {
                sb.append('V');
                d -= 5;
            }
            for (int i = 0; i < d; i++) {
                sb.append('I');
            }
        }
        
        
        return sb.toString();
    }
}