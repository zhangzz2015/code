## [chunk transfer encoding](https://en.wikipedia.org/wiki/Chunked_transfer_encoding)
use the length of the string<br>
encode to format:<br>
length of string + special character(not a number) + original string

for both encode and decode:<br>
time: O(n)<br>
space: O(n)
## [Escape character](https://en.wikipedia.org/wiki/Escape_character)
when the splitter character appears we can encode that letter into:<br>
escapte character + splitter

for both encode and decode:<br>
time: O(n)<br>
space: O(n)

