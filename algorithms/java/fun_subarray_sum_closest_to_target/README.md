## Given an array of integers (positive and non positive), find the subarray sum closest to target.
To calculate the subarray sum we can use prefixsum to calculate.<br>
For each index j, we want to find the prefixsum[i] closest to prefixsum[j] - target. Thus we can use a treeMap.<br>
time: O(nlogn)<br>
space: O(n)