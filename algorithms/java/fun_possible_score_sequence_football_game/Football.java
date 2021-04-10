class Football {
	public List<List<Integer>> getAllScoreSequence(int score) {
		List<List<Integer>> res = new ArrayList<>();
		int[] choices = new int[]6, 3, 2, 1};
		getSeq(res, new ArrayList<>(), choices, score);
		return res;
	}
	private void getSeq(List<List<Integer>> res, List<Integer> cur, int[] choices, int score) {
		if (score < 0) {
			return;
		}
		if (score == 0) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int i = 0; i < 3; i++) {
			int choice = choices[i];
			if (choice == 2 || choice == 1) {
				if (!cur.isEmpty() && cur.get(cur.size() - 1)) {
					cur.add(choice);
				}
			} else {
				cur.add(choice);
			}
			getSeq(res, cur, choices, score - choice);
			cur.remove(cur.size() - 1);
		}
	}
}
