package Q0120_Triangle;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        List<Integer> minSum = triangle.get(height - 1);
        for (int layer = height - 2; layer >= 0; layer--) {
            for (int i = 0; i < layer + 1; i++) {
                minSum.set(i, Math.min(minSum.get(i), minSum.get(i + 1)) + triangle.get(layer).get(i));
            } 
        }
        return minSum.get(0);
    }
}