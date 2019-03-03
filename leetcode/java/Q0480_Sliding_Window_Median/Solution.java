package Q0480_Sliding_Window_Median;

import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] medians = new double[nums.length - k + 1];
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return medians;
        }
        if (k == 1) {
            for (int i = 0; i < nums.length; i++) {
                medians[i] = nums[i];
            }
            return medians;
        }

        PriorityQueue<Integer> large = new PriorityQueue<>();
        PriorityQueue<Integer> small = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 == o2 ? 0 : (o1 < o2 ? 1 : -1);
            }
        });
        for (int i = 0; i < k; i++) {
            if (large.isEmpty()) {
                large.offer(nums[i]);
            } else if (small.isEmpty()) {
                if (large.peek() < nums[i]) {
                    small.offer(large.poll());
                    large.offer(nums[i]);
                } else {
                    small.offer(nums[i]);
                }
            } else {
                if (large.size() == small.size()) {
                    large.offer(nums[i]);
                } else {
                    small.offer(nums[i]);
                }
                if (large.peek() < small.peek()) {
                    int tmp = large.poll();
                    large.offer(small.poll());
                    small.offer(tmp);
                }
            }
        }
        if (large.size() == small.size()) {
            medians[0] = ((double)large.peek() + (double)small.peek()) / 2;
        } else {
            medians[0] = large.peek();
        }
        for (int i = 1; i < nums.length - k + 1; i++) {
            if (nums[i-1] >= large.peek()) {
                large.remove(nums[i-1]);
                large.offer(nums[i+k-1]);
            } else {
                small.remove(nums[i-1]);
                small.offer(nums[i+k-1]);
            }
            if (large.peek() < small.peek()) {
                int tmp = large.poll();
                large.offer(small.poll());
                small.offer(tmp);
            }
            if (large.size() == small.size()) {
                medians[i] = ((double)large.peek() + (double)small.peek()) / 2;
            } else {
                medians[i] = large.peek();
            }
        }
        return medians;
    }
}