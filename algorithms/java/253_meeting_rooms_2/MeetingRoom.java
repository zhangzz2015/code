class MeetingRoom {
	private class Point {
        int time;
        boolean isStart;
        public Point(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }
    static class MyComparator implements Comparator<Point> {
        @Override
        public int compare(Point p1, Point p2) {
            int res = Integer.compare(p1.time, p2.time);
            if (res == 0) {
                if (p1.isStart) {
                    return 1;
                } else {
                    return -1;
                }
            } else {
                return res;
            }
        }
    }
    public int minMeetingRooms(int[][] intervals) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            points.add(new Point(intervals[i][0], true));
            points.add(new Point(intervals[i][1], false));
        }
        Collections.sort(points, new MyComparator());
        int res = 0;
        int count = 0;
        for (int i = 0; i < points.size(); i++) {
            count = points.get(i).isStart ? count + 1 : count - 1;
            res = Math.max(res, count);
        }
        return res;
    }
}
