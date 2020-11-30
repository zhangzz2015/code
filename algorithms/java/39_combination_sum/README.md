## backtracking
Because we can choose unlimited number of times, for each of the distinct candidate we can find the max number we can choose for that candidate and choose for different numbers at the level of that candidate.<br>
In the recursion tree:<br>
For each level, we can choose different numbers of the candidate.<br>
If there are n candidates, there are n levels, because we need to choose the number of each candidates at each level.<br>

		candidates = [2, 3, 6, 7] target = 7
		
				             []
			       /        \        \        \
			     []         [2]      [2,2]    [2,2,2]
			    / \  \      /  \        |    
			  [] [3] [3,3] [2] [2,3] [2,2,3]
			  ....

time: O((target/smallest candidate)^n)<br>
space: O(n)

## backtracking
For each level we want to choose from the all the candidates.<br>
when the target is summed up we can return.<br>
to avoid duplicates like [2,2,3], [2,3,2], [3,2,2], because we are trying to find the value combination instead of the index combination. We can perform an order trick.<br>
For each level we want to choose from the candidates for that candidate and candidates after that candidate. We will not rechoose the candidates before the current candidate we are choosing.<br>

	candidates = [2, 3, 6, 7]

						    []
				 /             \           \     \
				[2]            [3]         [6]    [7]
		     /     /   \    \        /   \    \
		 [2,2] [2,3] [2,6] [2,7]  [3,3] [3,6] [3,7] ....
		  ......

time: O(!n)<br>
space: O(n)
