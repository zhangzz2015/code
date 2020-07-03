import java.util.List;

public class MostVirtualMachines {
    static class LogEntry {
        int timeStamp;
        int instanceID;
        String event;
        public LogEntry(int timeStamp, int instanceID, String event) {
            this.timeStamp = timeStamp;
            this.instanceID = instanceID;
            this.event = event;
        }
    }

    public int mostVirtualMachines(List<LogEntry> logEntries, int startTime, int endTime) {
        if (logEntries == null) {
            throw new IllegalArgumentException("logEntries cannot be null");
        }
        if (startTime > endTime) {
            throw new IllegalArgumentException(String.format("start time: %d cannot be larger than end time: %d", startTime, endTime));
        }
        int max = 0;
        int curNumber = 0;
        for (LogEntry logEntry : logEntries) {
            if (logEntry.timeStamp > endTime) {
                break;
            }
            if (logEntry.event.equals("start")) {
                curNumber++;
            } else {
                curNumber--;
            }
            if (logEntry.timeStamp >= startTime) {
                max = Math.max(max, curNumber);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MostVirtualMachines mostVirtualMachines = new MostVirtualMachines();
        LogEntry logEntry1 = new LogEntry(1, 1, "start");
        LogEntry logEntry2 = new LogEntry(2, 2, "start");
        LogEntry logEntry3 = new LogEntry(3, 2, "terminate");
        LogEntry logEntry4 = new LogEntry(4, 1, "terminate");
        System.out.println(mostVirtualMachines.mostVirtualMachines(List.of(logEntry1, logEntry2, logEntry3, logEntry4), 0, 4));
    }
}