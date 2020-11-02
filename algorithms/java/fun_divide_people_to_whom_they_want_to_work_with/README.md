# You have a group of people, some people don’t like to work with other people. Divide these people into two groups in which no people working in the same group don’t like each other.<br>A don’t like to work with B, then B don’t like to work with A either.

## bfs
The relations can be represented as a graph.<br>
- vertex: people that dislike someone
- edge: between the people do not like each other

We can use bfs to traverse the graph and each level would be in the different group with its neighbor levels. If we cannot divide into those two groups then we just return two empty lists.

time: O(E + V)<br>
space: O(V)
