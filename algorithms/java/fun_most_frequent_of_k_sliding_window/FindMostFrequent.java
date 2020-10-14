class FindMostFrequent {
	public List<Integer> findMostFrequent(int[] array, int k) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> freq = new HashMap<>();
		TreeSet<Integer> window = new TreeSet<>((a, b) -> Integer.compare(freq.get(a), freq.get(b)));
		for (int i = 0; i < array.length; i++) {
			int tmp = array[i];
			freq.put(tmp, freq.getOrDefault(tmp. 0) + 1);
			if (i >= k) {
				freq.put(array[i - k], freq(array[i - k]) - 1);
			}
			window.remove(tmp);
			window.add(tmp);
			if (i >= k - 1) {
				res.add(window.last());
			}
		}
		return res;
	}
}
