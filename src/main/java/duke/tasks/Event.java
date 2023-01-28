package duke.tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    private LocalDateTime start;
    private LocalDateTime end;

    public Event(String title, LocalDateTime start, LocalDateTime end, boolean done) {
        super(title, done);
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        String doneString = this.getDone() ? "X" : " ";
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy, HH:mm");
        return String.format("[E][%s] %s (from: %s, to: %s)", doneString, this.getTitle(),
                this.start.format(dateFormat), this.end.format(dateFormat));
    }

    public String convertToMemoryString() {
        String doneString = this.getDone() ? "1" : "0";
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("EEEE MMM dd yyyy HH:mm a");
        return "E, " + doneString + ", " + this.getTitle() + ", "
                + this.start.format(dateFormat) + ", " + this.end.format(dateFormat);
    }

}
