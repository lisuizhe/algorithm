package Q0124_Longest_Consecutive_Sequence;

import java.util.HashSet;

class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        HashSet<Integer> set = new HashSet<>();
        for (int i : num) {
            set.add(i);
        }

        int maxLength = 0;
        for (int i: set) {
            if (!set.contains(i - 1)) {
                int currentNum = i;
                int currentLength = 1;
                while (set.contains(currentNum + 1)) {
                    currentLength++;
                    currentNum++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}