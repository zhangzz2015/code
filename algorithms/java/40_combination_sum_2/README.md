In this problem we have duplicates in the candidates, and we are finding the value combination instead of the index combination.
## backtracking
we choose to pick or not pick the element at each index. To avoid duplicate situation when we have duplicate element we will have [1, 2] and [1, 2] which use the different 1s as the answer. That means if we don't choose to pick an element we will not choose the same value again. To acheive this, we want to group the elements together and when we do not pick this element we want to skip all the same value elements. To group them together we can sort the candidates.<br>

			sorted candidates [1, 1, 2, 2, 5] target = 5

			                     ""
			                   /    \
			                  1     ""
			                 / \       |skip
			                11   1     |
			               / \  / \   /  \
			              112  11 12 1  2  ""
			              ...

time: O(2^n)<br>
space: O(n)

## backtracking
we choose all the possible candidate and add to the sum for each level. To avoid the result to appear [1, 2], [2, 1], we can perform an order trick, for each level we want to choose from the candidates from that candidate and candidates after that candidate. We will not rechoose the candidates before the current candidate. Thus, we need to sort the array first to avoid the same element appears before and after the current candidate like the case of [1, 2, 1]. To avoid duplicates result from the duplicate elements we want to only add one kind of the element in the same level. We can use a hashset to deduplicate or we can use sort and skip the same group trick like the first method.<br>

			sorted candidates [1, 1, 2, 2, 5] target = 5

			                          ""
			                   /         \    \ 
			                  1           2    5
			                 / \   \     / \   / \
			                11  12 15   22 25 52 55
			                ....

time: O(nlogn + !n)<br>
space: O(n)
