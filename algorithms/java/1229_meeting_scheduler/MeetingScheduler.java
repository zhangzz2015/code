class MeetingScheduler {
	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(slots1, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(slots2, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0;
        int j = 0;
        while (i < slots1.length && j < slots2.length) {
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);
            if (start + duration <= end) {
                res.add(start);
                res.add(start + duration);
                return res;
            }
            if (slots1[i][1] > slots2[j][1]) {
                j++;
            } else {
                i++;
            }
        }
        return res;
    }
}
