import java.util.*;
class WorkSchedule {
	public List<List<Integer>> planSchedule(int limit, int totalWorkDay) {
		List<List<Integer>> schedules = new ArrayList<>();
		planSchedule(schedules, new ArrayList<>(), 0, -1, limit, totalWorkDay);
		return schedules;
	}
	private void planSchedule(List<List<Integer>> schedules, List<Integer> plan, int index, int lastBreak, int limit, int totalWorkDay) {
		if (totalWorkDay == 0) {
			System.out.println(plan.toString());
			schedules.add(new ArrayList<>(plan));
			return;
		}
		if (index > limit) {
			return;
		}
		// break day
		plan.add(0);
		planSchedule(schedules, plan, index + 1, index, limit, totalWorkDay);
		plan.remove(plan.size() - 1);

		// work day
		if (index - lastBreak <= 5) {
			plan.add(1);
			planSchedule(schedules, plan, index + 1, lastBreak, limit, totalWorkDay - 1);
			plan.remove(plan.size() - 1);
		}
	}
	public static void main(String[] args) {
		WorkSchedule plan = new WorkSchedule();
		plan.planSchedule(30,20); 
	}
}
