import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<String>();
        Map<Character, List<Character>> map = new HashMap<Character, List<Character>>();
        int offset = 0;
        for (int i = 2; i <= 9; i++) {
            List<Character> list = new ArrayList<Character>();
            list.add((char)('a' + i * 3 - 6 + offset));
            list.add((char)('a' + i * 3 - 5 + offset));
            list.add((char)('a' + i * 3 - 4 + offset));
            if (i == 7 || i == 9) {
                list.add((char)('a' + i * 3 - 3 + offset));
                offset++;
            }
            map.put((char)('0' + i), list);
        }
        List<String> lastList = new ArrayList<String>();
        List<String> result = null;
        for (int i = 0; i < digits.length(); i++) {
            result = new ArrayList<String>();
            for (Character c : map.get(digits.charAt(i))) {
                if (i == 0) {
                    result.add(c.toString());
                } else {
                    for (String s : lastList) {
                        result.add(s + c.toString());
                    }   
                }
            }
            lastList = result;
        }
        return result;
    }
}