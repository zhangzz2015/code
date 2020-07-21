## Solution
Sort the array.<br>
To form a triangle we want to have two smaller length of sides sum up larger than the largest length of side.<br>
For three sides: x, y, z, we can make them in the orderof x <= y <= z, then we only need to make sure that x + y > z. -> find if there is any tuple, such thay i < j < k, and array[i] + array[j] > array[k].<br>
If we set k as fixed:<br>
for all k:<br>
find # of pairs of (i, j), i < j < k, array[i] + array[j] > array[k] -> 2 sum larger than target.<br>
time: O(nlogn + n^2) -> O(n^2)<br>
space: O(1)