package Q0001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numToIndexOfComplement = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndexOfComplement.containsKey(complement)){
                return new int[] { i, numToIndexOfComplement.get(complement)};
            }
            numToIndexOfComplement.put(nums[i], i);
        }
        
        throw new IllegalArgumentException("No solution!");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testNums = {1,2,3,4,5};
        int target = 3;
        int[] result = solution.twoSum(testNums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}