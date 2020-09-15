# Design and implement a new data structure that supports 4 APIs wiht time complexity O(1) time.<br> add(X): add a new element into it.<br> remove(X): remove an element from it if X is already in it.<br> find(X): find if X is in it, if not return null.<br> getRandomElement(): return a random element from it with equal probability.
Because we want to do find and remove in this data structure, we can consider hashMap for these APIs. Also we want to have a random element, thus we can maintain an array.<br>
- add(x)
    - add x into the array
    - add <x, index of x(array.length - 1)> into the hashMap
- remove(x)
    - check hashMap to find the index in the array
    - swap(index of x, array.length - 1)
    - remove in hash map and last element of array
- find(x)
    - find by hashMap
- getRandom()
    - call a random(array.length - 1)
    - return the element at that index
