package calendar;

public class EventBuilder {
    private final CalendarBuilder calendarBuilder;
    private Event event;

    public EventBuilder(CalendarBuilder calendarBuilder, String name) {
        this.calendarBuilder = calendarBuilder;
        this.event = new Event(name, null, null, null, null);
    }

    public EventBuilder event(String name) {
        return this.calendarBuilder.event(name);
    }

    public EventBuilder on(int year, int month, int day) {
        this.event = new Event(
                this.event.getName(),
                this.event.getLocation(),
                new LocalDate(year, month, day),
                this.event.getStartTime(),
                this.event.getEndTime()
        );

        return this;
    }

    public EventBuilder from(String startTime) {
        this.event =
                new Event(
                        this.event.getName(),
                        this.event.getLocation(),
                        this.event.getDate(),
                        LocalTime.parse(startTime),
                        this.event.getEndTime()
                );

        return this;
    }

    public EventBuilder to(String endTime) {
        this.event =
                new Event(
                        this.event.getName(),
                        this.event.getLocation(),
                        this.event.getDate(),
                        this.event.getStartTime(),
                        LocalTime.parse(endTime)
                );

        return this;
    }

    public EventBuilder at(String location)
    {
        this.event =
                new Event(
                        this.event.getName(),
                        location,
                        this.event.getDate(),
                        this.event.getStartTime(),
                        this.event.getEndTime()
                );

        return this;
    }

    public Event getContent()
    {
        return this.event;
    }
}
