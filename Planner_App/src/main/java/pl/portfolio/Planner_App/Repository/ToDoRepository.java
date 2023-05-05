package pl.portfolio.Planner_App.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.portfolio.Planner_App.Model.Base.ToDo;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    List<ToDo> findByStatus(String status);
}
