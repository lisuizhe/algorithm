package Q0453_Minimum_Moves_to_Equal_Array_Elements;

class Solution {
    public int minMoves(int[] nums) {
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