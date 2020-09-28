# Find k closest elements to the target in BST.

## find the closest and go left and right
1. Search for the element closest to the target
2. AscIterator -> from smallest larget and DesIterator -> from largest smaller or equal. Add k elements into the res.

time: O(logn + k) - assume the BST is balanced<br>
space: O(logn)

## sliding window 
sliding window needs O(n) time