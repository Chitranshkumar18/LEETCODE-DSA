//import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();

        // Min heap: {value, listIndex, elementIndex}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int currentMax = Integer.MIN_VALUE;

        // Initialize heap
        for (int i = 0; i < k; i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new int[]{val, i, 0});
            currentMax = Math.max(currentMax, val);
        }

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        while (true) {
            int[] curr = minHeap.poll();
            int minVal = curr[0];
            int listIdx = curr[1];
            int elemIdx = curr[2];

            // Update best range
            if (currentMax - minVal < rangeEnd - rangeStart) {
                rangeStart = minVal;
                rangeEnd = currentMax;
            }

            // Move to next element in same list
            if (elemIdx + 1 == nums.get(listIdx).size()) {
                break;
            }

            int nextVal = nums.get(listIdx).get(elemIdx + 1);
            minHeap.offer(new int[]{nextVal, listIdx, elemIdx + 1});
            currentMax = Math.max(currentMax, nextVal);
        }

        return new int[]{rangeStart, rangeEnd};
    }
}