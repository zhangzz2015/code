class BrowserHistory {
	private String[] histories;
	private final int memoNumber;
	int cur;
	int start;
	int end;
	BrowserHistory(String homepage, int x) {
		histories = new String[x + 1];
		memoNumber = x + 1;
		cur = 0;
		start = 0;
		end = 0;
		histories[cur] = homepage;
	}
	public void visiting(String url) {
		cur = (cur + 1) % memoNumber;
		if (cur == start) {
			start = (start+ 1) % memoNumber;
		}
		histories[cur] = url;
		end = cur;
	}
	public String back(int steps) {
		int curBack = cur >= start ? cur - start : memoNumber - (start - cur + 1);
		if (steps >= curBack) {
			cur = start;
		} else {
			cur = (cur - steps) < 0 ? cur - steps + memoNumber : cur - steps;
		}
		return histories[cur];
	}
	public String forward(int steps) {
		int curForward = end >= cur ? end - cur : memoNumber - (cur - end + 1);
		if (steps >= curForward) {
			cur = end;
		} else {
			cur = (cur + steps) % memoNumber;
		}
		return histories[cur];
	}
}
