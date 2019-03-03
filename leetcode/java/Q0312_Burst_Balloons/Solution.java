package Q0312_Burst_Balloons;

class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] allNums = new int[nums.length+2];
        allNums[0] = allNums[nums.length+1] = 1;
        for (int i = 1; i <= nums.length; i++) {
            allNums[i] = nums[i-1];
        }

        int[][] memo = new int[nums.length+2][nums.length+2];
        return burst(allNums, 0, nums.length+1, memo);
    }

    private int burst(int[] allNums, int left, int right, int[][] memo) {
        if (left + 1 >= right) {
            return 0;
        }
        if (memo[left][right] > 0) {
            return memo[left][right];
        }
        int coins = 0;
        for (int i = left + 1; i < right; i++) {
            int temp = allNums[left] * allNums[i] * allNums[right] 
                        + burst(allNums, left, i, memo)
                        + burst(allNums, i, right, memo);
            if (temp > coins) {
                coins = temp;
            }
        }
        memo[left][right] = coins;
        return coins;
    }
}