package Q0387_First_Unique_Character_in_a_String;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 0) {
            return -1;
        }
        Map<Character, Boolean> unique = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (unique.containsKey(c)) {
                unique.put(c, false);
            } else {
                unique.put(c, true);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (unique.get(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}