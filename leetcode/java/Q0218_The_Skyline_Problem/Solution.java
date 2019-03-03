package Q0218_The_Skyline_Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

class Solution {
    class BuildingEdge implements Comparable<BuildingEdge> {
        public int x;
        public int height;
        public boolean isLeft;
        public BuildingEdge(int x, int height, boolean isLeft) {
            this.x = x;
            this.height = height;
            this.isLeft = isLeft;
        }

        @Override
        public int compareTo(BuildingEdge o) {
            if (x != o.x) {
                return x - o.x;
            } else {
                return isLeft ? (o.isLeft ? (o.height - height) : -1) : (o.isLeft ? 1 : (height -o.height));
            }
        }
        
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> results = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return results;
        }

        List<BuildingEdge> edges = new ArrayList<>();
        for (int[] building: buildings) {
            edges.add(new BuildingEdge(building[0], building[2], true));
            edges.add(new BuildingEdge(building[1], building[2], false));
        }
        Collections.sort(edges);

        TreeMap<Integer, Integer> heightToCount = new TreeMap<>((h1, h2) -> (h2 - h1));
        Integer prevHeight = null;
        for (BuildingEdge edge: edges) {
            if (edge.isLeft) {
                heightToCount.put(edge.height, heightToCount.getOrDefault(edge.height, 0)+1); 
                Integer currentHeight = heightToCount.firstKey();
                if (!currentHeight.equals(prevHeight)) {
                    results.add(new int[]{ edge.x, currentHeight });
                    prevHeight = currentHeight;
                }   
            } else {
                int count = heightToCount.get(edge.height);
                if (count > 1) {
                    heightToCount.put(edge.height, count-1);
                } else {
                    heightToCount.remove(edge.height);
                }
                if (heightToCount.isEmpty()) {
                    if (prevHeight != 0) {
                        results.add(new int[]{ edge.x, 0 });
                        prevHeight = 0;
                    }
                } else {
                    Integer currentHeight = heightToCount.firstKey();
                    if (!currentHeight.equals(prevHeight)) {
                        results.add(new int[]{ edge.x, currentHeight });
                        prevHeight = currentHeight;
                    }   
                }
            } 
        }
        return results;
    }
}