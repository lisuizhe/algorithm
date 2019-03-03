package Q0378_Kth_Smallest_Element_in_a_Sorted_Matrix;

import java.util.PriorityQueue;

class Solution {
    private class Element implements Comparable<Element> {
        public int row;
        public int column;
        public int value;

        public Element(int row, int column, int value) {
            this.row = row;
            this.column = column;
            this.value = value;
        }

        @Override
        public int compareTo(Element o) {
            return this.value - o.value;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Element> heap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            heap.offer(new Element(0, i, matrix[0][i]));
        }
        for (int i = 1; i < k; i++) {
            Element e = heap.poll();
            if (e.row == n - 1) {
                continue;
            }
            heap.offer(new Element(e.row+1, e.column, matrix[e.row+1][e.column]));
        }
        return heap.poll().value;
    }
}