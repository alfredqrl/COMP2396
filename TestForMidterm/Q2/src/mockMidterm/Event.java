package mockMidterm;

import java.util.ArrayList;

public class Event {
    String name;
    ArrayList<EventVenue> eventVenues;

    public Event(String name) {
        this.name = name;
        this.eventVenues = new ArrayList<EventVenue>();
    }

    public void addVenue(String name) {
        this.eventVenues.add(new EventVenue(name));
    }

    public EventVenue findEventVenue(String name) {
        for (EventVenue v : eventVenues) {
            if (v.getName().equals(name)) {
                return v;
            }
        }
        return null;
    }
}
