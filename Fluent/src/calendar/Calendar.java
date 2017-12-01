package calendar;

import java.util.ArrayList;
import java.util.List;

public class Calendar {
	private ArrayList<Event> events = new ArrayList<>();
	
	public Calendar() {
	}

	public Calendar(List<Event> events)
	{
		this.events.addAll(events);
	}
	
	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public void addEvent(Event e){
		events.add(e);
	}
	
	public String toString(){
		String result = "calendar {\n";
		for (Event e:events) 
			result += e.toString()+"\n";
		result += "}";
		return result;
	}
}
