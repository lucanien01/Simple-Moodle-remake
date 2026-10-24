package Classes;

import java.time.LocalDate;

public class Schedule {

    private LocalDate day;
    private double time;
    private String subject;
    private String room;

    public Schedule(LocalDate day, double time, String subject, String room) {
        this.day = day;
        this.time = time;
        this.subject = subject;
        this.room = room;
    }

    @Override
    public String toString() {
        return day + " | " + time + " | " + subject + " | Room: " + room;
    }
}