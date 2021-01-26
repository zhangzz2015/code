/* The known API is defined in the parent class Relation.
      boolean knows(int a, int b); */

class FindCelebrity extends Relation {
	public int findCelebrity(int n) {
		int candidate = 0;
		for (int i = 1; i < n; i++) {
			if (knows(candidate, i)) {
				candidate = i;
			}
		}
		for (int i = 0; i < n; i++) {
			if (i != candidate) {
				if (knows(candidate, i) || !knows(i, candidate)) {
					return -1;
				}
			}
		}
		return candidate;
	}
}
