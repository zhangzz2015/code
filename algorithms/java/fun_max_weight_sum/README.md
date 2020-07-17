 ## Element has an ID(unique) and weight. find the maximum weight sum where there is not any pair with diff(ID) <= k<br><1,1> <4,1> <2,8> ,  k = 2, return 8
So this means that we want to find the maximum weight sum in all subsets that all elements in the subset that have diff(ID) > k.<br>
If the input is sorted by the ID we can easily exclude which are not the ones that we can add to a subset and find the next element that can add into a subset<br>
We can assume that the given element is already sorted by the ID. otherwise we will just do a preprocessing to sort the input by the ID.<br>

So we can use DP to solve this problem.<br>
definition: dp[i] means the largest sum weight subsequence from index 0 to index i, ending at index i (including index i) where the adjacent index must have a difference larger than k.

    induction rule: 
	    dp[i] = max {
		        dp[j] + input[i].weight    if 0 <= j < i && input[i].id - input[j].id > k,
		        input[i]
                }
    base case: dp[0] = input[0].weight

time: O(n^2)<br>
space: O(n)

## Follow up: find the maximum weight sum where there is not any pair with diff(ID) > k.
This means that the largest ID and the smallest ID in the subset must be smaller or equal than k.
So after sorting the input by IDs we can easily deal with the diff(ID)<br>
Thus we can use a sliding window to loop through the array and find the max<br>
time: O(n)<br>
space: O(1)