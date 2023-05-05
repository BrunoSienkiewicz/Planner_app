package pl.portfolio.Planner_App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.portfolio.Planner_App.Model.Dto.CreateEventDto;
import pl.portfolio.Planner_App.Model.Dto.EventDto;
import pl.portfolio.Planner_App.Service.EventService;

@RestController
@RequestMapping("api/v1/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/all")
    public ResponseEntity getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(eventService.getEventById(id));
    }

    @GetMapping("/{year}/{month}")
    public ResponseEntity getEventsForMonth(@PathVariable int year, @PathVariable int month) {
        return ResponseEntity.ok(eventService.getEventsForMonth(year, month));
    }

    @GetMapping("/{year}/{month}/{day}")
    public ResponseEntity getEventsForDay(@PathVariable int year, @PathVariable int month, @PathVariable int day) {
        return ResponseEntity.ok(eventService.getEventsForDay(year, month, day));
    }

    @PutMapping("/update")
    public ResponseEntity updateEvent(@RequestBody EventDto eventDto) {
        return ResponseEntity.ok(eventService.updateEvent(eventDto));
    }

    @PostMapping("/create")
    public ResponseEntity createEvent(@RequestBody CreateEventDto eventDto) {
        return ResponseEntity.ok(eventService.createEvent(eventDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.ok().build();
    }
}
