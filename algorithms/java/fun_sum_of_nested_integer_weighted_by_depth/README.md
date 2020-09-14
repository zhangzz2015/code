# Given a nested list of integers, return the sum of all integers in the list weighted by their depth.<br>Each element is either an integer, or a list -- whose elements may also be integers or other lists<br>e.g.[[1,1],2,[1,1]] This is four 1 at depth 2, one 2 at depth 1.
## solution
We can traverse the tree and add each of the value weighted by the level. Thus, we also need to pass down the information of the level.<br>
### 1. We can define the sum as a global variable<br>sum: before traversing the current subtree prefixsum<br>return: after traversing the current prefixsum

### 2. We can also define the sum as a local variable<br>return: sum of the current subtree -> pure recursion

time: O(n)<br>
space: O(height)
