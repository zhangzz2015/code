class ExecuteTasks {
	public int execute(List<Task> tasks, int k) {
		Map<Task, Integer> taskTime = new HashMap<>();
		Queue<Task> window = new ArrayDeque<>();
		int timeCount = 0;
		for (Task t : tasks) {
			Integer lastTime = taskTime.get(t);
			if (lastTime == null) {
				timeCount++;
			} else {
				timeCount = lastTime + k + 1;
			}
			// timeCount now is the time after executing the last task
			while (!window.isEmpty() && timeCount - taskTime.get(window.peek()) >= k) {
				taskTime.remove(window.poll());
			}
			window.offer(t);
			taskTime.put(t, timeCount);
		}
		return timeCount;
	}
}
