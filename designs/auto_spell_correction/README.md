# Given a collection of strings as dictionary, design a data structure that implements one API: return a list of strings of words that are in k edit distance of the giving target word comparing to words in the dictionary. The words should be in alphabetical order.

## Trie + dp
Using trie to store the words in the dictionary, and search in the trie. If there is word that have edit distance smaller than k then we can add that to the answer. We can use the same dp matrix if they have the same prefix.

time: O(all character * (target word length))<br>
space: (all character + longest word length * target word length)
