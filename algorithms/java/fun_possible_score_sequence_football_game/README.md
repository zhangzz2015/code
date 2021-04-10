# For a football game, there are 4 ways to score {6, 3, 2, 1}<br>The rules are follow:<br>1. A team can score by touchdown, and get 6 points.<br>2. A team can score by firld goal, and get 3 points.<br>3. For extra point(after touchdown only): if the previous way of scoring is by touchdown.<br>	a.touchdown again, and get 2 points.<br>	b. long-range shooting, then score 1 point.

## backtracking
For each level, we can choose for each of the ways to score. But for geting 2 points and 1 point, we need to check whether the score before is 6.<br>
For base case, the the scores add up to the given target then we can add that sequence to the answer. If scores add up more than the target, that is not valid, and will be pruned.

	                10,[]
	       /                     \
	      4,[6]                   7,[3]
	   /         \      \
	 1,[6,3]  2,[6,2]  3,[6,1]
	 ...

time: O(4^n) - n is the number of times of any kind of score<br>
space: O(n)
