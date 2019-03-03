package Q0140_Word_Break_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return recursiveWordBreak(s, wordDict, new HashMap<>());
    }

    private List<String> recursiveWordBreak(String s, List<String> wordDict, 
        Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (s.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        for (String word : wordDict) {
            if (word.isEmpty() || !s.startsWith(word)) {
                continue;
            }
            if (word.length() == s.length()) {
                result.add(word);
            }
            List<String> resultOfRest = recursiveWordBreak(
                s.substring(word.length()), wordDict, memo);
            for (String item : resultOfRest) {
                result.add(word + " " + item);
            }
            memo.put(s, result);
        }
        return result;
    }
}