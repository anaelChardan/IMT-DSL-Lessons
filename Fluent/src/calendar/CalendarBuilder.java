package calendar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CalendarBuilder {
    private List<EventBuilder> eventBuilders = new ArrayList<>();


    public EventBuilder event(String name) {
        EventBuilder eventBuilder = new EventBuilder(this, name);
        this.eventBuilders.add(eventBuilder);

        return eventBuilder;
    }

    public Calendar getContent() {
        return new Calendar(eventBuilders.stream().map(EventBuilder::getContent).collect(Collectors.toList()));
    }
}
