# You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

## requirements
- BrowserHistory(String homepage) Initializes the object with the homepage of the browser.
- void visiting(String url) visits url from the current page. it clears up all the forward history.
- String back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in the history at most steps.
- String forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.

## design detail
We want to store the x steps before the current url.<br>
x + 1 numbers of the url.<br>
We can use a circular array, thus we only need x + 1 space and use all of them without waste of space.<br>
int[] history of x + 1 url, x is the number of history we want to store, and 1 more space for the current.<br>
Because this is a circular array, we need an index to represent the current url we are visiting.<br>
Because in the back function, we cannot go to the x more steps, that means we really need to store more than x numbers of histories urls. Thus, we need a start index to indicate the start of urls in the circular array.<br>
Because visiting will clear up all the forward history, we also need an end index to indicate the most forward url in all the histories. And we need to update that to the current index when we visit another url.<br>
[xxxx 1]<br>
thus every method will be O(1)

