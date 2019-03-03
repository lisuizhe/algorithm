import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class IntegerArray {
    class Element implements Comparable<Element> {
        public int index;
        public int value;
        public Element(int index, int value) {
            this.index = index;
            this.value = value;
        }
        @Override
        public int compareTo(Element o) {
            if (value != o.value) {
                return value - o.value;
            } else {
                return o.index - index;
            }
        }
    }

    public int maxDistenceOfAdjacent(int[] A) {
        // write your code in Java SE 8
        if (A.length <= 1) {
            return -1;
        }
        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            elements.add(new Element(i, A[i]));
        }
        Collections.sort(elements);
        int max = 0;
        for (int i = 0; i < elements.size() - 1; i++) {
            int distence = elements.get(i+1).index - elements.get(i).index;
            if (distence > max) {
                max = distence;;
            }
        }
        return max;
    }

    public int maxSizeOfBiValuedSlice(int[] A) {
        // write your code in Java SE 8
        if (A.length == 0) {
            return 0;
        }
        int max = 1;
        for (int start = 0; start < A.length; start++) {
            Set<Integer> valuesOfSlice = new HashSet<>();
            valuesOfSlice.add(A[start]);
            for (int end = start + 1; end < A.length; end++) {
                valuesOfSlice.add(A[end]);
                if (valuesOfSlice.size() > 2) {
                    int sizeOfSlice = end - start;
                    if (sizeOfSlice > max) {
                        max = sizeOfSlice;
                    }  
                    break;
                } else if (end == (A.length - 1)) {
                    int sizeOfSlice = end - start + 1;
                    if (sizeOfSlice > max) {
                        max = sizeOfSlice;
                    }  
                    break;
                }
            }
        }
        return max;
    }

    // public static void main(String[] args) {
    //     IntegerArray test = new IntegerArray();
    //     {
    //         int[] A = {1,4,7,3,3,5};
    //         System.out.println("result1: " + test.maxDistenceOfAdjacent(A));
    //     } 
    //     {
    //         int[] A = {0,3,3,7,5,3,11,1};
    //         System.out.println("result1: " + test.maxDistenceOfAdjacent(A));
    //     }   
    //  }

    public static void main(String[] args) {
        IntegerArray test = new IntegerArray();
        {
            int[] A = {5,4,4,5,0,12};
            System.out.println("result2: " + test.maxSizeOfBiValuedSlice(A));
        } 
        {
            int[] A = {1};
            System.out.println("result2: " + test.maxSizeOfBiValuedSlice(A));
        } 
        {
            int[] A = {1,2};
            System.out.println("result2: " + test.maxSizeOfBiValuedSlice(A));
        } 
        {
            int[] A = {1,1};
            System.out.println("result2: " + test.maxSizeOfBiValuedSlice(A));
        } 
        {
            int[] A = {1,1,2,3};
            System.out.println("result2: " + test.maxSizeOfBiValuedSlice(A));
        } 
    }
}