## Given a very large log, each entry is an event of EC2 virtual machine start/terminate operation.<br>timestamp, instanceID, "start/terminate"<br>Given a time window [l, r], at most how many virtual machines are online at the same time?
e.g.<br>
1 1 started<br>
1 2 started<br>
2 3 started<br>
3 2 terminated<br>
4 1 terminated<br>
[2, 4]<br>
time is represented by the integer<br>
How is the timestamp being represented?<br>
Use a class to represent it.<br>
How is the log given? Is the LogEntry sorted by the time?<br>
log is List<LogEntry>, the entries are sorted by time<br>
The machines that are running through [l,r], if it starts on l or ends at r still count<br>
We can assume that every machine can only start once after it starts.



