package pl.portfolio.Planner_App.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.portfolio.Planner_App.Model.Base.Event;
import pl.portfolio.Planner_App.Model.Dto.CreateEventDto;
import pl.portfolio.Planner_App.Model.Dto.EventDto;
import pl.portfolio.Planner_App.Model.MyModelMapper;
import pl.portfolio.Planner_App.Repository.EventRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;
    MyModelMapper modelMapper = MyModelMapper.getInstance();

    public List<EventDto> getEventsForMonth(int year, int month) {
        LocalDateTime start = LocalDateTime.of(year, month, 1, 0, 0);
        LocalDateTime end = start.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
        List<Event> events =  eventRepository.findByDateBetween(start, end);

        List<EventDto> eventsDto = modelMapper.mapAll(events, EventDto.class);
        return eventsDto;
    }

    public List<EventDto> getEventsForDay(int year, int month, int day) {
        LocalDateTime start = LocalDateTime.of(year, month, day, 0, 0);
        LocalDateTime end = start.with(LocalTime.MAX);
        List<Event> events = eventRepository.findByDateBetween(start, end);

        List<EventDto> eventsDto = modelMapper.mapAll(events, EventDto.class);
        return eventsDto;
    }

    public Event createEvent(CreateEventDto eventDto) {
        Event eventEntity = modelMapper.map(eventDto, Event.class);
        return eventRepository.save(eventEntity);
    }

    public Event updateEvent(EventDto eventDto) {
        Event eventEntity = modelMapper.map(eventDto, Event.class);
        return eventRepository.save(eventEntity);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public EventDto getEventById(Long id) {
        Event event = eventRepository.findById(id).orElse(null);
        EventDto eventDto = modelMapper.map(event, EventDto.class);
        return eventDto;
    }

    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        List<EventDto> eventsDto = modelMapper.mapAll(events, EventDto.class);
        return eventsDto;
    }
}
