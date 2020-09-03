## merge sort
When we are doing the merge step of merge sort, if an element from the left part is merged into the array then all the numbers added from the right part are the smaller numbers after the added left element. Thus, every time we merge we count for each of the element the number of elements that are smaller and after them.<br>
time: O(nlogn)<br>
space: O(n)