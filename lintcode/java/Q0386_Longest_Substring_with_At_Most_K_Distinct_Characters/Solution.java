package Q0386_Longest_Substring_with_At_Most_K_Distinct_Characters;

import java.util.HashMap;

class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        int end = 0;
        int count = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }
            else {
                map.put(c, map.get(c) + 1);
            }
            if (map.get(c) == 1) {
                count++;
            }
            end++;
            while (count > k) {
                char ch = s.charAt(start);
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
                start++;
            }
            max = Math.max(max, end - start);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstringKDistinct("eceba", 3) == 4);
        System.out.println(s.lengthOfLongestSubstringKDistinct("eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh", 16) == 27);
    }
}