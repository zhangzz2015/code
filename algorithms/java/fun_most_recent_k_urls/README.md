## Implement the browser’s most recent k visited urls features.
LRU cache<br>
The APIs we need are:<br>

public void update(String url): whenever we visit a new url we need to update with that url<br>
public List<String> getMostRecentK(): get all k most recent visited urls.<br>

for updating the url we would want to store and access the url so that we can update the order.<br>
Because we are maintaining the visited order of the urls so we can use a doubly linkedlist to maintain the access order, so that each time we update the order would be in O(1) time.

update(String url):<br>

	case1: the url is already in this cache
		find the value, and update the order in the doubly linked list
	case2: the url is not in this cache
		if the cache is already full:
			add that url in the hashmap
			delete the least recent url
			add that to the list with the right order
		if the cache is not full:
			add that url in the hashmap
			add that url to the list with the right order
getMostRecentK():<br>
	go through the doubly linked list in the order from the most recent url to the least recent url, and record each k value and return them

time:<br>
update: O(1)<br>
getMostRecentK: O(k)<br>
space:<br>
O(2k) -> O(k)