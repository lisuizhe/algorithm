package Q0582_Word_Break_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        return recursiveWordBreak(s, wordDict, new HashMap<>());
    }

    private List<String> recursiveWordBreak(String s, Set<String> wordDict, 
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