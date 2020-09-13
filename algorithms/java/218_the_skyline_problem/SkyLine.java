public class SkyLine {
	
	public List<List<Integer>> getSkyline(int[][] buildings) {
		List<List<Integer>> res = new ArrayList<>();
		if (buildings == null || buildings.length == 0) return res;
		PriorityQueue<Building> maxHeap = new PriorityQueue<>();
		List<Point> points = new ArrayList<>();
		for (int[] building : buildings) {
			Building cur = new Building(building[0], building[1], building[2]);
			points.add(new Point(cur.start, 0, cur));
			points.add(new Point(cur.end, 1, cur));
		}
		Collections.sort(points);
		int prevHeight = 0;
		for (Point p : points) {
			if (p.state == 0) {
				maxHeap.offer(p.building);
			} else {
				while (!maxHeap.isEmpty() && maxHeap.peek().end <= p.position) {
					maxHeap.poll();
				}
			}
			int curHeight = maxHeap.isEmpty() ? 0 : maxHeap.peek().height;
			if (curHeight != prevHeight) {
				res.add(new ArrayList<>(Arrays.asList(p.position, curHeight)));
			}
			prevHeight = curHeight;
		}
		return res;
	}

	static class Point implements Comparable<Point> {
		int position;
		int state; // 0: start  1: end
		Building building;
		Point(int position, int state, Building building) {
			this.position = position;
			this.state = state;
			this.building = building;
		}
		@Override
		public int compareTo(Point other) {
			int res = Integer.compare(this.position, other.position);
			if (res == 0) {
				int stateCompare = Integer.compare(this.state, other.state);
				if (stateCompare == 0) {
					return Integer.compare(other.building.height, this.building.height);
				}
				return stateCompare;
			}
			return res;
		}
	}

	static class Building implements Comparable<Building> {
		int start;
		int end;
		int height;
		Building(int start, int end, int height) {
			this.start = start;
			this.end = end;
			this.height = height;
		}
		@Override
		public int compareTo(Building other) {
			int res = Integer.compare(other.height, this.height);
			if (res == 0) {
				int startCompare = Integer.compare(this.start, other.start);
				if (startCompare == 0) {
					return Integer.compare(this.end, other.end);
				}
				return startCompare;
			}
			return res;
		}
	}
}
