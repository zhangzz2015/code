## greedy
We can maintain a candidate that is the celebrity candidate of the people that we have traversed.<br>
If the current candidate know person i, that means the current candidate is not the celebrity, and i is the possible candidate.<br>
Because there might not exist a celebrity in this relation, we need to go through all the people again and check if the candidate do not know any one and every other one knows this candidate.

time: O(N)<br>
space: O(1)
