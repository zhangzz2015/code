# Traverse all the places on the map once. Starting from one place and return to the starting.<br>[a, b] a -> b<br>[b, c] b -> c<br>[c, a] c -> a<br>a -> b -> c -> a
input: a list of roads from city to city<br>
output: return the first path

This is a graph problem:<br>
vertex: city<br>
edge: a -> b
## backtracking
The path starts at a city -> go through all the cities -> ends at first where we start.<br>
We want to traverse all the paths in the map.<br>
if it has a cycle containing all cities, then starting from any node is ok.<br>
If using an arbitrary node as start cannot get the result then that means we do not have the answer in the graph, then we return an empty list.

			    []
			   /  \prune
			  a
			/ \ \prune
		       ab ac
		      / \
		    abc
		each level: dicide which current city add to the path
		branches: go to the different valid neighbors

base case: if we find the answer

time: O((# of neighbors)^n) - n is the number of cities<br>
space: O(n)
