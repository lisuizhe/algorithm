package Q0005_Kth_Largest_Element;

import java.util.Random;

class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        if (nums == null || nums.length < n || n <= 0) {
            return Integer.MAX_VALUE;
        }

        shuffle(nums);
        return findKthLargestElement(nums, n, 0, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        for (int i = 1; i < nums.length; i++) {
            swap(nums, i, random.nextInt(i + 1));
        }
    }

    private int findKthLargestElement(int[] nums, int k, int start, int end) {
        int pivot = nums[end];
        int left = start;
        for (int i = start; i < end; i++) {
            if (nums[i] >= pivot) {
                swap(nums, i, left++);
            }
        }
        swap(nums, left, end);
        if (k - 1 == left) {
            return nums[k - 1];
        } else if (k - 1 > left) {
            return findKthLargestElement(nums, k, left + 1, end);
        } else {
            return findKthLargestElement(nums, k, start, left - 1);
        }
    }
}