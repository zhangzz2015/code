# Given a list of vertices return the topological order of the vertices.
Assuming this is an directed graph.<br>
If there is cycle in the graph then throw an exception or return an empty list.

## dfs
A task can be executed only when all its dependencies are cleared.<br>
For a graph as edge direction with n1 -> n2 meaning that n1 depends on n2 (after n2 complete, then we can run n1)<br>
We mark a node visited only when all vertices reachable from that node are marked visited.<br>
And we add VISITING state to the node, we can detect whether there is circle or not at the same time.

- pros:
	- possibly reduce # of traversals, no need to build an indegree map
	- implementation simple -> less prone to errors
- cons:
	- offline
	- logic understanding complex

time: O(E + V)<br>
space: O(V)

## bfs
step1: build the indegree map<br>
step2: get the topological order.
	- every time choose those nodes that indegrees are 0 as the next candicates

- pros:
	- easy to understand
	- using a structure to store the next candidates, thus at any time we know all the candidate tasks ready to execute.
	- online topological order
	- with diffrent choice options in the data structure to store the candidates ready to execute, we can satisfy more requirements.
- cons:
	- 2 rounds of traversal, to get the indegrees first
	- implementation complex

time: O(E + V)<br>
space: O(V)
