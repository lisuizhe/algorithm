package Q0215_Kth_Largest_Element_in_an_Array;

import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return Integer.MAX_VALUE;
        }

        shuffle(nums);
        return findKthLargestElement(nums, k, 0, nums.length - 1);
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