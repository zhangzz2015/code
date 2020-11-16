class FreeTime {
	static class Interval {
		int start;
		int end;
		Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public List<Interval> getFreeTime(List<List<Interval>> workingTime) {
		List<Interval> res = getOnePersonFreeTime(workingTime.get(0));
		for (List<Interval> list : workingTime) {
			res = merge(getOnePersonFreeTime(list), res);
		}
		return res;
	}

	private List<Interval> getOnePersonFreeTime(List<Interval> intervals) {
		List<Interval> res = new ArrayList<>();
		int curTime = 0;
		for (Interval interval : intervals) {
			if (curTime < interval.start) {
				res.add(new Interval(curTime, interval.start));
			}
			if (interval.end >= 24) {
				break;
			}
			curTime = interval.end;
		}
		if (curTime < 24) {
			res.add(new Interval(curTime, 24);
		}
		return res;
	}

	private List<Interval> merge(List<Interval> l1, List<Interval> l2) {
		List<Interval> intersections = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < l1.size() && j < l2.size()) {
			int start = Math.max(l1.get(i).start, l2.get(j).start);
			int end = Math.min(l1.get(i).end, l2.get(j).end);
			if (start <= end) {
				intersections.add(new Interval(start, end));
			}
			if (l1.get(i).end > l2.get(j).end) {
				j++;
			} else {
				i++;
			}
		}
		return intersections;
	}
} 
