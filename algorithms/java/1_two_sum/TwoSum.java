import java.util.Map;

class TwoSum {
    public int[] twoSum(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int pair = target - array[i];
            if (map.containsKey(pair)) {
                return new int[] {map.get(pair), i};
            } else {
                map.put(array[i], i);
            }
        }
        return new int[2];
    }
}