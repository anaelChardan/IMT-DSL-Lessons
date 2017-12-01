package calendar;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("Output of ugly method:");
		System.out.println(buildCalendarUgly());
		System.out.println("\n");
		System.out.println("Output of beautiful method:");
		System.out.println(buildCalendarBeautiful());

	}
	
	private static Calendar buildCalendarUgly(){
		Calendar calendar = new Calendar();
		Event event1 = new Event();
		event1.setName("DSL tutorial");
		event1.setDate(2009, 11, 8);
		event1.setStartTime("09:00");
		event1.setEndTime("16:00");
		event1.setLocation("Aarhus Music Hall");
		calendar.addEvent(event1);
		Event event2 = new Event();
		event2.setName("Making use of Patterns");
		event2.setLocation("Aarhus Music Hall");
		event2.setStartTime("14:15");
		event2.setEndTime("15:45");
		event2.setDate(2009, 10, 5);
		calendar.addEvent(event1);
		return calendar;
	}
	
	private static Calendar buildCalendarBeautiful(){
		
		CalendarBuilder calendarBuilder = new CalendarBuilder();

		calendarBuilder
			.event ("DSL tutorial")
				.on(2009, 11, 8)
				.from("09:00")
				.to("16:00")
				.at("Aarhus Music Hall")
			.event("Making use of Patterns")
				.on(2009, 10, 5)
				.from("14:15")
				.to("15:45")
				.at("Aarhus Music Hall");

		return calendarBuilder.getContent();
	}
}
