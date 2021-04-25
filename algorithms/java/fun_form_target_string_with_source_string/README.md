# You are given two strings A and B. Your aim is to form string A by concatenating multiple copies of string B. Also, before concatenating a copy of string B, you can remove any number of characters from it.<br> A = 'KAC'<br>B = 'JACK'<br>yes -> '###K' + '#AC#"

For each chatacter in A, we want to try to find the character in B.<br>
If the smallest index is larger than the index of the character before then we can use the same one word to form that.<br>
Otherwise, we need to start a new word with B.

time: O(m + n + m * logn)<br>
space: O(m)
