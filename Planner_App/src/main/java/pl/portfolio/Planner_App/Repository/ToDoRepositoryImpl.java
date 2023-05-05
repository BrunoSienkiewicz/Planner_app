package pl.portfolio.Planner_App.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import pl.portfolio.Planner_App.Model.Base.ToDo;

import java.util.List;

public abstract class ToDoRepositoryImpl implements ToDoRepository{
    @Autowired
    private EntityManager entityManager;

    public List<ToDo> findByStatus(String status)
    {
        String sql = "SELECT t FROM ToDo t WHERE t.status = ?1";
        final TypedQuery<ToDo> query = entityManager.createQuery(sql, ToDo.class);
        query.setParameter(1, status);
        return query.getResultList();
    }
}
