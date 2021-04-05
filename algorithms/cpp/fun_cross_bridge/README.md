# There are some people need to cross the bridge, each of them needs some time to cross the bridge. The bridge can only allow less or equal to 2 people to across. Because it is dark, every time they across the bridge they need to use the only lighting. If two people are acrossing the bridge the longer time is their total time to across the bridge. Return the smallest time for all of them to across the bridge.

## dp

	1. dp[i] means the minimum time for the people before index i to across the bridge.
	2. induction rule:
	   - case 1: if the people smaller or equal to index i - 1 have cross the river. And there is only one left, and the light is on the other side. Thus we need the one with the smallest time to carry to light back and go cross the brigde together. dp[i] = dp[i - 1] + time[0] + time[i]
	   - case2: if the people smaller or equal to index i - 2 have cross the river. And there is only two people left, and the light is on the other side. Thus we need the smallest one carry the light come back, and let i - 1 and i go back, and let the second smallest comback and take the smallest one back. dp[i] = dp[i - 1] + time[0] + time[i] + 2*time[1]
	3. base case:
	   i <= 1: time[i]
	4. filling order:
	   left to right
	5. result:
		dp[n - 1]

time: O(n)<br>
space: O(n)
