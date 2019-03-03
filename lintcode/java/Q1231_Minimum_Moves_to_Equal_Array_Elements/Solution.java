package Q1231_Minimum_Moves_to_Equal_Array_Elements;

class Solution {
    /**
     * @param nums: an array
     * @return: the minimum number of moves required to make all array elements equal
     */
    public int minMoves(int[] nums) {
        // Write your code here
        // sum + move * (n-1) = n * (min + move) -> move = sum - n * min
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            sum += num;
            min = Math.min(min, num);
        }
        
        return sum - nums.length * min;
    }
}