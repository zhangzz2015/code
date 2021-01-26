## indegree outdegree map
For the town judge, he do not trust anyone, and all other people trust him.<br>
We can model this problem as a directed graph problem.<br>
If A trust B, then that means there is an edge from A to B.<br>
For a judge, it is a person that the indegree is N - 1, and the outdegree is 0.<br>
We can traverse the edge list to build the indegree and outdegree map.<br>
Then we can chekc each person to see if that person satisfies the rule of being and judge.

time: O(E + V) -> O(edges + N)<br>
space: O(N)
