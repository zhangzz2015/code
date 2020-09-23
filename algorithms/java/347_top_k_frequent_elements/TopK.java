class TopK {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k <= 0) return res;
        Map<Integer, Integer> freqMap = buildMap(nums);
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(new MyComparator());
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll().getKey());
        }
        return res;
    }

    static class MyComparator implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
            return Integer.compare(e1.getValue(), e2.getValue());
        }
    }

    private Map<Integer, Integer> buildMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map;
    }
}