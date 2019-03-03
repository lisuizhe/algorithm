package Q0107_Word_Break;

import java.util.Set;

class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        boolean canBreakSubstring[] = new boolean[s.length() + 1];
        canBreakSubstring[0] = true;
        int maxLength = getMaxLength(dict);
        for (int end = 1; end <= s.length(); end++) {
            for (int start = end - 1; start >= 0 && (end - start) <= maxLength; start--) {
                if (canBreakSubstring[start] && dict.contains(s.substring(start, end))) {
                    canBreakSubstring[end] = true;
                    break;
                }
            }
        }
        return canBreakSubstring[s.length()];
    }

    private int getMaxLength(Set<String> dict) {
        int maxLength = 0;
        for (String str : dict) {
            maxLength = Math.max(maxLength, str.length());
        }
        return maxLength;
    }
}