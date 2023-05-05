package pl.portfolio.Planner_App.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import pl.portfolio.Planner_App.Model.Base.Event;

import java.time.LocalDateTime;
import java.util.List;

public abstract class EventRepositoryImpl implements EventRepository{
    @Autowired
    private EntityManager entityManager;
    public List<Event> findByDateBetween(LocalDateTime start, LocalDateTime end)
    {
        String sql = "select e from Event e where e.date between ?1 and ?2";
        final TypedQuery<Event> query = entityManager.createQuery(sql, Event.class);
        query.setParameter(1, start);
        query.setParameter(2, end);
        return query.getResultList();
    }
}
