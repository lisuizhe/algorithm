package Q0139_Word_Break;

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean canBreakSubstring[] = new boolean[s.length() + 1];
        canBreakSubstring[0] = true;
        int maxLength = getMaxLength(wordDict);
        for (int end = 1; end <= s.length(); end++) {
            for (int start = end - 1; start >= 0 && (end - start) <= maxLength; start--) {
                if (canBreakSubstring[start] && wordDict.contains(s.substring(start, end))) {
                    canBreakSubstring[end] = true;
                    break;
                }
            }
        }
        return canBreakSubstring[s.length()];
    }

    private int getMaxLength(List<String> dict) {
        int maxLength = 0;
        for (String str : dict) {
            maxLength = Math.max(maxLength, str.length());
        }
        return maxLength;
    }
}