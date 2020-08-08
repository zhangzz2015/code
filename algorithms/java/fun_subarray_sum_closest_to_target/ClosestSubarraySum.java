import java.util.*;
public class ClosestSubarraySum {
    public int findSubArrayClosestToK(int[] array, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, -1);
        int sum = 0;
        int diff = Integer.MAX_VALUE;
        int res = 0;
        int start = -1;
        int end = -1;
        for (int i = 0; i < array.length; ++i) {
            sum += array[i];
            Integer floor = map.floorKey(sum - k);
            if (floor != null) {
                if (diff > sum - k - floor) {
                    diff = sum - k - floor;
                    start = map.get(floor) + 1;
                    end = i;
                }
            }
            Integer ceiling = map.ceilingKey(sum - k);
            if (ceiling != null) {
                if (diff > ceiling - (sum - k)) {
                    diff = ceiling - (sum - k);
                    start = map.get(ceiling) + 1;
                    end = i;
                }
            }
            map.put(sum, i);
        }
        System.out.println(start + " " + end);
        return diff;
    }

    public static void main(String[] args) {
        ClosestSubarraySum solution = new ClosestSubarraySum();
        int[] input = {0, -2, 5, 4};
        int target = 2; // expect: start: 1 end: 2, diff: 1
        System.out.println(solution.findSubArrayClosestToK(input, target));
    }
}