package mockMidterm;


import java.util.ArrayList;

public class Guest {
    String name;
    ArrayList<EventVenue> joinedEventVenues;

    public Guest(String name) {
        this.name = name;
        this.joinedEventVenues = new ArrayList<EventVenue>();
    }

    public void joinEvent(Event event, String venueName) {
        EventVenue venue = event.findEventVenue(venueName);

        if (venue != null) {
            joinedEventVenues.add(venue);
        }
    }

    public boolean hasCloseContactWith(Guest guest) {
        for (EventVenue v : joinedEventVenues) {
            if (guest.joinedEventVenues.contains(v)) {
                return true;
            }
        }
        return false;
    }
}

