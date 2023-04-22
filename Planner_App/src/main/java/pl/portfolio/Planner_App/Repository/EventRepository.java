package pl.portfolio.Planner_App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.portfolio.Planner_App.Model.Base.Event;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end);
}
