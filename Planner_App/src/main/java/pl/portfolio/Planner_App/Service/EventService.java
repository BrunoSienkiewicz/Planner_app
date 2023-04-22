package pl.portfolio.Planner_App.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.portfolio.Planner_App.Model.Base.Event;
import pl.portfolio.Planner_App.Repository.EventRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getEventsForMonth(int year, int month) {
        LocalDateTime start = LocalDateTime.of(year, month, 1, 0, 0);
        LocalDateTime end = start.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        return eventRepository.findByDateBetween(start, end);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
}
