package pl.portfolio.Planner_App.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.portfolio.Planner_App.Repository.EventRepository;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventRepository eventRepository;
}
